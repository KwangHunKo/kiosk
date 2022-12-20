package com.kiosk.kiosk.dto.menu;

import com.kiosk.kiosk.entity.menu.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuListRes {
    private String name;
    private Long price;
    private String image;

    public MenuListRes(Menu m) {
        String imagePath = m.getImage().getFilePath() +"/"+m.getImage().getOriginalName();
        setName(m.getMenuName());
        setPrice(m.getPrice());
        setImage(imagePath);
    }
}
