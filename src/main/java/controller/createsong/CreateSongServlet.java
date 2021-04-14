package controller.createsong;

import model.song.Song;
import repository.Repository;
import repository.song.SongDAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utility.MappingUtility.*;
import static utility.ServletUtility.initialize;
import static utility.ServletUtility.libraryValidate;

@WebServlet(name = "CreateSongServlet", value = "/" + CREATE_SONG_URL)
public class CreateSongServlet extends HttpServlet {
    @EJB
    private Repository<Song> repository;

    private SongDAO songDAO = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(INDEX_URL);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!libraryValidate(req, resp, CREATE_SONG_URL)) {
            resp.sendRedirect(REGISTER_USER_URL);
            return;
        }

        String songName = req.getParameter("song_name"),
                artistName = req.getParameter("artist_name"),
                instrument = req.getParameter("instrument");

        songDAO = (SongDAO) initialize(songDAO, new SongDAO(repository));

        try {
            if (songDAO.findSongWithName(songName) != null) {
                resp.sendRedirect(INDEX_URL);
                return;
            }
        } catch (RuntimeException ignored) {
        }

        songDAO.insert(new Song(songName, artistName, instrument));
        resp.sendRedirect(INDEX_URL);
    }
}
