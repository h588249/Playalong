package repository;

import java.util.List;

// CRUD
public interface Repository<T> {
    T create(T entity);

    List<T> create(List<T> entities);

    void delete(T entity);

    void delete(List<T> entities);

    T get(String query);

    T get(String query, Pair<String, Object> pair);

    T get(String query, List<Pair<String, Object>> pairs);

    T getById(Object id);

    List<T> getList(String query);

    List<T> getList(String query, Pair<String, Object> pair);

    List<T> getList(String query, List<Pair<String, Object>> pairs);

    T update(T entity);

    List<T> update(List<T> entities);

    void executeUpdateQuery(String updateQuery, Pair<String, String> pair);

    void setType(Class<T> type);
}
