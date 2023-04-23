package com.shopstudy.controller;

import com.shopstudy.config.jwt.JwtTokenProvider;
import com.shopstudy.domain.UserDto;
import com.shopstudy.domain.UserLoginDto;
import com.shopstudy.service.OAuthService;
import com.shopstudy.service.SHA256;
import com.shopstudy.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final OAuthService oAuthService;

    @ApiOperation(value = "회원정보")
    @GetMapping("/userInfo/{id}")
    public UserDto userInfo(@PathVariable Long id) {
        return userService.userInfo(id);
    }

    @ApiOperation(value = "회원가입")
    @PostMapping("/userSave")
    public String userSave(UserDto user) throws NoSuchAlgorithmException {
        //SHA256으로 암호화
        SHA256 sha256 = new SHA256();

        String password = user.getPassword();
        String cryptogram = sha256.encrypt(password);

        user.setPassword(cryptogram);

        return userService.userSave(user);
    }

    // jwt를 이용한 로그인
    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@RequestBody UserLoginDto user, HttpServletResponse response) throws NoSuchAlgorithmException {
        SHA256 sha256 = new SHA256();
        String password = sha256.encrypt(user.getPassword());
        user.setPassword(password);

        Map<String,Object> map = new HashMap<>();

        UserDto userInfo = userService.loginChk(user);

        if(userInfo == null){
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        } else{
            String token = jwtTokenProvider.createToken(userInfo.getUsername(), Collections.singletonList(userInfo.getRoles()));
            map.put("user", userInfo);
            map.put("token", token);

            response.setHeader("X-AUTH-TOKEN",token);

            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }


    @GetMapping("/kakao-login")
    public String kakaoCallback(@RequestParam String code) {
        String accessToken = oAuthService.getKakaoAccessToken(code);
        Map<String, Object> userInfo = oAuthService.getUserInfo(accessToken);

        System.out.println("userInfo====" + userInfo);
        String email = String.valueOf(userInfo.get("email"));
        String name = String.valueOf(userInfo.get("name"));

        String result = "";

        // https://kauth.kakao.com/oauth/authorize?client_id=6f7dba6b2f23512fc5f06f113f9389cf&redirect_uri=http://localhost:8080/kakao-login&response_type=code

        UserDto user = userService.userIdChk(email);

        if(user.getEmail() != null) {
//            String token = jwtTokenProvider.createToken(user.getUsername(), Collections.singletonList(user.getRoles()));

            result = "가입된 계정이 있습니다. 메인페이지로 리턴// ";
        } else{

            result = "가입된 계정이 없습니다. 회원가입 페이지로 리턴";
        }

        return result;
    }


    @PostMapping(value = "/kakaoLogout")
    public String kakaoLogout(HttpServletRequest resquest) throws IOException {

        String accessToken = resquest.getHeader("Authorization");

        oAuthService.getUserLogout(accessToken);


        return "로그아웃 성공";
    }


}
