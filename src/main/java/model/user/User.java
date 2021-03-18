package model.user;

public class User
{
    // id
    private int id;

    private Role role;

    private String email;
    private String username;
    private String displayname;
    private String password; // salt + hash
}
