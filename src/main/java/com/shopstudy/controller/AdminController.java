package com.shopstudy.controller;

import com.shopstudy.domain.OrderDto;
import com.shopstudy.domain.UserDto;
import com.shopstudy.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/listAll")
    public ResponseEntity<?> listAll() {

        List<UserDto> listAll = adminService.listAll();

        return ResponseEntity.ok(listAll) ;
    }

    @GetMapping("/listCount")
    public int listCount() {
        return adminService.listCount();
    }

    /**
     *
     * 회원가입 날짜별 회원목록
     */
    @GetMapping("/listByDay")
    public List<UserDto> listByDay(String startDt, String endDt) {
        return adminService.listByDay(startDt, endDt);
    }

    /**
     *
     * 일자별,월별 매출
     */
    @GetMapping("/salesBy{type}")
    public List<Map<String, Object>> salesByDay(@PathVariable String type, @RequestParam(required = false) String year, @RequestParam(required = false) String month) {

        List<Map<String, Object>> result = new ArrayList<>();

        if(type.equals("Day")){
            result = adminService.salesByDay();
        } else if(type.equals("Month")){
            result = adminService.salesByMonth(month);
        } else if(type.equals("Year")){
            result = adminService.salesByYear(year);
        }
        return result;
    }



}
