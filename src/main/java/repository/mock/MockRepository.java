package repository.mock;

import repository.Pair;
import repository.Repository;

import java.util.List;

public class MockRepository<T> implements Repository<T>
{
    private final Class<T> type;

    public MockRepository(Class<T> type)
    {
        this.type = type;
    }

    @Override
    public T create(T entity)
    {
        return null;
    }

    @Override
    public List<T> create(List<T> entities)
    {
        return null;
    }

    @Override
    public void delete(T entity)
    {

    }

    @Override
    public void delete(List<T> entities)
    {

    }

    @Override
    public T get(String query)
    {
        return null;
    }

    @Override
    public T get(String query, Pair<String, Object> pair)
    {
        return null;
    }

    @Override
    public T get(String query, List<Pair<String, Object>> pairs)
    {
        return null;
    }

    @Override
    public T getById(Object id)
    {
        return null;
    }

    @Override
    public List<T> getList(String query)
    {
        return null;
    }

    @Override
    public List<T> getList(String query, Pair<String, Object> pair)
    {
        return null;
    }

    @Override
    public List<T> getList(String query, List<Pair<String, Object>> pairs)
    {
        return null;
    }

    @Override
    public T update(T entity)
    {
        return null;
    }

    @Override
    public List<T> update(List<T> entities)
    {
        return null;
    }
}
