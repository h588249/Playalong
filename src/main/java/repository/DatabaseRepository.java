package repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DatabaseRepository<T> implements Repository<T>
{
    @PersistenceContext(name = "playalongPU")
    private EntityManager manager;
    private Class<T> type;

    // DONE: implement create
    @Override
    public T create(T entity)
    {
        manager.persist(entity);
        entity = manager.merge(entity);
        return entity;
    }

    // DONE: implement create list
    @Override
    public List<T> create(List<T> entities)
    {
        List<T> newEntities = new ArrayList<>();
        for (T entity : entities)
        {
            manager.persist(entity);
            newEntities.add(manager.merge(entity));
        }
        return newEntities;
    }

    // TODO: implement delete
    @Override
    public void delete(T entity)
    {
        if (manager.contains(entity))
        {
            manager.remove(entity);
        }
    }

    // TODO: implement delete list
    @Override
    public void delete(List<T> entities)
    {
        for (T entity : entities)
        {
            if (manager.contains(entity))
            {
                manager.remove(entity);
            }
        }
    }

    // TODO: implement get
    @Override
    public T get(String query)
    {
        TypedQuery<T> typedQuery = manager.createQuery(query, type);
        return typedQuery.getSingleResult();
    }

    // TODO: implement get
    @Override
    public T get(String query, Pair<String, Object> pair)
    {
        TypedQuery<T> typedQuery = manager.createQuery(query, type);
        typedQuery.setParameter(pair.getFirst(), pair.getSecond());
        return typedQuery.getSingleResult();
    }

    // TODO: implement get
    @Override
    public T get(String query, List<Pair<String, Object>> pairs)
    {
        TypedQuery<T> typedQuery = manager.createQuery(query, type);
        for (Pair<String, Object> pair : pairs)
        {
            typedQuery.setParameter(pair.getFirst(), pair.getSecond());
        }
        return typedQuery.getSingleResult();
    }

    @Override
    public T getById(Object id)
    {
        return manager.find(type, id);
    }

    // TODO: implement getlist
    @Override
    public List<T> getList(String query)
    {
        TypedQuery<T> typedQuery = manager.createQuery(query, type);
        return typedQuery.getResultList();
    }

    // TODO: implement getlist
    @Override
    public List<T> getList(String query, Pair<String, Object> pair)
    {
        TypedQuery<T> typedQuery = manager.createQuery(query, type);
        typedQuery.setParameter(pair.getFirst(), pair.getSecond());
        return typedQuery.getResultList();
    }

    // TODO: implement getlist
    @Override
    public List<T> getList(String query, List<Pair<String, Object>> pairs)
    {
        TypedQuery<T> typedQuery = manager.createQuery(query, type);
        for (Pair<String, Object> pair : pairs)
        {
            typedQuery.setParameter(pair.getFirst(), pair.getSecond());
        }
        return typedQuery.getResultList();
    }

    // TODO: implement update
    @Override
    public T update(T entity)
    {
        return manager.merge(entity);
    }

    // TODO: implement update list
    @Override
    public List<T> update(List<T> entities)
    {
        List<T> newEntities = new ArrayList<>();
        for (T entity : entities)
        {
            newEntities.add(manager.merge(entity));
        }
        return newEntities;
    }

    public void setType(Class<T> type)
    {
        this.type = type;
    }
}
