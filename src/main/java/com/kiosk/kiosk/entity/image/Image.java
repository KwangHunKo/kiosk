package com.kiosk.kiosk.entity.image;

import com.kiosk.kiosk.dto.image.ImageUploadReq;
import com.kiosk.kiosk.entity.BaseTimeEntity;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
public class Image extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long imgNo;

    @NotNull
    private String filePath;

    @NotNull
    private String contentType;

    @NotNull
    private String originalName;

    @NotNull
    private String uuid;

    private Long fileSize;

    @Builder
    public Image(ImageUploadReq req){
        setFilePath(req.getPath());
        setContentType(req.getContentType());
        setOriginalName(req.getFileName());
        setUuid(req.getUuid());
        setFileSize(req.getFileSize());
    }
}
