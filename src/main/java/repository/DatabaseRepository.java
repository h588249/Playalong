package repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DatabaseRepository<T> implements Repository<T> {
    @PersistenceContext(name = "playalongPU")
    private EntityManager manager;
    private Class<T> type;

    /**
     * Creates an entity
     *
     * @param entity
     * @return persisted database entity
     */
    @Override
    public T create(T entity) {
        manager.persist(entity);
        entity = manager.merge(entity);
        return entity;
    }

    /**
     * Creates many entities
     *
     * @param entities
     * @return persisted database entities
     */
    @Override
    public List<T> create(List<T> entities) {
        List<T> newEntities = new ArrayList<>();
        for (T entity : entities) {
            manager.persist(entity);
            newEntities.add(manager.merge(entity));
        }
        return newEntities;
    }

    /**
     * Deletes an entity
     *
     * @param entity
     */
    @Override
    public void delete(T entity) {
        if (manager.contains(entity)) {
            manager.remove(entity);
        }
    }

    /**
     * Deletes many entities
     *
     * @param entities
     */
    @Override
    public void delete(List<T> entities) {
        for (T entity : entities) {
            if (manager.contains(entity)) {
                manager.remove(entity);
            }
        }
    }

    /**
     * finds an entity based on the query
     *
     * @param query
     * @return the found entity
     */
    @Override
    public T get(String query) {
        TypedQuery<T> typedQuery = manager.createQuery(query, type);
        return typedQuery.getSingleResult();
    }

    /**
     * finds an entity based on the query
     *
     * @param query
     * @param pair  parameter for the query
     * @return the found entity
     */
    @Override
    public T get(String query, Pair<String, Object> pair) {
        TypedQuery<T> typedQuery = manager.createQuery(query, type);
        typedQuery.setParameter(pair.getFirst(), pair.getSecond());
        return typedQuery.getSingleResult();
    }

    /**
     * finds an entity based on the query
     *
     * @param query
     * @param pairs parameters for the query
     * @return the found entity
     */
    @Override
    public T get(String query, List<Pair<String, Object>> pairs) {
        TypedQuery<T> typedQuery = manager.createQuery(query, type);
        for (Pair<String, Object> pair : pairs) {
            typedQuery.setParameter(pair.getFirst(), pair.getSecond());
        }
        return typedQuery.getSingleResult();
    }

    /**
     * finds entity by id
     *
     * @param id
     * @return the entity
     */
    @Override
    public T getById(Object id) {
        return manager.find(type, id);
    }

    /**
     * finds entities based on the query
     *
     * @param query
     * @return the found entities
     */
    @Override
    public List<T> getList(String query) {
        TypedQuery<T> typedQuery = manager.createQuery(query, type);
        return typedQuery.getResultList();
    }

    /**
     * finds entities based on the query
     *
     * @param query
     * @param pair  parameter for the query
     * @return the found entities
     */
    @Override
    public List<T> getList(String query, Pair<String, Object> pair) {
        TypedQuery<T> typedQuery = manager.createQuery(query, type);
        typedQuery.setParameter(pair.getFirst(), pair.getSecond());
        return typedQuery.getResultList();
    }

    /**
     * finds entities based on the query
     *
     * @param query
     * @param pairs parameters for the query
     * @return the found entities
     */
    @Override
    public List<T> getList(String query, List<Pair<String, Object>> pairs) {
        TypedQuery<T> typedQuery = manager.createQuery(query, type);
        for (Pair<String, Object> pair : pairs) {
            typedQuery.setParameter(pair.getFirst(), pair.getSecond());
        }
        return typedQuery.getResultList();
    }

    /**
     * Updates the entity
     *
     * @param entity
     * @return the updated entity
     */
    @Override
    public T update(T entity) {
        return manager.merge(entity);
    }

    /**
     * updates the entities
     *
     * @param entities
     * @return the updated entities
     */
    @Override
    public List<T> update(List<T> entities) {
        List<T> newEntities = new ArrayList<>();
        for (T entity : entities) {
            newEntities.add(manager.merge(entity));
        }
        return newEntities;
    }

    @Override
    public void executeUpdateQuery(String updateQuery, Pair<String, String> pair){
        manager.createQuery(updateQuery).setParameter(pair.getFirst(), pair.getSecond()).executeUpdate();
    }

    /**
     * Defines the entity type for searches
     *
     * @param type
     */
    public void setType(Class<T> type) {
        this.type = type;
    }
}
