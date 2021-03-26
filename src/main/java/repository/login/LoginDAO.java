package repository.login;


import model.user.User;
import repository.AbstractDAO;
import repository.Pair;
import repository.Repository;

public class LoginDAO extends AbstractDAO<User> {
    public LoginDAO(Repository<User> repository) {
        super(User.class, repository);
    }

    public User getUserWithEmail(String email) {
        return repository.get("select u from user u where u.email = :email", new Pair<>("email", email));
    }
}
