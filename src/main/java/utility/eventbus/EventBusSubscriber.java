package utility.eventbus;

public class EventBusSubscriber
{
    private final EventBus eventBus;

    public EventBusSubscriber()
    {
        this.eventBus = EventBus.getInstance();
    }

    public void subscribe(Subscriber subscriber)
    {
        eventBus.subscribe(subscriber);
    }

    public void unsubscribe(Subscriber subscriber)
    {
        eventBus.unsubscribe(subscriber);
    }
}
