package com.example.demo.controller;


import com.example.demo.entity.HttpMockReq;
import com.example.demo.service.HttpMockServise;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: 25325
 * @Description: http mock
 * @DateTime: 2021-09-30 22:25
 **/
@Slf4j
@RestController
@RequestMapping(value = "/mock")
public class HttpMockController {
@Autowired
    HttpMockServise httpMockServise;
    @RequestMapping(value = "/*/*" )
    public Object object(@RequestParam Map paramMap, @RequestHeader MultiValueMap headermap, HttpServletRequest request){
        HttpMockReq req=new HttpMockReq();
        req.setParamMap(paramMap);
        req.setRequest(request);
        req.setHeadermap(headermap);
        log.info("Ssssssssssssssssssssssssssssssssss");
//        return "aaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        return httpMockServise.httpMock(req);
    }
}
