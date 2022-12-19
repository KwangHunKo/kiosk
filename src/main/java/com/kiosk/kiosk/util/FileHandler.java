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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Log4j2
public class FileHandler {

    public List<ImageUploadReq> imageUpload(List<MultipartFile> files) throws IOException {

        String path = "/file/image";
        File Folder = new File(path);

        if(!Folder.exists()){
            try{
                Folder.mkdir();
                log.info(path+" 경로에 폴더가 생성되었습니다.");
            }catch(Exception e){
                e.getStackTrace();
            }
        }

        List<ImageUploadReq> list = new ArrayList<>();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                ImageUploadReq req =
                        ImageUploadReq.builder().
                                uuid(UUID.randomUUID().toString())
                                .fineName(file.getOriginalFilename())
                                .contentType(file.getContentType())
                                .path(path)
                                .size(file.getSize())
                                .build();
                list.add(req);
                file.transferTo(Folder);
            }
        }

    return list;
    }
}
