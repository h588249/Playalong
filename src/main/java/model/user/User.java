package model.user;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "user")
@Table(schema = "dat109_project", name = "usertable")
public class User
{
    @Id
    private String username;

    @ManyToOne
    private Role role;

    private String email;
    private String displayname;
    private String password; // salt + hash

    public User(){}

    public User(String username, String email, String displayname, String password)
    {
        this.username = username;
        this.email = email;
        this.displayname = displayname;
        this.password = password;
    }


    public String getUsername()
    {
        return username;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getDisplayname()
    {
        return displayname;
    }

    public void setDisplayname(String displayname)
    {
        this.displayname = displayname;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        User user = (User)obj;
        return Objects.equals(this.username, user.username) &&
                Objects.equals(this.email, user.email) &&
                Objects.equals(this.displayname, user.displayname) &&
                Objects.equals(this.role, user.role) &&
                Objects.equals(this.password, user.password);
    }
}
