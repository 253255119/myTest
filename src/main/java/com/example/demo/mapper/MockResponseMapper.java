package com.example.demo.mapper;

import com.example.demo.models.MockResponse;

import java.util.List;

public interface MockResponseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MockResponse record);

    int insertSelective(MockResponse record);

    MockResponse selectByPrimaryKey(Integer id);
  List<MockResponse> selectByMockId(Integer id);
    int updateByPrimaryKeySelective(MockResponse record);
    List<MockResponse> selectByMockIdAndCheck(Integer mockId);
    int updateByPrimaryKeyWithBLOBs(MockResponse record);
    List<MockResponse> selectByMockIdAndNotCheck(Integer id);
    int updateByPrimaryKey(MockResponse record);
}