package repository;

public class AbstractDAO<T>
{
    private DatabaseRepository<T> repository;

    public AbstractDAO(Class<T> type)
    {
        repository = new DatabaseRepository<>(type);
    }
}
