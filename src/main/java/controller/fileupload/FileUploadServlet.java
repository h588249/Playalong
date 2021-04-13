package controller.fileupload;

import utility.PDFToPng;

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

import static utility.MappingUtility.*;

@WebServlet(name = "FileUploadServlet", value = "/" + FILE_UPLOAD_URL)
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploadServlet extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "WEB-INF" + File.separator + "upload";

    private static final long serialVersionUID = 1L;

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "file.name";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String songName = request.getParameter("song_name");

        if (songName == null) {
            response.sendRedirect(INDEX_URL);
            return;
        }

        // TODO - Create song object(parameters from jsp) and save to db after everything has been executed successfully

        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY
                + File.separator + songName.replaceAll(" ", "_");

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
        getServletContext().getRequestDispatcher("/" + INDEX_PATH).forward(request, response);
    }
}
