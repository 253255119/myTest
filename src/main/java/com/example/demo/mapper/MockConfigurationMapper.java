package com.example.demo.mapper;

import com.example.demo.models.MockConfiguration;

public interface MockConfigurationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MockConfiguration record);

    int insertSelective(MockConfiguration record);
    MockConfiguration selectByMockUrl(String mockUrl);
    MockConfiguration selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MockConfiguration record);

    int updateByPrimaryKey(MockConfiguration record);
}