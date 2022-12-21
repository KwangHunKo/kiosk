package com.kiosk.kiosk.entity.order;


import com.kiosk.kiosk.dto.order.NewOrderRequest;
import com.kiosk.kiosk.entity.BaseTimeEntity;
import com.kiosk.kiosk.entity.user.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.UUID;

@Entity
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class Orders extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long orderNo;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Long totalPrice;

    @Column(nullable = false)
    private Long orderRow;

    @Column(nullable = false, columnDefinition = "tinyint(0)")
    private boolean complete;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="memberNo", nullable = false)
    private Member member;

    public Orders(NewOrderRequest req, Member memeber, Long orderRow){
        setName(req.getName());
        setQuantity(req.getQuantity());
        setTotalPrice(req.getPrice());
        setMember(memeber);
        setOrderRow(orderRow);
    }

    public void completeOrder(boolean bool){
        setComplete(bool);
    }
}
