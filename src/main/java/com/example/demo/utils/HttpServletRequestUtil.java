package com.example.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Author: 25325
 * @Description: http获取body
 * @DateTime: 2021-09-30 23:33
 **/
@Slf4j
public class HttpServletRequestUtil {
    public static String requestBodyStr(HttpServletRequest request) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        log.info("this HttpServletRequest 2222 body is :{}",sb);
        return sb.toString();
    }

    public static JSONObject requestBodyJS(HttpServletRequest request) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        log.info("this HttpServletRequest 11111 body is :{}",sb);
        JSONObject o=JSON.parseObject(sb.toString());
        return o;
    }
}
