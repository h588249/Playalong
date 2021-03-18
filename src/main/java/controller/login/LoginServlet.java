package controller.login;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("email");
        String password = request.getParameter("password");

        //If a session exists invalidate it and create a new one
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        session = request.getSession(true);
        session.setMaxInactiveInterval(5);

        //Checks if there is something wrong with the inputs
        if (username == null || password == null)
        //|| !dao.exists(username)) DB stuff for later
        {
            session.setAttribute("invalid", true);

        } else {
            //Checks if the given password equals the stored password
            try {
                //pass = dao.getPassword(username); DB
                if (!password.equals("pass123") || !username.matches("[\\p{LD}]+@[\\p{L}]+\\.[\\p{Lower}]+")) //Proper checks later /\PasswordHelper.validate()
                    session.setAttribute("invalid", true);

            } catch (NoResultException e) {
                e.printStackTrace();
            }
        }

        //As long as the "invalid" attribute does not exist or is not equal to true
        if (session.getAttribute("invalid") == null || !session.getAttribute("invalid").equals(true)) {
            session.setAttribute("username", username);
            session.setAttribute("validated", true);
        }

        response.sendRedirect("login");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        //If there is no session present forward to login
        if (session == null) {
            request.setAttribute("from", "");
            request.getRequestDispatcher("login/login.jsp").forward(request, response);
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

            request.getRequestDispatcher("login/login.jsp").forward(request, response);

            return;
        }

        response.sendRedirect("demo.html");
    }
}
