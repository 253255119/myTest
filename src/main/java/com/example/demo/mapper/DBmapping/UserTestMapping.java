package com.example.demo.mapper.DBmapping;

import com.example.demo.utils.AESUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: 25325
 * @Description: EcsAccountLog字段解密映射 com.example.demo.mapper.DBmapping.UserTestMapping
 * @DateTime: 2021-09-11 12:33
 **/
public class UserTestMapping extends BaseTypeHandler<Object> {
   private  final String key="test";
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, AESUtil.encrypt((String)parameter,key));
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String columnValue = rs.getString(columnName);
        return AESUtil.decrypt(columnValue,key);
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String columnValue = rs.getString(columnIndex);
        return AESUtil.decrypt(columnValue,key);
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        String columnValue = cs.getString(columnIndex);
        return AESUtil.decrypt(columnValue,key);
    }



}
