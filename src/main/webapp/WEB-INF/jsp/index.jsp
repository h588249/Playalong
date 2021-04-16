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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <link href="${pageContext.request.contextPath}/fontawesome/css/all.css" rel="stylesheet">
    <style>
        .modal-content {
            display: none;
        }

        #list {
            display: none;
        }

        form > div {
            width: 100%;
            height: 100%;
            text-align: center;
            overflow-y: scroll;
        }

        form {
            display: flex;
            flex-direction: column;
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
        <form id="search" name="search" action="search" method="post">
            <input type="text" name="searchText" id="searchText" class="input" placeholder="Search for songs"/>
            <div id="listSongs">
                <ul id="songList" class="hide">
                    <li>fake</li>
                </ul>
                <ul id="top10List" class="hide">
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
                <button type="submit" style="width: 100px;">press me</button>
            </form>
            <form action="createSong" method="post">
                <label>
                    Song name
                    <input type="text" name="song_name" required>
                </label>
                <label>
                    Artist name
                    <input type="text" name="artist_name" required>
                </label>
                <label>
                    Instrument
                    <input type="text" name="instrument" required>
                </label>
                <button type="submit" style="width: 100px;">press me</button>
            </form>
        </div>
        <div id="top10">

        </div>
    </main>
</body>
<jsp:include page="${pageContext.request.contextPath}/js/search_js.jsp" />
</html>
