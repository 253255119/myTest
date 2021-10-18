package com.example.demo.utils;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: 25325
 * @Description: 字符串转换类
 * @DateTime: 2021-09-30 23:25
 **/
public class StringConversion {

    public static List stringToList(String var){
        return Arrays.asList(var.split(","));
    }

    public static void main(String[] args) {
        System.out.println(stringToList("aaa,sss,ddd"));
    }
}
