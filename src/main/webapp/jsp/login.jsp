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
            <a class="link" href="createUser.jsp">Register new participation</a>
            </br>
            <label class="container">
                <span>Email:</span>
                <input type="text" name="email" id="email" class="input"/>
            </label>
            </br>
            <span class="message"><c:out value='${requestScope["from"]}'/></span> <!-- Can be used for displaying error messages-->

            <label class="container"></br>
                <span>Password:</span>
                <input type="password" name="password" id="password" class="input" value/>
            </label>

            <span class="message">
                ${invalid ? "Invalid username and/or password" : ""}
            </span>


            <div class="containerButton">
                <button type="submit" class="submitButton">Login</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>