package dat109.group12;

import javax.servlet.http.HttpServletRequest;

public class Utility {

    public static boolean is_logged_in(HttpServletRequest request)
    {
        if (request.getSession() != null)
            return request.getSession().getAttribute("user") != null;
        return false;
    }

}
