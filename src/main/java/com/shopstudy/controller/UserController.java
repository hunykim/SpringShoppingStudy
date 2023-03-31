package com.shopstudy.controller;

import com.shopstudy.domain.UserDto;
import com.shopstudy.service.SHA256;
import com.shopstudy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;


    @GetMapping("/userInfo/{id}")
    public UserDto userInfo(@PathVariable Long id) {
        return userService.userInfo(id);
    }


    @PostMapping("/userSave")
    public String userSave(UserDto user) throws NoSuchAlgorithmException {
        //SHA256으로 암호화
        SHA256 sha256 = new SHA256();

        String password = user.getPassword();
        String cryptogram = sha256.encrypt(password);

        user.setPassword(cryptogram);

        return userService.userSave(user);
    }



}
