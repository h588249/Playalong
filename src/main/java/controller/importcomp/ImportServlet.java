package controller.importcomp;

import model.song.Song;
import repository.Repository;
import repository.song.SongDAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static utility.MappingUtility.*;
import static utility.ServletUtility.*;

@WebServlet(name = "ImportServlet", value = "/" + IMPORT_URL)
public class ImportServlet extends HttpServlet {
    @EJB
    private Repository<Song> repository;

    private SongDAO dao = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(IMPORT_URL);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!validate(req, resp, IMPORT_URL)) {
            resp.sendRedirect(LOGIN_URL);
            return;
        }

        HttpSession session = req.getSession(false);

        Object o = session.getAttribute("song_name");

        if (o == null || o.getClass() != String.class) {
            addStatusMessageToSession(req, "song_name is either null or not a string");
            resp.sendRedirect(INDEX_URL);
            return;
        }

        dao = (SongDAO) initialize(dao, new SongDAO(repository));
        Song song = dao.findSongWithName((String) o);

        if (song == null) {
            addStatusMessageToSession(req, "No song with the name " + o);
            resp.sendRedirect(INDEX_URL);
            return;
        }

        session.setAttribute("song", song);

        resp.sendRedirect(DISPLAY_URL);
    }
}
