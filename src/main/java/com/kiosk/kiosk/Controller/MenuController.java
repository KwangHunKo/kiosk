package com.kiosk.kiosk.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
@Slf4j
public class MenuController {

    @GetMapping("/insert")
    public ModelAndView insertMenu(ModelAndView mav){
        log.info("뭔데대체");
        mav.setViewName("/menu/insert");
        return mav;
    }

}
