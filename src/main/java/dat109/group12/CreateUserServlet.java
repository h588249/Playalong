package dat109.group12;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateUserServlet", value = "/register")
public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/createuser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fornavn = request.getParameter("fornavn");
        String etternavn = request.getParameter("etternavn");

        String email = request.getParameter("email");
        String passord = request.getParameter("passord");

        User u = User.construct(email, passord, fornavn, etternavn);

        //Database.insert_user(u);

        request.getSession().setAttribute("user", u);

        response.sendRedirect("login.jsp");
    }
}
