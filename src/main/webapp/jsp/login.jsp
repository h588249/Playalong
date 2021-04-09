<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Login</title>
</head>
<body>

<div id="root">
    <form method="post" action="login">
        <div class="mainContainer">
            <h2 class="title">Login</h2>
            <a class="link" href="register">Register new participation</a>
            <label class="container">
                <span>Email:</span>
                <input type="text" name="email" id="email"/>
            </label>

            <span class="message"></span> <!-- Can be used for displaying error messages-->

            </br>
            <span class="message"></span> <!-- Can be used for displaying error messages-->


            <label class="container">
                <span>Password:</span>
                <input type="password" name="password" id="password" value/>
            </label>

            <span class="message">

            </span>


            <div class="containerButton">
                <button type="submit" class="submitButton">Login</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>