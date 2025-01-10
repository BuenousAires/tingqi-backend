package com.haomu.reserve.controller;

import com.alibaba.fastjson.JSONObject;
import com.haomu.reserve.module.Reserve;
import com.haomu.reserve.service.IReserveService;
import com.haomu.reserve.utils.api.ApiResponse;
import com.haomu.reserve.utils.result.Result;
import com.haomu.reserve.utils.result.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private IReserveService reserveService;

    /*------------------------------ GET method -----------------------------------*/
    @GetMapping("/reserveList")
    public JSONObject getReserveList(
            @RequestParam String start,
            @RequestParam String end,
            @RequestParam String step
    ){
        Result<Object> res = reserveService.getReserveList(start, end, step);
        if(res.getCode() == ResultCodeEnum.SUCCESS.getCode()){
            return ApiResponse.success(res.getData());
        }else {
            return ApiResponse.errorPara(res.getMsg());
        }
    }

    @GetMapping("/getReservedDay")
    public JSONObject getReserveDay(
            @RequestParam String year,
            @RequestParam String month
    ){
        Result<Object> res = reserveService.getReservedDay(year, month);
        if(res.getCode() == ResultCodeEnum.SUCCESS.getCode()){
            return ApiResponse.success(res.getData());
        }else {
            return ApiResponse.errorPara(res.getMsg());
        }
    }

    @GetMapping("/getReserveByDay")
    public JSONObject getReserveByDay(@RequestParam String date) {
        Result<Object> res = reserveService.getReserveByDay(date);
        if(res.getCode() == ResultCodeEnum.SUCCESS.getCode()){
            return ApiResponse.success(res.getData());
        }else {
            return ApiResponse.errorPara(res.getMsg());
        }
    }

    /*------------------------------ POST method ----------------------------------*/
    @PostMapping("/save")
    public JSONObject saveReserve(@RequestBody Reserve reserve){
        Result<String>  res = reserveService.saveReserve(reserve);
        if(res.getCode() == ResultCodeEnum.SUCCESS.getCode()){
            return ApiResponse.success(res.getData());
        }else {
            return ApiResponse.errorPara(res.getMsg());
        }
    }

}
