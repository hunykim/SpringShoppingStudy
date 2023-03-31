package com.shopstudy.controller;

import com.shopstudy.domain.UserDto;
import com.shopstudy.config.jwt.JwtTokenProvider;
import com.shopstudy.service.OAuthService;
import com.shopstudy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final OAuthService oAuthService;

    // jwt를 이용한 로그인
    @PostMapping("/login")
    public String login(@RequestBody UserDto user) {

        user = userService.loginChk(user);
        if(user == null){
            return "회원정보가 없습니다.";
        } else{
            return jwtTokenProvider.createToken(user.getUsername(), Collections.singletonList(user.getRoles()));
        }
    }

    @GetMapping("/kakao-login")
    public String kakaoCallback(@RequestParam String code) {
        String accessToken = oAuthService.getKakaoAccessToken(code);
        Map<String, Object> userInfo = oAuthService.getUserInfo(accessToken);

        System.out.println("userInfo====" + userInfo);
        String email = String.valueOf(userInfo.get("email"));

        String result = "";

        if(email == null) {
            result = "이메일이 없습니다.";
        }else{
            UserDto user = userService.userIdChk(email);

            if(user.getEmail() != null) {
                String token = jwtTokenProvider.createToken(user.getUsername(), Collections.singletonList(user.getRoles()));
                Authentication tokenInfo = jwtTokenProvider.getAuthentication(token);
                result = "가입된 계정이 있습니다. 메인페이지로 리턴// "+ tokenInfo;
            } else{
                result = "가입된 계정이 없습니다. 회원가입 페이지로 리턴";
            }

        }

        return result;
    }



}
