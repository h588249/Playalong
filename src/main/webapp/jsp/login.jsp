<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Login</title>
</head>
<body>

<c:set var="invalid" value='${requestScope["invalid"]}'/>

<div id="root">
    <form method="post" action="login">
        <div class="mainContainer">
            <h2 class="title">Login</h2>
<<<<<<< HEAD:src/main/webapp/jsp/login.jsp

=======
            <a class="link" href="register">Register new participation</a>
>>>>>>> main:src/main/webapp/WEB-INF/login/login.jsp
            <label class="container">
                <span>Email:</span>
                </br>
                <input type="text" name="email" id="email" class="input"/>
            </label>
            </br>
            <span class="message"><c:out value='${requestScope["from"]}'/></span> <!-- Can be used for displaying error messages-->

            <label class="container">
                <span>Password:</span>
                </br>
                <input type="password" name="password" id="password" class="input" value/>
            </label>

            <span class="message">
                ${invalid ? "Invalid username and/or password" : ""}
            </span>


            <div class="containerButton">
                <button type="submit" class="submitButton">Login</button>
                <a href="createUser.jsp"><button type="button">Register</button></a>
            </div>
        </div>
    </form>
</div>
</body>
</html>