package controller.index;

import model.song.Song;
import org.apache.commons.text.StringEscapeUtils;
import repository.Repository;
import repository.song.SongDAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utility.MappingUtility.INDEX_PATH;
import static utility.ServletUtility.initialize;

@WebServlet(name = "IndexServlet", value = "/index")
public class IndexServlet extends HttpServlet {
    @EJB
    private Repository<Song> repository;

    private SongDAO songDAO = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        songDAO = (SongDAO) initialize(songDAO, new SongDAO(repository));

        String songList = songDAO.getAllSongs()
                .stream()
                .map(Song::getName)
                .map(StringEscapeUtils::escapeHtml4)
                .reduce("", (a, b) -> a + "#$" + b);
        request.setAttribute("songs", songList.substring(2));

        request.getRequestDispatcher(INDEX_PATH).forward(request, response);
    }
}
