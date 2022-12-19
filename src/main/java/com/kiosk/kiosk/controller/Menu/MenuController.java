package com.kiosk.kiosk.controller.Menu;

import com.kiosk.kiosk.dto.menu.MenuAddReq;
import com.kiosk.kiosk.dto.menu.MenuModifyReq;
import com.kiosk.kiosk.service.menu.MenuServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/menu")
public class MenuController {

    private final MenuServiceImpl menuService;

    @PostMapping("/addNew")
    public void addNew(MenuAddReq req){
        try {
            menuService.addMenu(req);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @PutMapping("/modify")
    public void modifyMenu(MenuModifyReq req){
        try{
            menuService.modifyMenu(req);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
