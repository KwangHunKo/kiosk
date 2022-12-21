package com.kiosk.kiosk.entity.user;

import com.kiosk.kiosk.Enum.Role;
import com.kiosk.kiosk.entity.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long memberNo;

    @Column(nullable = false)
    private String name;

    @Column
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String email, String name, Role role){
        setEmail(email);
        setName(name);
        setRole(role);
    }

    public Member update(String name){
        setName(name);
        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
