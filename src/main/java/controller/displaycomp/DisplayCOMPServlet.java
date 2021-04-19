package controller.displaycomp;

import model.song.Song;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.NoSuchElementException;

import static utility.MappingUtility.*;
import static utility.ServletUtility.addStatusMessageToSession;
import static utility.ServletUtility.validate;

@WebServlet(name = "DisplayCOMPServlet", value = "/" + DISPLAY_URL)
public class DisplayCOMPServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(INDEX_URL);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!validate(req, resp, DISPLAY_URL)) {
            resp.sendRedirect(REGISTER_USER_URL);
            return;
        }

        HttpSession session = req.getSession(false);

        Object o = session.getAttribute("song");

        if (o == null || o.getClass() != Song.class) {
            addStatusMessageToSession(req, "Song object not found");
            resp.sendRedirect(INDEX_URL);
            return;
        }

        Song song = (Song) o;

        String dir = getServletContext().getRealPath("") + File.separator
                + "WEB-INF" + File.separator
                + "upload" + File.separator
                + song.getSongDirectory();

        Path image;

        try {
            String dirName = Files.walk(Paths.get(dir))
                    .filter(Files::isRegularFile)
                    .map(p -> p.toFile().getName())
                    .filter(s -> s.matches("(.*\\.pdf)$"))
                    .findAny().orElseThrow(NoSuchElementException::new).replaceAll("(\\.pdf)$", "");

            image = Files.walk(Paths.get(dir + File.separator + "images" + File.separator + dirName))
                    .filter(Files::isRegularFile)
                    .filter(p -> p.toFile().getName().matches(".*\\.(png)$"))
                    .findAny().orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            addStatusMessageToSession(req, "Notes were not found");
            resp.sendRedirect(INDEX_URL);
            return;
        }

        Path sound;

        try {
            sound = Files.walk(Paths.get(dir + File.separator + "sound"))
                    .filter(p -> Files.isRegularFile(p) && p.getFileName().toString().matches(".*\\.(mp3|wav|m4a|flac|wma|aac)$"))
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            addStatusMessageToSession(req, "Sound files were not found");
            resp.sendRedirect(INDEX_URL);
            return;
        }

        req.setAttribute("image", Base64.getEncoder().encodeToString(Files.readAllBytes(image)));
        req.setAttribute("sound", Base64.getEncoder().encodeToString(Files.readAllBytes(sound)));

        req.getRequestDispatcher(DISPLAY_PATH).forward(req, resp);
    }

}
