package controller.search;

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
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static utility.MappingUtility.*;
import static utility.ServletUtility.initialize;
import static utility.ServletUtility.validate;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @EJB
    private Repository<Song> repository;

    private SongDAO dao = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!validate(req, resp, SEARCH_URL)){
            resp.sendRedirect(LOGIN_URL);
            return;
        }

        String search = req.getParameter("search").trim();

        // Could remove this if searching for nothing should return every song
        if (Objects.equals(search, "")) {
            resp.sendRedirect(INDEX_URL);
            return;
        }

        dao = (SongDAO) initialize(dao, new SongDAO(repository));

        // If we want to send all songs as a request/session attribute and let front end do js
        List<Song> songs = dao.getAllSongs();

        // If we want to send just the songs that contains the search term
        List<Song> songsContainingSearchTerm = songs.stream()
                .filter(s -> s.getName().contains(search))
                .collect(Collectors.toList());

        HttpSession session = req.getSession(false);

        session.setAttribute("songs", songs);
        session.setAttribute("filteredSongs", songsContainingSearchTerm);

        resp.sendRedirect(SEARCH_URL);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(INDEX_PATH).forward(request, response);
    }
}
