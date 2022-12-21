package com.kiosk.kiosk.config;

import com.kiosk.kiosk.Controller.OAuth2SuccessHandler;
import com.kiosk.kiosk.service.CustomOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private final CustomOauth2UserService customOauth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/menu/list").authenticated()
                .anyRequest().permitAll()
                .and()
                .logout().logoutSuccessUrl("/menu/insert")
                .and()
                .oauth2Login().userInfoEndpoint().userService(customOauth2UserService)
                .and()
                .successHandler(successHandler());
    }
    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new OAuth2SuccessHandler("/menu/list");
    }
}
