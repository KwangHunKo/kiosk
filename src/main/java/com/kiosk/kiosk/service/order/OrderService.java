package com.kiosk.kiosk.service.order;

import com.kiosk.kiosk.dto.order.NewOrderRequest;
import com.kiosk.kiosk.dto.order.OrderListResponse;
import com.kiosk.kiosk.entity.user.Member;

import java.util.List;
import java.util.Map;

public interface OrderService {

    void newOrder(List<NewOrderRequest> reqList, Member member);

    Map<Long, List<OrderListResponse>> orderList();

    void completeOrder(Long orderNo);
}
