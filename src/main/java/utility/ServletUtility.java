package utility;

import model.user.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static utility.MappingUtility.LOGIN_URL;

public class ServletUtility {
    public static Object initialize(Object nullable, Object initializer) {
        if (nullable == null) {
            nullable = initializer;
        }
        return nullable;
    }

    public static void invalidate(HttpSession session, HttpServletResponse response, String message) throws IOException {
        session.setAttribute("invalid", true);
        session.setAttribute("errormessage", message);
        response.sendRedirect(LOGIN_URL);
    }

    public static boolean validate(HttpServletRequest request, HttpServletResponse response, String from) {
        HttpSession session = request.getSession(false);

        //If there is no session present forward to login
        if (session == null) {
            request.setAttribute("from", from);
            return false;
        }

        //If the session is not validated
        if (session.getAttribute("validated") == null
                || !session.getAttribute("validated").equals(true)) {

            //If the "invalid" attribute is null the value will be false or else it is the value of "invalid"
            request.setAttribute("invalid",
                    session.getAttribute("invalid") == null
                            ? false
                            : session.getAttribute("invalid"));

            session.invalidate();

            return false;
        }
        return true;
    }

    public static boolean libraryValidate(HttpServletRequest request, HttpServletResponse response, String from) {
        if (!validate(request, response, from))
            return false;

        Role role;
        return (role = (Role) (request.getSession(false)).getAttribute("user_role")) != null
                &&
                (role.equals(Role.ADMIN)
                        || role.equals(Role.MODERATOR)
                        || role.equals(Role.ARTIST));
    }

    public static void addStatusMessageToSession(HttpServletRequest request, String message) {
        HttpSession session;

        if ((session = request.getSession(false)) == null) return;

        session.setAttribute("message", message);
    }
}
