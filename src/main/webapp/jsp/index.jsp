<%--
  Created by IntelliJ IDEA.
  User: chronos
  Date: 09/03/2021
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <style>
        .modal-content{
            display: none;
        }

        #list{
            display: none;
        }
    </style>
</head>
<body>
<main>
    <div class="main">
        <div id="ham">
            <img src="C:\Users\mathi\Pictures\Dat109Project\icon.png" id="img" alt="HamburgerList">
        </div>
        <h1>Welcome</h1>
        <label for="search">Search:</label>
        <input type="text" id="search" class="input" />
        <div id="top10">

        </div>
    </div>
</main>
<aside>
    <div id="list">
        <p>Hei</p>
    </div>
</aside>
<script>
    let ham = document.getElementById("ham");
    let img = document.getElementById("img");
    let div = document.getElementById("top10");
    let list = document.getElementById("list");

    ham.onmouseenter = function(){
        img.src = 'imgs/iconShadow.png';
    }
    ham.onmouseleave = function(){
        img.src = 'imgs/icon.png';
    }
    ham.onclick = function(){
        list.style.display = "block";
    }
</script>
</body>
</html>