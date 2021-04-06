package controller.admin;


import model.user.Role;
import model.user.User;
import repository.Repository;
import repository.admin.AdminDAO;

import static utility.MappingUtility.*;
import static utility.ServletUtility.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminPageServlet", value = "/Admin")
public class AdminPageServlet extends HttpServlet
{
    @EJB
    private Repository<User> userRepository;
    @EJB
    private Repository<Role> roleRepository;

    AdminDAO adminDAO = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        initialize(adminDAO, new AdminDAO(userRepository));

        if (!validate(request, response, ADMIN_URL))
        {
            response.sendRedirect(LOGIN_URL);
            return;
        }

        HttpSession session = request.getSession(false);

        if (!adminDAO.confirmAdmin(
                (String)session.getAttribute("user_username"),
                (String)session.getAttribute("user_email"),
                (Role)session.getAttribute("user_role")))
        {
            request.setAttribute("from", ADMIN_URL);
            request.setAttribute("errormessage", "User is not admin privileged.");
            response.sendRedirect(INDEX_URL);
            return;
        }

        request.getRequestDispatcher(ADMIN_PATH).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        initialize(adminDAO, new AdminDAO(userRepository));
        HttpSession session = request.getSession(false);



    }
}
