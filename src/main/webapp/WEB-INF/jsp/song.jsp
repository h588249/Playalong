<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Playalong</title>
    <style>
        #banner{
            border: 5px outset #000000;
            background-color: rgb(0, 255, 135);
            height: 100px;
        }

        #maindiv{
            margin-top: 5px;
            border: 5px outset black;
        }

        #searchbar{
            text-align: center;
            margin-top: 35px;
        }

        #profileimg{
            float:right;
            margin-top: 20px;
            margin-right: 20px;
            overflow: hidden;
            border-radius: 50%;
        }

        #logo{
            border: 5px outset black;
            background-color: white;
            float:left;
            margin-top: 20px;
            margin-left: 20px;
        }

        #noteimg{
            display: block;
            margin-left: auto;
            margin-right: auto;
            width: 30%;
        }

        #playbutton{
            float: left;
            width: 10%;
            height: auto;
        }

        #pausebutton{
            float: left;
            width: 10%;
            height: auto;
        }

    </style>
</head>
<body>
<div id = banner>
    <div id = "logo">
        <p>Playalong</p>
    </div>
    <div id = "profileimg">
        <img src="https://i.pinimg.com/originals/10/8d/c8/108dc8c72c460f9a48a0b959a2bdafc9.jpg" alt="Profile" width="60" height="60">
    </div>
    <div id = "searchbar">
        <input type = "text" id = "srch" name = "srch" placeholder = "Search" size = "50"><br><br>
    </div>
</div>
<div id= "maindiv">
    <div id = "playbutton" value="play">
        <img id="button" src="https://i.pinimg.com/originals/ef/07/47/ef07471474a0e1086a185086c342ae00.jpg" width="50%" height="auto">
    </div>
    <div id= "noteimg">

    </div>
</div>

<script>
    let notes = '${notes}';
    let audio = new Audio('${audio.sound}');
    let play = document.getElementById("playbutton");
    let imgDiv = document.getElementById("noteimg");

    document.onload = function (){
        note = document.createElement("img");
        note.id = "notes";
        note.src = "notes";
        imgDiv.appendChild(note);
    }

    play.onclick = function(){
        if(play.value == "play"){
            audio.play();
            play.value = "pause";
        }
        else{
            audio.pause();
            play.value = "play";
        }

    }
</script>

</body>
</html>