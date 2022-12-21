package com.kiosk.kiosk.dto.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
public class NewOrderRequest {

    @NotBlank(message = "메뉴지정에 실패했습니다.")
    private String name;

    @NotBlank(message = "수량이 잘못되었습니다.")
    private Long quantity;

    @NotBlank(message = "가격정보가 없습니다.")
    private Long price;
}
