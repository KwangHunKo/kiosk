package com.kiosk.kiosk.service;

import com.kiosk.kiosk.dto.OAuthAttributes;
import com.kiosk.kiosk.entity.SessionUser;
import com.kiosk.kiosk.entity.user.Member;
import com.kiosk.kiosk.entity.user.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomOauth2UserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;
    private final HttpSession httpSession;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User> service = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = service.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        Member member = saveOrUpdate(attributes);
        httpSession.setAttribute("user", new SessionUser(member));

        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(member.getRoleKey())),
        attributes.getAttributes(), attributes.getNameAttributeKey());
    }

    private Member saveOrUpdate(OAuthAttributes attributes){

        Member member = memberRepository.findByEmail(attributes.getEmail())
                .map(entity ->
                        entity.update(attributes.getName()))
                .orElse(attributes.toEntity());

        return memberRepository.save(member);
    }
}
