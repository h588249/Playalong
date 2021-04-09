package utility;

import utility.eventbus.Event;

public class MessageEvent implements Event<String>
{
    private String message;

    public MessageEvent(String message)
    {
        this.message = message;
    }

    @Override
    public String getData()
    {
        return message;
    }
}
