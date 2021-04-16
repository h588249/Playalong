package repository.registeruser;

import model.user.User;
import org.apache.commons.lang3.RandomStringUtils;
import repository.AbstractDAO;
import repository.Repository;
import utility.PasswordUtility;

public class RegisterUserDAO extends AbstractDAO<User>
{
    public RegisterUserDAO(Repository<User> repository)
    {
        super(User.class, repository);
    }

    public User construct(String username, String email, String password)
    {
        String uniqueName;
        do
        {
            uniqueName = username + "-" + RandomStringUtils.random(4, true, true);
        }
        while (repository.getById(uniqueName) != null); // this should only fetch once, if no unique name is found, it
        // will repeat as long as no unique is found.

        return repository.create(new User(uniqueName, email, username, PasswordUtility.encryptPassword(password)));
    }
}
