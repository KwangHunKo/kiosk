package com.kiosk.kiosk.entity.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, String> {
    List<Orders> findByComplete(boolean b);

    List<Orders> findByOrderRow(Long orderNo);
}
