package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileHelper {
    // private final String UPLOAD_DIR = "/Users/rahul/Documents/workspace-spring-tool-suite-4-4.10.0.RELEASE/bootrestbook/src/main/resources/static/image";

    // Dynamic file location
    private final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public FileHelper() throws IOException{

    }

    public boolean uploadFile(MultipartFile file) {
        boolean f = false;
        try {
            // InputStream is = file.getInputStream();
            // byte data[] = new byte[is.available()];
            // is.read(data);

            // write
            // FileOutputStream fos = new
            // FileOutputStream(UPLOAD_DIR+"/"+file.getOriginalFilename());
            // or
            // FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator +
            // file.getOriginalFilename());
            // fos.write(data);
            // fos.flush();
            // fos.close();

            // or in a single line
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
}
