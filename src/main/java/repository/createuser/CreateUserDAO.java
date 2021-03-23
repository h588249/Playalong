package repository.createuser;

import model.user.User;
import repository.AbstractDAO;
import utility.PasswordUtility;

public class CreateUserDAO extends AbstractDAO<User>
{
    public CreateUserDAO()
    {
        super(User.class);
    }

    public synchronized User construct(String username, String email, String displayname, String password)
    {
        return repository.create(new User(username, email, displayname, PasswordUtility.encryptPassword(password)));
    }
}
