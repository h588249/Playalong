<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<script>
    let list = document.getElementById("list");
    const songList = document.getElementById("songList");
    let songs = "${requestScope["songs"]}".split("#$"); //change to a better solution when completed
    let top10Songs = '${requestScope["top10Songs"]}'.split("#$");
    let search = document.getElementById("searchText");
    let top10List = document.getElementById("top10List");

    search.onfocus = function () {
        console.log("yo");
        top10List.classList.remove("hide");
        top10List.classList.add("show");
        for (let song of top10Songs) {
            if (song !== "") {
                let child = document.createElement("li");
                child.innerHTML = song;
                top10List.appendChild(child);
            }
        }
    }

    search.onblur = function () {
        console.log("bye");
        top10List.classList.remove("show");
        top10List.classList.add("hide");

    }

    search.oninput = function () {
        if (songList.classList.contains("hide")) {
            songList.classList.remove("hide");
            songList.classList.add("show");
        }
        if (top10List.classList.contains("hide")) {
            top10List.classList.add("hide");
            top10List.classList.remove("show");
        }

        while (songList.hasChildNodes()) {
            songList.removeChild(songList.firstChild);
        }

        if (search.value === "") {
            return;
        }
        for (let song of songs) {
            if (new RegExp("(" + search.value + ")").test(song.toLowerCase())) {
                if (songList.classList.contains("incorrect")) {
                    songList.classList.remove("incorrect");
                }
                let child = document.createElement("li");

                let input = document.createElement("input");
                input.type = "radio";
                input.value = song;
                input.name = "song_name";

                let label = document.createElement("label")
                label.classList.add("songListLabel")
                label.innerHTML = song
                label.appendChild(input)

                child.appendChild(label)

                songList.appendChild(child);
            } else {
                songList.classList.add("incorrect");
            }
        }

    }


    songList.onclick = function () {
        let songListLabel = document.getElementsByClassName("songListLabel");
        for (const n of songListLabel) {
            if (n.classList.contains("songListLabelChecked")) {
                n.classList.remove("songListLabelChecked")
            }
            n.childNodes.forEach(node => {
                    if (node.checked === true) {
                        n.classList.add("songListLabelChecked")
                    }
                }
            )
        }
    }

    /*
    function searchFunction(){
        let filter, ul, li, a, i, txtValue;
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
    */
</script>