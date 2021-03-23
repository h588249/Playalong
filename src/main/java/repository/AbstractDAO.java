package repository;

public class AbstractDAO<T>
{
    protected DatabaseRepository<T> repository;

    public AbstractDAO(Class<T> type)
    {
        repository = new DatabaseRepository<>(type);
    }
}
