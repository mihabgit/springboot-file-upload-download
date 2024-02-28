package com.mihab.fileuploaddownload;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
public class FileService {

    String folderPath = "/Users/imran/Downloads/uploads/";

    public void saveFile(MultipartFile file) {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        try {
            file.transferTo(new File(folderPath+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
