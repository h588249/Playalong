package model.user;

import javax.persistence.*;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Entity(name = "user")
@Table(schema = "dat109_project", name = "usertable")
public class User
{
    @Id
    private String username;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    private String email;

    @Column(name = "display_name")
    private String displayName;
    private String password; // salt + hash

    public User(){}

    public User(String username, String email, String displayName, String password)
    {
        this.username = username;
        this.email = email;
        this.displayName = displayName;
        this.password = password;
    }

    public User(String username)
    {
        this.username = username;
    }

    public static User fromSession(HttpSession session)
    {
        return new User((String)session.getAttribute("user_username"));
    }

    public void toSession(HttpSession session)
    {
        session.setAttribute("user_username", username);
        session.setAttribute("user_email", email);
        session.setAttribute("user_role", role == null ? "" : role.getRole()); // PLACEHOLDER FOR NOW
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

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayname)
    {
        this.displayName = displayname;
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
                Objects.equals(this.displayName, user.displayName) &&
                Objects.equals(this.role, user.role) &&
                Objects.equals(this.password, user.password);
    }

    @Override
    public String toString()
    {
        return "[username: " + username + ", email: " + email + "]";
    }
}
