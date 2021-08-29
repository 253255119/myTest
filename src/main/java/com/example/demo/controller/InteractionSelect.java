package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.MD5MAPResService;
import com.example.demo.service.MD5ResService;
import com.example.demo.service.OperationMapService;
import com.example.demo.service.OperationService;
import com.example.demo.entity.MD5Req;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping(value = "/")
public class InteractionSelect {
    @Autowired
    OperationMapService OperationMapService;
    @Autowired
    OperationService OperationService;
    @Autowired
    MD5MAPResService MD5MAPResService;
@Autowired
    MD5ResService MD5ResService;
    @RequestMapping("/test")
    @ResponseBody
    public String string(){
        return "jjjjjjjjjjjjjjjjjjjjjjjjjjjjj";
    }
    @RequestMapping(value = "/test2" ,produces ="application/json;charset=UTF-8",method = RequestMethod.GET)
    public Object object(@RequestParam Map<String ,String> req){
        return req.toString();
    }

    @RequestMapping(value = "/test3" ,produces ="application/json;charset=UTF-8",method = RequestMethod.POST)
    public Object object1(@RequestBody MD5Req md5Req){
        System.out.println("111111");
        return md5Req.toString();
    }

    @RequestMapping(value = "/test4" ,produces ="application/json;charset=UTF-8",method = RequestMethod.POST)
    public Object object1(@RequestBody JSONObject jsonObject){

        return "nul77777777777777777l";
    }
    @RequestMapping(value = "/test5" ,produces ="application/json;charset=UTF-8",method = RequestMethod.POST)
    public Object object0(@RequestBody MD5Req md5Req){
        return MD5ResService.queryMD5Req(md5Req );
    }
 @RequestMapping(value = "/test6" ,produces ="application/x-www-form-urlencoded;charset=UTF-8",method = RequestMethod.POST)
 public Object object2(@RequestParam Map<String ,String> md5Req){
     return MD5MAPResService.queryMD5Req(md5Req);
 }
    @RequestMapping(value = "/test7" ,produces ="application/x-www-form-urlencoded;charset=UTF-8",method = RequestMethod.POST)
    public Object object3(@RequestParam Map<String ,String> operation){
        System.out.println(operation.toString());
        System.out.println("请求到了test7");
        return OperationMapService.queryOperation(operation);
    }

}
