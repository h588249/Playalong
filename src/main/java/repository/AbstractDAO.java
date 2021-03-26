package repository;

public abstract class AbstractDAO<T> {
    protected Repository<T> repository;

    public AbstractDAO(Class<T> type, Repository<T> repository) {
        this.repository = repository;
    }
}
