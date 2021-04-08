<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Admin</title>
</head>
<body>
<div id="root">
    <form method="post" action="admin">
        <div class="containerButton" id="container">
            <input type="file" class="input"/>
            <button class="remove" type="button">Remove</button>
            </br>
            <button type="button" id="add">Add files</button>
        </div>
        <c:forEach items="${file}" var="f">
            <input type="checkbox" id="${file.filename}" name="${file.filename}">
        </c:forEach>
        <c:forEach items="${user}" var="u">
            <input type="checkbox" id="${user.username}" name="${user.username}">
        </c:forEach>
        <select name="Actions">
            <option value="Promote">Promote</option>
            <option value="Demote">Demote</option>
        </select>
        <select name="Roles">
            <option value="Admin">Admin</option>
            <option value="Moderator">Moderator</option>
            <option value="Common">Regular</option>
        </select>
        <label class="container">
            <span>Change Name:</span>
            <input type="text" name="changeName" id="changeName" class="input"/>
        </label>
        <div class="containerButton">
            <button type="submit" class="submitButton">Submit changes</button>
        </div>
    </form>
</div>
<script>
    let btnAdd = document.getElementById("add");
    let btnCont = document.getElementById("container");
    let remove = document.getElementsByClassName("remove");
    let input = document.getElementsByClassName("input");

    btnAdd.onclick = function (){
        input = document.createElement("input");
        input.type = "file";
        b = document.createElement("br");
        rem = document.createElement("button");
        rem.type = "button";
        rem.innerText = "Remove";
        rem.class = "remove";
        btnCont.insertBefore(input,btnAdd);
        btnCont.insertBefore(rem,btnAdd);
        btnCont.insertBefore(b,btnAdd);
    }

    remove.onclick = function(){
        $('.input').remove();
        $('.remove').remove();
    }
</script>
</body>
</html>
