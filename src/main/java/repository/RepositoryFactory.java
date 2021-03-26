package repository;

import utility.Configuration;

public class RepositoryFactory<T>
{

    public Repository<T> createRepository(Class<T> type)
    {
        switch (Configuration.getRepositoryConfig())
        {
            case "database" :
                return new DatabaseRepository<>();
        }

        throw new UnsupportedOperationException("No such repository type: [" +
                Configuration.getRepositoryConfig() + "]");
    }
}
