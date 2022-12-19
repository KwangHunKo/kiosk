package com.kiosk.kiosk.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
@Log4j2
public class MenuController {

    @GetMapping("/insert")
    public ModelAndView insertMenu(ModelAndView mav){
        mav.setViewName("/menu/insert");
        return mav;
    }

}
