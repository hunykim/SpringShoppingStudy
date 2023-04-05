package com.shopstudy.service;

import com.shopstudy.domain.UserDto;
import com.shopstudy.domain.UserLoginDto;
import com.shopstudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    public final UserRepository userRepository;

    public List<UserDto> listAll() {
        return userRepository.findAll();
    }

    public int listCount() {
        return userRepository.getListCount();
    }

    public UserDto userInfo(long id) {
        return userRepository.findBy(id);
    }

    public UserDto userIdChk(String email) {
        return userRepository.userIdChk(email);
    }


    /**
     *
     * 회원가입 및 아이디 중복체크
     *
     */

    public String userSave(UserDto user) {

        String result = "";

        UserDto email = userIdChk(user.getEmail());
        if(null != email) {
            result = "중복 이메일이 있습니다.";
        } else {
            userRepository.save(user);
            result = user.getEmail() + " 회원가입 되었습니다.";
        }
        return result;
    }


    public UserDto loginChk(UserLoginDto user) {
        return userRepository.loginChk(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserId(username).orElseThrow(()-> new UsernameNotFoundException("사용자를 찾지 못했습니다"));
    }


}
