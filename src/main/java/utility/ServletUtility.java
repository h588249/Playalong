package utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

import static utility.MappingUtility.LOGIN_URL;

public class ServletUtility
{
    public static Object initialize(Object nullable, Object initializer)
    {
        if (nullable == null)
        {
            nullable = initializer;
        }
        return nullable;
    }

    public static void invalidate(HttpSession session, HttpServletResponse response, String message) throws IOException
    {
        session.setAttribute("invalid", true);
        session.setAttribute("errormessage", message);
        response.sendRedirect(LOGIN_URL);
    }

    public static boolean validate(HttpServletRequest request, HttpServletResponse response, String from)
    {
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
            request.setAttribute("invalid", session.getAttribute("invalid") == null
                    ? false
                    : session.getAttribute("invalid"));

            session.invalidate();

            return false;
        }
        return true;
    }

}
