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

        request.getRequestDispatcher(REGISTER_USER_PATH).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println(username);

        try
        {
            User user = new RegisterUserDAO(repository).construct(username, email, password);
            busPublisher.publish(new MessageEvent("Created user: [" + user.toString() + "]"));
        }
        catch (EJBException e)
        {
            String message = "Could not create user, try again later";
            busPublisher.publish(new MessageEvent(e.getMessage()));
            request.setAttribute("message", message);
            request.getRequestDispatcher(REGISTER_USER_PATH).forward(request, response);
        }

        //user.toSession(session);

        response.sendRedirect(INDEX_URL);
    }
}
