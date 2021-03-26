# Iterations

-   Display COMP module
-   Import COMP module
-   Log in module
-   Log out module
-   Create user module
-   Admin page module
-   Search module (search for desired song)
-   Most played songs module

## Iteration 1

-   Log in module
    -   login.jsp for receiving data
    -   LoginServlet.java for processing data
-   Log out module
    -   LogoutServlet.java
    -   logout.jsp

## Iteration 2

-   Create user
    -   User.java
    -   createUser.jsp
    -   CreateUserServlet.java
    -   CreateUserDAO.java
-   Admin
    -   admin.jsp
    -   AdminPageServlet.java (database)

## Iteration 3

-   Display COMP
    -   display.jsp
    -   DisplayCompServlet.java
    -   songs.jsp
    -   Song.java
    -   SongDAO.java
-   Import COMP
    -   ImportServlet.java (database)

## Iteration 4

-   Search
    -   SearchServlet.java using songs.java to show songs matching search
    -   search.jsp
-   Most played
    -   MostPlayedSongsServlet.java
