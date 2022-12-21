package com.kiosk.kiosk.entity.menu;

import com.kiosk.kiosk.dto.menu.MenuAddReq;
import com.kiosk.kiosk.dto.menu.MenuModifyReq;
import com.kiosk.kiosk.entity.BaseTimeEntity;
import com.kiosk.kiosk.entity.image.Image;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
@Data
public class Menu extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long menuNo;

    @Column(nullable = false, unique = true)
    private String menuName;

    @Column(nullable = false)
    private Long price;

    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="imgNo", nullable = false)
    private Image image;


    public Menu(MenuAddReq req, Image image){
        setMenuName(req.getMenuName());
        setPrice(req.getPrice());
        setImage(image);
    }

    public void modify(MenuModifyReq req){
        if(!ObjectUtils.isEmpty(req.getModifyName())) {
            setMenuName(req.getModifyName());
        }

        if(!ObjectUtils.isEmpty(req.getPrice())) {
            setPrice(req.getPrice());
        }
    }

}
