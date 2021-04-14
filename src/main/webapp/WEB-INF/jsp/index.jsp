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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/main.css">
    <style>
        .modal-content {
            display: none;
        }

        #list {
            display: none;
        }
    </style>
</head>
<body>
<main>
    <h1>Welcome</h1>
    <label for="search">Search:</label>
    <input type="text" id="search" class="input" onkeyup="searchFunction()" name="search" placeholder="Search for songs"/>
    <form action="search" method="post">
        <div id="listSongs">
            <button type="submit">Press me</button>
            <ul id="songList">

            </ul>
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
    let songs = '${songs}'.replaceAll(/[\[\]]/g,"").split(", "); //change to a better solution when completed
    let search = document.getElementById("search");

    search.onclick = function(){
        console.log("page loaded.")
        songList = document.getElementById("songList");
        for (let song of songs){
            let child = document.createElement("li");
            child.innerHTML = song;
            songList.appendChild(child);

            
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
        var input, filter, ul, li, a, i, txtValue;
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