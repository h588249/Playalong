package repository.createuser;

import model.user.User;
import repository.AbstractDAO;

public class CreateUserDAO extends AbstractDAO<User>
{
    public CreateUserDAO()
    {
        super(User.class);
    }
}
