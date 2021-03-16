package repository.login;


import model.user.User;
import repository.AbstractDAO;

public class LoginDAO extends AbstractDAO<User>
{
    public LoginDAO()
    {
        super(User.class);
    }
}
