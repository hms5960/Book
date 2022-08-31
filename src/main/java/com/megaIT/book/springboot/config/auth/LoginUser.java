package com.megaIT.book.springboot.config.auth;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //생성될 수 있는 위치를 지정 -> 로그인 유저는 매개변수로 밖에 못함
@Retention(RetentionPolicy.RUNTIME) // 런타임시 실행
public @interface LoginUser {  //@interface 어노테이션 클래스 지정

}
