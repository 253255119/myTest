package com.example.demo.serviceImpl;

import com.example.demo.service.UserLoginService;
import com.example.demo.utils.SqlBase;
import com.example.demo.entity.UserLoginReq;
import com.example.demo.entity.UserLoginRes;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserLoginMMPL implements UserLoginService {


    @Override
    public Object queryUserLogin(UserLoginReq userLoginReq) {
        UserLoginRes userLoginRes =new UserLoginRes();
        String username=userLoginReq.getUsername();
        String password=userLoginReq.getPassword();
        String msg=new String();
        String code=new String();
        String sqlUsername=new String();
        String sqlPassword  =new String();
        SqlBase sqlBase=new SqlBase();
        try {
            String sql = "SELECT * FROM test.user_info_test WHERE user_name='%s';";
            Map map = sqlBase.getSqlLimitOne(String.format(sql, username));
            sqlUsername = map.get("user_name").toString();
            sqlPassword = map.get("password").toString();
            if (password.equals(sqlPassword)){
                code="200";
            }else {
                code="400";
                msg="用户名或密码错误，请输入正确的用户名和密码";
            }
        }catch (Exception e){
            code="400";
            msg="用户名不存在，请输入正确的用户名";
        }
        userLoginRes.setCode(code);
        userLoginRes.setMsg(msg);
        return userLoginRes.toString();
    }
}
