package controller.login;

import model.song.Song;
import model.user.User;
import repository.Repository;
import repository.login.LoginDAO;
import repository.song.SongDAO;
import utility.PasswordUtility;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.stream.Collectors;

import static utility.MappingUtility.*;
import static utility.ServletUtility.initialize;
import static utility.ServletUtility.invalidate;

@WebServlet(name = "LoginServlet", value = "/"+ LOGIN_URL)
public class LoginServlet extends HttpServlet {
    @EJB
    private Repository<User> userRepository;

    @EJB
    private Repository<Song> songRepository;

    private LoginDAO loginDAO = null;
    private SongDAO songDAO = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //If a session exists invalidate it and create a new one
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        session = request.getSession(true);
        session.setMaxInactiveInterval(3600); //Placeholder tid

        //Checks if there is something wrong with the inputs
        if (email == null || password == null) {
            invalidate(session, response, "Email or password does not match our records");
            return;
        }

        loginDAO = (LoginDAO) initialize(loginDAO, new LoginDAO(userRepository));

        User user = loginDAO.getUserWithEmail(email);

        if (user == null) {
            invalidate(session, response, "Email or password does not match our records");
            return;
        }

        if (!PasswordUtility.checkPassword(password, user.getPassword())) {
            invalidate(session, response, "Email or password does not match our records");
            return;
        }

        user.toSession(session);
        session.setAttribute("validated", true);

        songDAO = (SongDAO) initialize(songDAO, new SongDAO(songRepository));

        session.setAttribute("songs",
                songDAO.getAllSongs().stream().map(Song::getName).collect(Collectors.toList()));

        response.sendRedirect(INDEX_URL);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        //If there is no session present forward to login
        if (session == null) {
            request.setAttribute("from", "");
            request.getRequestDispatcher(LOGIN_PATH).forward(request, response);
            return;
        }

        //If the session is not validated
        if (session.getAttribute("validated") == null
                || !session.getAttribute("validated").equals(true)) {

            //If the "invalid" attribute is null the value will be false or else it is the value of "invalid"
            request.setAttribute("invalid", session.getAttribute("invalid") == null
                    ? false
                    : session.getAttribute("invalid"));

            session.invalidate();

            request.getRequestDispatcher(LOGIN_PATH).forward(request, response);

            return;
        }

        // TODO: Change this when a main page has been implemented
        response.sendRedirect(INDEX_URL);
    }
}
