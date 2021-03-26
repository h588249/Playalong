package repository.admin;

import model.user.Role;
import model.user.User;
import repository.AbstractDAO;
import repository.Pair;
import repository.Repository;

import java.util.ArrayList;

public class AdminDAO extends AbstractDAO<User>
{
    public AdminDAO(Repository<User> repository)
    {
        super(User.class, repository);
    }

    public boolean confirmAdmin(String username, String email, Role role)
    {
        return repository.get(
                "SELECT u FROM User u" +
                        "WHERE u.username = :username" +
                        "AND u.email = :email" +
                        "AND u.role = :role",
                new ArrayList<Pair<String, Object>>()
                {{
                    new Pair<>("username", username);
                    new Pair<>("email", email);
                    new Pair<>("role", role);
                }}) != null;
    }
}
