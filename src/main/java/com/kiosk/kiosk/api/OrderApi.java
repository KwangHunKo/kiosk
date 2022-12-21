package com.kiosk.kiosk.api;

import com.kiosk.kiosk.annotation.LoginUser;
import com.kiosk.kiosk.dto.order.NewOrderRequest;
import com.kiosk.kiosk.entity.SessionUser;
import com.kiosk.kiosk.entity.user.Member;
import com.kiosk.kiosk.entity.user.MemberRepository;
import com.kiosk.kiosk.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderApi {

    private final OrderService orderService;
    private final MemberRepository memberRepository;

    @PostMapping("/new")
    public void newOrder(@RequestBody@Valid List<NewOrderRequest> orderLi, HttpSession httpSession) throws Exception {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        log.info(user.getEmail());
        Member member = memberRepository.findByEmail(user.getEmail()).orElseThrow(Exception::new);
        orderService.newOrder(orderLi, member);

    }

    @PutMapping("/complete")
    public void completeOrder(@RequestParam HashMap req){// 하나만 받기때문에 효율성을 생각해서 해쉬맵으로 받음
        Long orderNo = Long.parseLong((String) req.get("orderNo"));
        orderService.completeOrder(orderNo);
    }

}
