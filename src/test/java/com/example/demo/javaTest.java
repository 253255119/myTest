package com.example.demo;

import com.example.demo.mapper.UserTestMapper;
import com.example.demo.models.UserTest;
import com.example.demo.utils.MybaitsUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

/**
 * @Author: 25325
 * @Description: 自己练习
 * @DateTime: 2021-09-11 12:11
 **/
public class javaTest {


    @Test
    public void test1(){
        SqlSession sqlSession= MybaitsUtil.createSqlSession("2");
        UserTest userTest=new UserTest();
       userTest.setUserName("123456789");
       userTest.setPassword("234567890");
        UserTestMapper mapper=sqlSession.getMapper(UserTestMapper.class);
//        mapper.insertAesEncrypt(userTest);
        System.out.println(mapper.selectByuserNameKey(userTest));
        MybaitsUtil.closeSqlSession(sqlSession);
    }
}
