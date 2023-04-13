package com.shopstudy.controller;

import com.shopstudy.domain.UserDto;
import com.shopstudy.service.AdminService;
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
    public ResponseEntity<Integer> listCount() {
        int listCnt = adminService.listCount();
        return new ResponseEntity<>(listCnt, HttpStatus.OK) ;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDt", value = "yyyy-mm-dd", required = false, dataType = "String", paramType = "query")
            , @ApiImplicitParam(name = "endDt", value = "yyyy-mm-dd", required = false, dataType = "String", paramType = "query")
    })
    @ApiOperation(value = "회원가입 날짜별 회원목록")
    @GetMapping("/listByDay")
    public ResponseEntity<List<UserDto>> listByDay(String startDt, String endDt) {
        return new ResponseEntity<>(adminService.listByDay(startDt, endDt), HttpStatus.OK);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "Day,DayHour, Month, Year", required = true, dataType = "String", paramType = "path")
            , @ApiImplicitParam(name = "startDt", value = "yyyy-mm-dd", required = false, dataType = "String", paramType = "query")
            , @ApiImplicitParam(name = "endDt", value = "yyyy-mm-dd", required = false, dataType = "String", paramType = "query")
    })
    @ApiOperation(value = "일자별,월별,연도별 매출목록")
    @GetMapping("/salesBy{type}")
    public ResponseEntity<List<Map<String, Object>>> salesByDay(@PathVariable String type, String startDt, String endDt) {

        List<Map<String, Object>> result = new ArrayList<>();

        if(type.equals("Day")){
            result = adminService.salesByDay(startDt, endDt);
        }else if(type.equals("DayHour")){
            result = adminService.salesByDayHour(startDt, endDt);
        }else if(type.equals("Month")){
            result = adminService.salesByMonth(startDt, endDt);
        } else if(type.equals("Year")){
            result = adminService.salesByYear(startDt, endDt);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
