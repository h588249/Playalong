package utility.eventbus;

public interface Subscriber
{
    public void onEvent(Event<?> event);
}
