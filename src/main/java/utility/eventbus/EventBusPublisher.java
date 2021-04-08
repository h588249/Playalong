package utility.eventbus;

public class EventBusPublisher
{
    private final EventBus eventBus;

    public EventBusPublisher()
    {
        this.eventBus = EventBus.getInstance();
    }

    public void publish(Event<?> event)
    {
        eventBus.publish(event);
    }
}
