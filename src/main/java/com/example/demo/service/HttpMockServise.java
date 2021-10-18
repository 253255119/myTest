package com.example.demo.service;

import com.example.demo.entity.HttpMockReq;

/**
 * @Author: 25325
 * @Description: http mock
 * @DateTime: 2021-09-30 22:30
 **/
public interface HttpMockServise {
    Object httpMock(HttpMockReq req);
}
