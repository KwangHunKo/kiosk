package com.kiosk.kiosk.service.menu;

import com.kiosk.kiosk.dto.menu.MenuAddReq;
import com.kiosk.kiosk.dto.menu.MenuModifyReq;
import com.kiosk.kiosk.entity.menu.Menu;
import com.kiosk.kiosk.entity.menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Log4j2
public class MenuServiceImpl implements MenuService{

    //레포지토리 호출
    private final MenuRepository menuRepository;


    //메뉴 추가하기
    @Override
    @Transactional
    public void addMenu(MenuAddReq req) {
        Menu newOne = new Menu(req);
        menuRepository.save(newOne);
    }

    //메뉴 수정하기
    @Override
    @Transactional
    public void modifyMenu(MenuModifyReq req) throws Exception {
        Menu getMenu = menuRepository.findByMenuName(req.getMenuName()).orElseThrow(Exception::new);
        getMenu.modify(req);
    }
}
