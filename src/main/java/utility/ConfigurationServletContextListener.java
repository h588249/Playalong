package utility;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConfigurationServletContextListener implements ServletContextListener
{
    public static String repository;

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        repository = sce.getServletContext().getInitParameter("repository");
    }
}
