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
    <link href="${pageContext.request.contextPath}/fontawesome/css/all.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<nav class="navbar">
    <ul class="navbar-nav">
        <li class="logo">
            <a href="#" class="nav-link">
                <img src="${pageContext.request.contextPath}/resources/logo.png" width="32" height="32"/>
                <%--                    <i class="fas fa-bars"></i>--%>
            </a>
        </li>
        <li class="nav-item">
            <a href="#" class="nav-link">
                <i class="fas fa-play"></i>
                <span class="link-text">Music</span>
            </a>
        </li>
        <li class="nav-item">
            <a href="#" class="nav-link">
                <i class="fas fa-file-audio"></i>
                <span class="link-text">Upload</span>
            </a>
        </li>
        <li class="nav-item">
            <a href="#" class="nav-link">
                <i class="fas fa-sliders-h"></i>
                <span class="link-text">Settings</span>
            </a>
        </li>
    </ul>
</nav>
<main>
    <h1>Welcome</h1>
    <label for="search">Search:</label>
    <input type="text" id="search" class="input" name="search"/>
    <form action="search" method="post">
        <div id="listSongs">

            <button type="submit">Press me</button>
        </div>
    </form>
    <div>
        <form action="upload" method="post" enctype="multipart/form-data">
            <label>
                Song name
                <input type="text" name="song_name" required>
            </label>
            <input type="file" name="file" required>
            <button type="submit">press me</button>
        </form>
    </div>
    <div id="top10">

    </div>
</main>
<script>
    let img = document.getElementById("img");
    let div = document.getElementById("top10");
    let list = document.getElementById("list");

    let listSongs = document.getElementById("listSongs");
    let songs = '${songs}'.replaceAll(/[\[\]]/g, "").split(", "); //change to a better solution when completed
    let search = document.getElementById("search");

    search.onclick = function () {
        console.log("page loaded.")
        for (let song of songs) {
            let temp = document.createElement("input");
            temp.name = "select_song";
            temp.type = "radio";
            temp.value = song;

            let label = document.createElement("label");
            label.innerHTML = song;

            listSongs.appendChild(temp);
            listSongs.appendChild(label);

        }
    }
</script>
</body>
</html>
