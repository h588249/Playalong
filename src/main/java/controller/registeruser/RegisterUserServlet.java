package controller.registeruser;


import model.user.User;
import repository.Repository;
import repository.registeruser.RegisterUserDAO;
import utility.MessageEvent;
import utility.eventbus.EventBusPublisher;

import static utility.MappingUtility.*;
import static utility.LoginValidator.*;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateUserServlet", value = "/" + REGISTER_USER_URL)
public class RegisterUserServlet extends HttpServlet
{
    @EJB
    private Repository<User> repository;

    private EventBusPublisher busPublisher = new EventBusPublisher();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);

        if (session == null) {
            request.setAttribute("from", "");
            request.getRequestDispatcher(REGISTER_USER_PATH).forward(request, response);
            return;
        }

        if (session.getAttribute("validated") == null
                || !session.getAttribute("validated").equals(true)) {

            //If the "invalid" attribute is null the value will be false or else it is the value of "invalid"
            request.setAttribute("invalid", session.getAttribute("invalid") == null
                    ? false
                    : session.getAttribute("invalid"));

            session.invalidate();

            request.getRequestDispatcher(REGISTER_USER_PATH).forward(request, response);

            return;
        }

        response.sendRedirect(INDEX_URL);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        session = request.getSession(true);
        session.setMaxInactiveInterval(3600); //Placeholder tid

        try
        {
            User user = new RegisterUserDAO(repository).construct(username, email, password);
            busPublisher.publish(new MessageEvent("Created user: [" + user.toString() + "]"));

            user.toSession(session);
            session.setAttribute("validated", true);
        }
        catch (EJBException e)
        {
            String message = "Could not create user, try again later";
            busPublisher.publish(new MessageEvent(e.getMessage()));
            request.setAttribute("message", message);
            request.getRequestDispatcher(REGISTER_USER_PATH).forward(request, response);
        }

        response.sendRedirect(INDEX_URL);
    }
}
