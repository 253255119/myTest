package com.example.demo.utils;

import com.example.demo.mapper.UserInfoTestMapper;
import com.example.demo.models.UserInfoTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
/**
 * @Author: 25325
 * @Description:Mybaits工具栏
 * @DateTime: 2021-09-11 11:29
 **/
public class MybaitsUtil {

    private static String resource = "mybatis-config.xml";

    public static SqlSession createSqlSession(String env) {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, env);
            return sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeSqlSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    public static void main(String[] args) {
        UserInfoTest userInfoTest = new UserInfoTest();
        userInfoTest.setUserName("123456");
        userInfoTest.setTableName("user_info_test");
        SqlSession sqlSession=createSqlSession("2");
        UserInfoTestMapper mapper = sqlSession.getMapper(UserInfoTestMapper.class);
        System.out.println("selectByUserName:>>>>>>" + mapper.selectByUserName(userInfoTest));
        System.out.println("selectByUserName1:>>>>>>" + mapper.selectByUserName1(userInfoTest));
        System.out.println("selectByUserName2:>>>>>>" + mapper.selectByUserName2("1233"));
        MybaitsUtil.closeSqlSession(sqlSession);
    }
}