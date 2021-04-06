package model.user;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(schema = "dat109_project", name = "role")
public class Role
{
    public static final Role ADMIN = new Role("Admin");
    public static final Role MODERATOR = new Role("Moderator");
    public static final Role REGULAR = new Role("Regular");

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

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Role role = (Role)obj;
        return Objects.equals(this.role, role.role);
    }
}
