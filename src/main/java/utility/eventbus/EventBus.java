package utility.eventbus;

import java.util.HashSet;
import java.util.Set;

public class EventBus
{
    private static EventBus instance;

    private EventBus(){}

    private final Set<Subscriber> subscribers = new HashSet<>();

    public static EventBus getInstance()
    {
        if (instance == null)
        {
            instance = new EventBus();
        }
        return instance;
    }

    public void publish(Event<?> event)
    {
        for (Subscriber subscriber : subscribers)
        {
            subscriber.onEvent(event);
        }
    }

    public void subscribe(Subscriber subscriber)
    {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber)
    {
        subscribers.remove(subscriber);
    }
}
