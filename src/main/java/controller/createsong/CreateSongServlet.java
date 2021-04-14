package controller.createsong;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import static utility.ServletUtility.*;
import static utility.MappingUtility.CREATE_SONG_URL;
import static utility.MappingUtility.INDEX_URL;

@WebServlet(name = "CreateSongServlet", value = "/" + CREATE_SONG_URL)
public class CreateSongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(INDEX_URL);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!libraryValidate(req, resp, CREATE_SONG_URL)){
            resp.sendRedirect(INDEX_URL);
            return;
        }

        String songName = req.getParameter("song_name"),
                artistName = req.getParameter("artist_name"),
                instrument= req.getParameter("isntrument");
        
    }
}
