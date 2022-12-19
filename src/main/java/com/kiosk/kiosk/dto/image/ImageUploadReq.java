package com.kiosk.kiosk.dto.image;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ImageUploadReq {
    private String uuid;
    private String fileName;
    private String contentType;
    private String path;
    private Long fileSize;

    @Builder
    public ImageUploadReq(String uuid, String fineName, String contentType, String path, Long size){
        setUuid(uuid);
        setFileName(fineName);
        setContentType(contentType);
        setPath(path);
        setFileSize(size);
    }

}
