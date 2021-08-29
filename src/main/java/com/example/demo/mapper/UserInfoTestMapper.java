package com.example.demo.mapper;

import com.example.demo.models.UserInfoTest;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserInfoTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfoTest record);

    int insertSelective(UserInfoTest record);

    UserInfoTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfoTest record);

    int updateByPrimaryKey(UserInfoTest record);

    List<UserInfoTest> selectByUserName(UserInfoTest record);
    List<UserInfoTest> selectByUserName1(UserInfoTest record);
    @ResultMap("BaseResultMap")
    @Select("select id, user_name, password, enrolment_phone, bind_phone, create_time, update_time  from user_info_test where user_name = #{userName,jdbcType=VARCHAR}")
    List<UserInfoTest> selectByUserName2(@Param("userName") String userName );
}