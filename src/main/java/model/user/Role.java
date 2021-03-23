package model.user;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role
{
    @Id
    private String role;

    @OneToMany
    private List<User> users;

    public Role(){}

    public Role(String role)
    {
        this.role = role;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public List<User> getUsers()
    {
        return users;
    }
}
