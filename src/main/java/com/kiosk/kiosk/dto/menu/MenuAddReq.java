package com.kiosk.kiosk.dto.menu;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MenuAddReq {

    @NotBlank(message = "메뉴의 이름을 알려주세요")
    private String menuName;
    @NotBlank(message = "메뉴 가격을 지정해주세요")
    private Long price;

    private MultipartFile files;

}
