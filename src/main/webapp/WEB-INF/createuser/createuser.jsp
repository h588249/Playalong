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
    <style>
        body {
            width: 60%;
            margin: 5px auto;
            padding: 10px;
        }

        .input{
            padding: 3px;
            margin: 5px;
        }

    </style>
</head>
<body>
<h2>Sign up</h2>
<div id="container">
    <form method="post" action="register" class="form">
        <fieldset>
            <label for="username">Username:</label></br>
            <input type="text" name="username" class="input" id="username" value="Olav"/>
            </br>
            <label for="mail">Email:</label></br>
            <input type="email" name="email" id="mail" class="input" value="Olav@Testing.no">
            </br>
            <label for="displayname">Displayname:</label></br>
            <input type="text" name="displayname" id="displayname" class="input" value="Testing">
            </br>
            <label for="password">Password:</label></br>
            <input type="password" name="password" id="password" class="input" value="test123"/>
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