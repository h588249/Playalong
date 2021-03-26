package repository.createuser;

import model.user.User;
import repository.AbstractDAO;
import repository.DatabaseRepository;
import repository.Repository;
import utility.PasswordUtility;

public class CreateUserDAO extends AbstractDAO<User> {

    public CreateUserDAO(Repository<User> repository) {
        super(User.class, repository);
    }

    public synchronized User construct(String username, String email, String displayname, String password) {
        return repository.create(new User(username, email, displayname, PasswordUtility.encryptPassword(password)));
    }
}
