package repository.admin;

import model.user.Role;
import model.user.User;
import repository.AbstractDAO;
import repository.Pair;
import repository.Repository;
import utility.MessageEvent;
import utility.eventbus.EventBusPublisher;

import java.util.ArrayList;

public class AdminDAO extends AbstractDAO<User>
{
    EventBusPublisher publisher = new EventBusPublisher();

    public AdminDAO(Repository<User> repository)
    {
        super(User.class, repository);
    }

    public boolean confirmAdmin(User user)
    {
        user = repository.getById(user.getUsername());

        return user.getRole().equals(Role.ADMIN);
    }
}
