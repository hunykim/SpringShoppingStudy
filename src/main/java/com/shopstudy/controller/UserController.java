package com.shopstudy.controller;

import com.shopstudy.domain.UserDto;
import com.shopstudy.service.SHA256;
import com.shopstudy.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @ApiOperation(value = "총 회원목록")
    @GetMapping("/listAll")
    public ResponseEntity<?> listAll() {

        List<UserDto> listAll = userService.listAll();

        return ResponseEntity.ok(listAll) ;
    }

    @ApiOperation(value = "총 회원수")
    @GetMapping("/listCount")
    public int listCount() {
        return userService.listCount();
    }

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
