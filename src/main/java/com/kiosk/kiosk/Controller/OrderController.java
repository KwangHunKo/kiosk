package com.kiosk.kiosk.Controller;

import com.kiosk.kiosk.dto.order.OrderListResponse;
import com.kiosk.kiosk.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/list")
    public String orderList(Model model){
        model.addAttribute("list", orderService.orderList());
        return "/order/list";
    };

}
