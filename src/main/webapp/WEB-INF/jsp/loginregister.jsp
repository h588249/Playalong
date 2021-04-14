<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    <title>Login/Register</title>
</head>
<body class="loginbody">
<h1>Welcome to Playalong!</h1>
<div class="container" id="container">
    <div class="form-container register-container">
        <form name="register" method="post" action="register"
              onsubmit="validateRegisterAll()">
            <h1>REGISTER</h1>
            <input type="text" name="username" id="register_username"
                   oninput="validateRegisterUsername()" placeholder="Username" required/>
            <input type="email" name="email" id="register_email"
                   oninput="validateRegisterEmail()" placeholder="Email" required/>
            <input type="password" name="password" id="register_password"
                   oninput="validateRegisterPassword()" placeholder="Password" required/>
            <input type="password" name="passwordRep" id="register_passwordRep"
                   oninput="validateRegisterPassword()" placeholder="Repeat Password" required/>
            <button type="submit">Register</button>
        </form>
    </div>
    <div class="form-container login-container">
        <form name="login" method="post" action="login"
              onsubmit="validateLoginAll()">
            <h1>LOGIN</h1>
            <input type="email" name="email" id="login_email"
                   oninput="validateLoginEmail()" placeholder="Email" required>
            <input type="password" name="password" id="login_password"
                   oninput="validateLoginPassword()" placeholder="Password" required>
            <button type="submit">Login</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h2>HELLO FRIEND!</h2>
                <span>Login to start listening to wonderful music!</span>
                <button class="ghost" id="login">Login</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h2>WELCOME FRIEND!</h2>
                <span>Register for access to awesome music!</span>
                <button class="ghost" id="register">Register</button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/loginregistration.js"></script>
<script src="${pageContext.request.contextPath}/js/validator.js"></script>
</html>
