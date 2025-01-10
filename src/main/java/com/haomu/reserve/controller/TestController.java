package com.haomu.reserve.controller;

import com.alibaba.fastjson.JSONObject;
import com.haomu.reserve.utils.api.ApiResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    /*------------------------------ GET method -----------------------------------*/
    @GetMapping("/start")
    public JSONObject startReserve(){
        return ApiResponse.success("ok");
    }

    @GetMapping("/test")
    public JSONObject testReserve(){
        List<JSONObject> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            JSONObject obj = new JSONObject();
            obj.put("id",i);
            char ch = 'a';
            obj.put("text",(char) (ch + i));
            list.add(obj);
        }

        return ApiResponse.success(list);
    }

    @GetMapping("/test2")
    public JSONObject test2Reserve() {
        return ApiResponse.errorPara("list");
    }

    @GetMapping("/testDelays")
    public JSONObject testDelays() {
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ApiResponse.success("current ok");
    }
}
