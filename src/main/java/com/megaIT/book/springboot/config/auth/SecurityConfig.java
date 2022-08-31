package com.megaIT.book.springboot.config.auth;


import com.megaIT.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable() //csrf 안쓴다.
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/","/css/**","images/**","/js/**","h2-console/**","/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //api 유저만 볼수 있따.
                .and()
                .logout().logoutSuccessUrl("/")//로그아웃 또는 로그아웃 성공하면 첫번째 화면
                .and()
                .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }
}
