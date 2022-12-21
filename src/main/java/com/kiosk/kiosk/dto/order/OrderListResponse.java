package com.kiosk.kiosk.dto.order;

import com.kiosk.kiosk.entity.order.Orders;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
public class OrderListResponse {

    private String menu;
    private Long qty;
    private Long Row;
    private Long price;
    private Long member;
    private boolean complete;
    private String orderTime;

    public OrderListResponse(Orders order) {
        setMenu(order.getName());
        setQty(order.getQuantity());
        setRow(order.getOrderRow());
        setPrice(order.getTotalPrice());
        setMember(order.getMember().getMemberNo());
        setComplete(order.isComplete());
        setOrderTime(order.getCreatedDate().toString());
    }
}
