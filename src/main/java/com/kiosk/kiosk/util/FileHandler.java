package com.kiosk.kiosk.util;

import com.kiosk.kiosk.dto.image.ImageUploadReq;
import com.kiosk.kiosk.entity.image.Image;
import com.kiosk.kiosk.entity.image.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Log4j2
public class FileHandler {

    public ImageUploadReq imageUpload(MultipartFile file) throws IOException {
        String sysPath = System.getProperty("user.dir");
        String path = sysPath+"/image";
        File Folder = new File(path);

        if (!Folder.exists()) {
            try {
                Folder.mkdir();
                log.info("폴더 확인");
            } catch (Exception e) {
                log.info("폴더가 없습니다.");
            }
        }


        if (!file.isEmpty()) {
            ImageUploadReq req =
                    ImageUploadReq.builder().
                            uuid(UUID.randomUUID().toString())
                            .fineName(file.getOriginalFilename())
                            .contentType(file.getContentType())
                            .path(path)
                            .size(file.getSize())
                            .build();
            File f = new File(path+"/"+req.getFileName());
            file.transferTo(f);

            return req;
        }else{
            return null;
        }
    }
}
