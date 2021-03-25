package repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DatabaseRepository<T> implements Repository<T> {
    @PersistenceContext(name = "playalongPU")
    private EntityManager em;

    // TODO: implement create
    @Override
    public T create(T entity) {
        em.persist(entity);
        return entity;
    }

    // TODO: implement create list
    @Override
    public List<T> create(List<T> entities) {
        return null;
    }

    // TODO: implement delete
    @Override
    public void delete(T entity) {

    }

    // TODO: implement delete list
    @Override
    public void delete(List<T> entities) {

    }

    // TODO: implement get
    @Override
    public T get(String query) {
        return null;
    }

    // TODO: implement get
    @Override
    public T get(String query, Pair<String, Object> pair) {
        return null;
    }

    // TODO: implement get
    @Override
    public T get(String query, List<Pair<String, Object>> pairs) {
        return null;
    }

    @Override
    public T getById(Object id) {
        return null;
    }

    // TODO: implement getlist
    @Override
    public List<T> getList(String query) {
        return null;
    }

    // TODO: implement getlist
    @Override
    public List<T> getList(String query, Pair<String, Object> pair) {
        return null;
    }

    // TODO: implement getlist
    @Override
    public List<T> getList(String query, List<Pair<String, Object>> pairs) {
        return null;
    }

    // TODO: implement update
    @Override
    public T update(T entity) {
        return null;
    }

    // TODO: implement update list
    @Override
    public List<T> update(List<T> entities) {
        return null;
    }
}
