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

@WebServlet(name = "SearchServlet", value = "/"+ SEARCH_URL)
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!validate(req, resp, SEARCH_URL)){
            resp.sendRedirect(LOGIN_URL);
            return;
        }

        String select_song = req.getParameter("select_song");

        if (select_song == null || (select_song = select_song.trim()).isEmpty()) {
            resp.sendRedirect(INDEX_URL);
            return;
        }

        HttpSession session = req.getSession(false);
        session.setAttribute("song_name", select_song);

        resp.sendRedirect(IMPORT_URL);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(INDEX_URL);
    }
}
