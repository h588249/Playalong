package controller.createuser;


import model.user.User;
import repository.createuser.CreateUserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateUserServlet", value = "/register")
public class CreateUserServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("HERE?");

        request.getRequestDispatcher("createuser/createuser.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HERE2?");
        String username = request.getParameter("username");
        String displayname = request.getParameter("displayname");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println(username + ", " + displayname + ", " + email + ", " + password);

        User u = new CreateUserDAO().construct(username, email, displayname, password);

        request.getSession().setAttribute("user", u);

        response.sendRedirect("login.jsp");
    }
}
