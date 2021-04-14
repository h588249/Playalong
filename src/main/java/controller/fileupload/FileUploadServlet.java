package controller.fileupload;

import model.song.Song;
import model.user.Role;
import repository.Repository;
import repository.song.SongDAO;
import utility.PDFToPng;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static utility.MappingUtility.FILE_UPLOAD_URL;
import static utility.MappingUtility.INDEX_URL;
import static utility.ServletUtility.libraryValidate;
import static utility.ServletUtility.validate;

@WebServlet(name = "FileUploadServlet", value = "/" + FILE_UPLOAD_URL)
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploadServlet extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "WEB-INF" + File.separator + "upload";

    private static final long serialVersionUID = -242147305764279714L;

    @EJB
    private Repository<Song> repository;

    private SongDAO songDAO = null;

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "file.name";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (!libraryValidate(request, response, FILE_UPLOAD_URL)) {
            response.sendRedirect(INDEX_URL);
            return;
        }

        String songName = request.getParameter("song_name");

        if (songName == null) {
            response.sendRedirect(INDEX_URL);
            return;
        }

        songDAO = (SongDAO) utility.ServletUtility.initialize(songDAO, new SongDAO(repository));

        Song song;

        if ((song = songDAO.findSongWithName(songName)) == null) {
            //Send error message
            response.sendRedirect(INDEX_URL);
            return;
        }

        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY
                + File.separator + song.getSongDirectory();

        String soundUpload = uploadPath + File.separator + "sound";

        File soundDir = new File(soundUpload);
        if (!soundDir.exists())
            soundDir.mkdirs();

        try {
            String fileName = "";
            for (Part part : request.getParts()) {
                fileName = getFileName(part).replaceAll(" ", "_");

                // Compile regex in init() for better performance
                if (fileName.matches(".*\\.(mp3|wav|m4a|flac|wma|aac)$")) {
                    part.write(soundUpload + File.separator + fileName);
                    continue;
                }

                if (!fileName.endsWith(".pdf")) continue;

                part.write(uploadPath + File.separator + fileName);

                PDFToPng.convert(uploadPath + File.separator + "images"
                                + File.separator + fileName.replaceAll("(\\.pdf)$", ""),
                        new File(uploadPath + File.separator + fileName));

            }
            request.setAttribute("message", "File " + fileName + " has uploaded successfully!");

        } catch (FileNotFoundException fne) {
            request.setAttribute("message", "There was an error: " + fne.getMessage());
        }
        response.sendRedirect(INDEX_URL);
    }
}
