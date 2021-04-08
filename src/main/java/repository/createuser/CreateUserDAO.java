package repository.createuser;

import model.user.User;
import org.apache.commons.lang.RandomStringUtils;
import repository.AbstractDAO;
import repository.Repository;
import utility.PasswordUtility;

public class CreateUserDAO extends AbstractDAO<User>
{
    public CreateUserDAO(Repository<User> repository)
    {
        super(User.class, repository);
    }

    public synchronized User construct(String username, String email, String displayname, String password)
    {
        String uniqueName;
        do
        {
            uniqueName = username + "-" + RandomStringUtils.random(4, true, true);
        }
        while (repository.getById(uniqueName) != null); // this should only fetch once, if no unique name is found, it
        // will repeat as long as no unique is found.

        return repository.create(new User(uniqueName, email, displayname, PasswordUtility.encryptPassword(password)));
    }
}
