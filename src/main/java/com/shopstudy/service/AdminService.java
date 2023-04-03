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

    public List<Map<String, Object>> salesByDay(String month) {
        return adminRepository.salesByDay(month);
    }

    public List<Map<String, Object>> salesByMonth(String month) {
            return adminRepository.salesByMonth(month);
    }

    public List<Map<String, Object>> salesByYear(String year) {
        return adminRepository.salesByYear(year);
    }

}
