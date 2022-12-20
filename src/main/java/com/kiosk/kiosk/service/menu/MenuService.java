package com.kiosk.kiosk.service.menu;


import com.kiosk.kiosk.dto.menu.MenuAddReq;
import com.kiosk.kiosk.dto.menu.MenuListRes;
import com.kiosk.kiosk.dto.menu.MenuModifyReq;

import java.io.IOException;
import java.util.List;

public interface MenuService {

    void addMenu(MenuAddReq req) throws IOException;

    void modifyMenu(MenuModifyReq req) throws Exception;

    void deleteMenu(String menu) throws Exception;

    List<MenuListRes> getList();
}
