package com.kiosk.kiosk.service.order;

import com.kiosk.kiosk.dto.order.NewOrderRequest;
import com.kiosk.kiosk.dto.order.OrderListResponse;
import com.kiosk.kiosk.entity.order.Orders;
import com.kiosk.kiosk.entity.order.OrdersRepository;
import com.kiosk.kiosk.entity.user.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrdersRepository ordersRepository;
    private Long orderRow = 0L;
    @Transactional
    @Override
    public void newOrder(List<NewOrderRequest> reqList, Member memeber) {

        for(NewOrderRequest order : reqList) {
            Orders orders = new Orders(order, memeber, orderRow);
            ordersRepository.save(orders);
        }
        orderRow++;
    }

    @Override
    public Map<Long, List<OrderListResponse>> orderList() {
        List<Orders> orders = ordersRepository.findByComplete(false);
        List<OrderListResponse> orderList = new ArrayList<>();

        for(Orders order : orders){
            orderList.add(new OrderListResponse(order));
        }

        return orderList.stream().collect(Collectors.groupingBy(OrderListResponse::getRow));
    }

    @Transactional
    @Override
    public void completeOrder(Long orderNo) {
        List<Orders> orderList = ordersRepository.findByOrderRow(orderNo);
        for(Orders order : orderList){
            order.completeOrder(true);
        }
    }

    @Transactional
    @Override
    public void deleteOrder(Long orderNo) {
        List<Orders> orderList = ordersRepository.findByOrderRow(orderNo);
        ordersRepository.deleteAll(orderList);
    }
}
