package com.example.demo.mapper;

import com.example.demo.models.UserTest;

import java.util.List;

public interface UserTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserTest record);

    int insertSelective(UserTest record);

    UserTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTest record);

    int updateByPrimaryKey(UserTest record);
    int insertAesEncrypt(UserTest record);
  List<UserTest> selectByuserNameKey(UserTest record);
}