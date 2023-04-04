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


    public List<UserDto> listByDay(String startDt, String endDt) {
        return adminRepository.listByDay(startDt, endDt);
    }

    public List<Map<String, Object>> salesByDay(String startDt, String endDt) {
        return adminRepository.salesByDay(startDt, endDt);
    }

    public List<Map<String, Object>> salesByDayHour(String startDt, String endDt) {
        return adminRepository.salesByDayHour(startDt, endDt);
    }

    public List<Map<String, Object>> salesByMonth(String startDt, String endDt) {
            return adminRepository.salesByMonth(startDt, endDt);
    }

    public List<Map<String, Object>> salesByYear(String startDt, String endDt) {
        return adminRepository.salesByYear(startDt, endDt);
    }

}
