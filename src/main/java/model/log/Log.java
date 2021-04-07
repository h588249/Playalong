package model.log;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "dat109_project", name = "log")
public class Log
{
    public final static String ERROR = "ERROR";
    public final static String MESSAGE = "MESSAGE";
    public final static String WARNING = "WARNING";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Long timestamp;
    private String messageType;
    private String message;

    public Log(){}
    private Log(String message)
    {
        this(message, MESSAGE);
    }
    private Log(String message, String messageType)
    {
        timestamp = System.currentTimeMillis();
        this.message = message;
        this.messageType = messageType;
    }

    public int getId()
    {
        return id;
    }

    public String getMessageType()
    {
        return messageType;
    }

    public String getMessage()
    {
        return message;
    }

    public Long getTimestamp()
    {
        return timestamp;
    }

    public static Log errormessage(String message)
    {
        return new Log(message, ERROR);
    }

    public static Log message(String message)
    {
        return new Log(message);
    }

    public static Log warningmessage(String message)
    {
        return new Log(message, WARNING);
    }
}
