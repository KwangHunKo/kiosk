package com.kiosk.kiosk.dto;

import com.kiosk.kiosk.Enum.Role;
import com.kiosk.kiosk.entity.user.Member;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Map;

@Getter
@Data
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String email;
    private String name;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email){
        setAttributes(attributes);
        setNameAttributeKey(nameAttributeKey);
        setEmail(email);
        setName(name);
    }

    public static OAuthAttributes of(String socialName, String userNameAttributeName, Map<String, Object> attributes){
        if("kakao".equals(socialName)){
            return ofKakao(userNameAttributeName, attributes);
        }
        return null;
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes){

        Map<String, Object> kakao_account = (Map<String, Object>) attributes.get("kakao_account");  // 카카오로 받은 데이터에서 계정 정보가 담긴 kakao_account 값을 꺼낸다.

        return OAuthAttributes.builder()
                .email((String)kakao_account.get("email"))
                .name(kakao_account.get("name") == null ? "이름없음" : (String)kakao_account.get("name"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .email(email)
                .role(Role.USER)
                .build();
    }
}
