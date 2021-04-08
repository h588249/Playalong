package utility;

import model.log.Log;
import repository.Repository;
import utility.eventbus.*;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConfigurationServletContextListener implements ServletContextListener, Subscriber
{
    private EventBusSubscriber busSubscriber = new EventBusSubscriber();
    private EventBusPublisher busPublisher = new EventBusPublisher();
    public static String repository;

    @EJB
    private Repository<Log> messageRepository;

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
        busPublisher.publish(new MessageEvent("Server stopped."));
    }

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        repository = sce.getServletContext().getInitParameter("repository");
        busSubscriber.subscribe(this);
        busPublisher.publish(new MessageEvent("Server started."));
    }

    @Override
    public void onEvent(Event<?> event)
    {
        if (event.getClass().equals(MessageEvent.class))
        {
            messageRepository.create(Log.message(((MessageEvent) event).getData()));
        }
    }

    private void Initialize()
    {

    }
}
