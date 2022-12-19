package com.kiosk.kiosk.service.menu;


import com.kiosk.kiosk.dto.menu.MenuAddReq;
import com.kiosk.kiosk.dto.menu.MenuModifyReq;

public interface MenuService {

    void addMenu(MenuAddReq req);

    void modifyMenu(MenuModifyReq req) throws Exception;
}
