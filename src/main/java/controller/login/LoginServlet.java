package controller.login;

import model.user.User;
import repository.Repository;
import repository.login.LoginDAO;
import utility.PasswordUtility;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @EJB
    private Repository<User> repo;

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
        session.setMaxInactiveInterval(3600);

        LoginDAO dao = new LoginDAO(repo);

        //Checks if there is something wrong with the inputs
        if (email == null || password == null) {
            invalid(session, response);
            return;
        }

        User user = dao.getUserWithEmail(email);

        if (user == null) {
            invalid(session, response);
            return;
        }

        if (!PasswordUtility.checkPassword(password, user.getPassword())) {
            invalid(session, response);
            return;
        }

        //As long as the "invalid" attribute does not exist or is not equal to true

        session.setAttribute("email", email);
        session.setAttribute("validated", true);

        response.sendRedirect("login");
    }

    private void invalid(HttpSession session, HttpServletResponse response) throws IOException {
        session.setAttribute("invalid", true);
        response.sendRedirect("login");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        //If there is no session present forward to login
        if (session == null) {
            request.setAttribute("from", "");
            request.getRequestDispatcher("WEB-INF/login/login.jsp").forward(request, response);
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

            request.getRequestDispatcher("WEB-INF/login/login.jsp").forward(request, response);

            return;
        }

        //Change this when a main page has been implemented
        response.sendRedirect("index.jsp");
    }
}
