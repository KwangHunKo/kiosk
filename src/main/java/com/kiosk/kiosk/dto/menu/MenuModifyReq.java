package com.kiosk.kiosk.dto.menu;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MenuModifyReq {

    private String menuName;
    private String modifyName;
    private Long price;

}
