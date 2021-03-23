package repository;

import repository.mock.MockRepository;
import utility.Configuration;

public class RepositoryFactory<T>
{

    public Repository<T> createRepository(Class<T> type)
    {
        switch (Configuration.getRepositoryConfig())
        {
            case "mock" :
                return new MockRepository<>(type);
            case "database" :
                return new DatabaseRepository<>(type);
        }

        throw new UnsupportedOperationException("No such repository type: [" +
                Configuration.getRepositoryConfig() + "]");
    }
}
