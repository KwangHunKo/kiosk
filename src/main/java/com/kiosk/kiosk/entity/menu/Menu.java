package com.kiosk.kiosk.entity.menu;

import com.kiosk.kiosk.dto.menu.MenuAddReq;
import com.kiosk.kiosk.dto.menu.MenuModifyReq;
import com.kiosk.kiosk.entity.BaseTimeEntity;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.ObjectUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
@Data
public class Menu extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuNo;

    @NotNull
    private String menuName;

    @NotNull
    private Long price;

    public Menu(MenuAddReq req){
        setMenuName(req.getMenuName());
        setPrice(req.getPrice());
    }

    public void modify(MenuModifyReq req){
        if(!ObjectUtils.isEmpty(req.getMenuName())) {
            setMenuName(req.getMenuName());
        }

        if(!ObjectUtils.isEmpty(req.getPrice())) {
            setPrice(req.getPrice());
        }
    }

}
