package com.kiosk.kiosk.Enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROER_USER", "일반사용자");

    private final String key;
    private final String title;
}
