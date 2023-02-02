package mvc.controller.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class FileUploadController {
    @Autowired
    ServletContext servletContext;

    @RequestMapping(value="/homeUpload",method= RequestMethod.GET)
    public String home() {
        return "book/upload";
    }

    @RequestMapping(value="/uploadFile", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    String uploadFileHandler(@RequestParam("file") MultipartFile file ) {
        try {
            byte[] bytes = file.getBytes();

            // Creating the directory to store file
            // Assume uploaded file location on web server is D:\file-upload
            String pathName = servletContext.getRealPath("/resources/upload/");
            File dir = new File(pathName);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // Create the file on server
            // Get path + file + name and save sourceFile into serverFile
            String fileSource = dir.getAbsolutePath() + File.separator + file.getOriginalFilename();
            File serverFile = new File(fileSource);

            // A new buffered
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();

            return "You uploaded successfully a file, at : " + fileSource;

        } catch(Exception e) {
            System.out.println(e);
            return "Error when uploading file" + e;
        }

    }
}
