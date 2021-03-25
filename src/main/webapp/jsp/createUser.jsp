<%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 23.03.2021
  Time: 10.23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<h2>Sign up</h2>
<div id="container">
    <form method="post" action="register" class="form">
        <fieldset>
            <label for="firstname">Firstname:</label></br>
            <input type="text" name="firstname" class="input" id="firstname"/>
            </br>
            <label for="lastname">Surname:</label></br>
            <input type="text" name="lastname" id="lastname" class="input"/>
            </br>
            <label for="address">Address:</label></br>
            <input type="text" name="address" id="address" class="input">
            </br>
            <label for="mail">Mail:</label></br>
            <input type="email" name="mail" id="mail" class="input">
            </br>
            <label for="username">Username:</label></br>
            <input type="text" name="username" id="username" class="input">
            </br>
            <label for="tlf">Mobile (8 ):</label></br>
            <input type="text" name="tlf" id="tlf" class="input"/>
            </br>
            <label for="password">Password:</label></br>
            <input type="password" name="password" id="password" class="input"/>
            </br>
            <label for="passwordRep">Password repeated:</label></br>
            <input type="password" name="passwordRep" id="passwordRep" class="input"/>
            </br>
            <button type="submit">Create user</button>
        </fieldset>
    </form>
</div>
</body>
</html>
