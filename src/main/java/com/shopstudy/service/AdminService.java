package com.shopstudy.service;

import com.shopstudy.domain.OrderDto;
import com.shopstudy.domain.UserDto;
import com.shopstudy.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public List<UserDto> listAll() {
        return adminRepository.findAll();
    }

    public int listCount() {
        return adminRepository.getListCount();
    }

    public List<UserDto> listByDay(String startDt, String endDt) {
        return adminRepository.listByDay(startDt, endDt);
    }

    public List<Map<String, Object>> salesByDay() {
        return adminRepository.salesByDay();
    }

    public List<Map<String, Object>> salesByMonth() {
        return adminRepository.salesByMonth();
    }

    public List<Map<String, Object>> salesByYear() {
        return adminRepository.salesByYear();
    }

}