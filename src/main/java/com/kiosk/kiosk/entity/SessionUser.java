package com.kiosk.kiosk.entity;

import com.kiosk.kiosk.entity.user.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class SessionUser implements Serializable {
    private String name;
    private String email;

    public SessionUser(Member member){
        setName(member.getName());
        setEmail(member.getEmail());
    }
}
