package com.kiosk.kiosk.Controller;

import com.kiosk.kiosk.service.menu.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
@Slf4j
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/insert")
    public String insertMenu(){
        return "/menu/insert";
    }

    @GetMapping("/list")
    public String menuList(Model model){
        model.addAttribute("menus", menuService.getList());
        return "/menu/list";
    }
}
