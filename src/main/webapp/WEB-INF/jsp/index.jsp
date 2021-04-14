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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    <link href="${pageContext.request.contextPath}/fontawesome/css/all.css" rel="stylesheet">
    <style>
        .modal-content {
            display: none;
        }

        #list {
            display: none;
        }

        form > div{
            width: 100%;
            height: 100%;
            text-align: center;
            overflow-y: scroll;
        }
    </style>
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
        <input type="text" id="search" class="input" onkeyup="searchFunction()" name="search" placeholder="Search for songs"/>
        <form action="search" method="post">
            <div id="listSongs">
                <ul id="songList">

                </ul>

            </div>
                <button type="submit">Search</button>
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
    let songs = '${requestScope["song"]}'.replaceAll(/[\[\]]/g,"").split(", "); //change to a better solution when completed
    let search = document.getElementById("search");

    search.onclick = function(){
        search.innerHTML = "";
        let songList = document.getElementById("songList");
        for (let song of songs){
            if(song !== ""){
                let child = document.createElement("li");
                child.innerHTML = song;
                songList.appendChild(child);
            }

            /*
            let temp = document.createElement("input");
            temp.name = "select_song";
            temp.type = "radio";
            temp.value = song;

            let label = document.createElement("label");
            label.innerHTML = song;

            listSongs.appendChild(temp);
            listSongs.appendChild(label);
            */
        }
    }

    function searchFunction(){
        let input, filter, ul, li, a, i, txtValue;
        input = document.getElementById('search');
        filter = input.value.toUpperCase();
        ul = document.getElementById("songList");
        li = ul.getElementsByTagName('li');

        for (i = 0; i < li.length; i++){
            a = li[i].getElementsByTagName("a")[0];
            txtValue = a.textContent || a.innerText;
            if(txtValue.toUpperCase().indexOf(filter) > -1) {
                li[i].style.display = "";
            } else {
                li[i].style.display = "none";
            }
        }
    }
</script>
</body>
</html>
