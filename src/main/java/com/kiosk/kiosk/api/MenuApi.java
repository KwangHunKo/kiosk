package com.kiosk.kiosk.api;

import com.kiosk.kiosk.dto.menu.MenuAddReq;
import com.kiosk.kiosk.dto.menu.MenuModifyReq;
import com.kiosk.kiosk.service.menu.MenuServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/menu")
public class MenuApi {

    private final MenuServiceImpl menuService;

    @PostMapping("/addNew")
    public void addNew(MenuAddReq req){
        log.info(req);
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

    @DeleteMapping("/delete")
    public void deleteMenu(String menu){
        try{
            menuService.deleteMenu(menu);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
