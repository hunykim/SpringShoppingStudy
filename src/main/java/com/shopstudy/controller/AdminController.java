package com.shopstudy.controller;

import com.shopstudy.domain.OrderDto;
import com.shopstudy.domain.UserDto;
import com.shopstudy.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(tags = {"관리자용 API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @ApiOperation(value = "총 회원목록")
    @GetMapping("/listAll")
    public ResponseEntity<?> listAll() {

        List<UserDto> listAll = adminService.listAll();

        return ResponseEntity.ok(listAll) ;
    }

    @ApiOperation(value = "총 회원수")
    @GetMapping("/listCount")
    public int listCount() {
        return adminService.listCount();
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDt", value = "yyyy-mm-dd", required = false, dataType = "String", paramType = "query")
            , @ApiImplicitParam(name = "endDt", value = "yyyy-mm-dd", required = false, dataType = "String", paramType = "query")
    })
    @ApiOperation(value = "회원가입 날짜별 회원목록")
    @GetMapping("/listByDay")
    public List<UserDto> listByDay(String startDt, String endDt) {
        return adminService.listByDay(startDt, endDt);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "Day, Month, Year", required = true, dataType = "String", paramType = "path")
            , @ApiImplicitParam(name = "year", value = "year 값", required = false, dataType = "String", paramType = "query")
            , @ApiImplicitParam(name = "month", value = "1,3,6", required = false, dataType = "String", paramType = "query")
    })
    @ApiOperation(value = "일자별,월별,연도별 매출목록")
    @GetMapping("/salesBy{type}")
    public List<Map<String, Object>> salesByDay(@PathVariable String type, String year, String month) {

        List<Map<String, Object>> result = new ArrayList<>();

        if(type.equals("Day")){
            result = adminService.salesByDay(month);
        } else if(type.equals("Month")){
            result = adminService.salesByMonth(month);
        } else if(type.equals("Year")){
            result = adminService.salesByYear(year);
        }
        return result;
    }



}
