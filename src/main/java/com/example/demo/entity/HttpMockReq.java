package com.example.demo.entity;

import lombok.Data;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: 25325
 * @Description: http mock
 * @DateTime: 2021-09-30 22:40
 **/
@Data
public class HttpMockReq {
    private Map paramMap;
    private Map headermap;
    private HttpServletRequest request;
}
