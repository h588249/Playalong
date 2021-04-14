package controller.removesong;

import model.song.Song;
import repository.Repository;
import repository.song.SongDAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import static utility.MappingUtility.*;
import static utility.ServletUtility.*;

@WebServlet(name = "RemoveSongServlet", value = "/" + REMOVE_SONG_URL)
public class RemoveSongServlet extends HttpServlet {
    @EJB
    private Repository<Song> repository;

    private SongDAO songDAO = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(INDEX_URL);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!libraryValidate(request, response, REMOVE_SONG_URL)) {
            response.sendRedirect(REGISTER_USER_URL);
            return;
        }

        String songName = request.getParameter("song_name");

        if (songName == null) {
            response.sendRedirect(INDEX_URL);
            return;
        }

        songDAO = (SongDAO) initialize(songDAO, new SongDAO(repository));

        Song song;
        if ((song = songDAO.findSongWithName(songName)) == null) {
            addStatusMessageToSession(request,
                    songName + " does not exist");
            response.sendRedirect(INDEX_URL);
            return;
        }

        String uploadPath = getServletContext()
                + File.separator + "WEB-INF"
                + File.separator + "upload"
                + File.separator + song.getSongDirectory();

        try {
            Files.walk(Paths.get(uploadPath))
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::deleteOnExit);

        } catch (IOException e) {
            e.printStackTrace();
            addStatusMessageToSession(request, "Error when deleting the files");
            return;
        }

        try {
            songDAO.removeSong(song);
        } catch (RuntimeException e) {
            addStatusMessageToSession(request,
                    "Error when removing the song");
            response.sendRedirect(INDEX_URL);
            return;
        }

        addStatusMessageToSession(request,
                "Successfully removed " + songName);
        response.sendRedirect(INDEX_URL);
    }
}
