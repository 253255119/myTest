package com.example.demo.vueTest;



import com.example.demo.service.OperationService;
import com.example.demo.service.UserLoginService;
import com.example.demo.entity.OperationReq;
import com.example.demo.entity.UserLoginReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
@Autowired
OperationService OperationService;
@Autowired
UserLoginService UserLoginService;
//    @CrossOrigin
//    @PostMapping(value = "api/login")
//    @ResponseBody
//    public Result login(@RequestBody User requestUser) {
//        // 对 html 标签进行转义，防止 XSS 攻击
//        String username = requestUser.getUsername();
//        username = HtmlUtils.htmlEscape(username);
//
//        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
//            String message = "账号密码错误";
//            System.out.println("test");
//            return new Result(400);
//        } else {
//            return new Result(200);
//        }
//    }
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Object login(@RequestBody UserLoginReq userLoginReq){
        return UserLoginService.queryUserLogin(userLoginReq);
    }

    @CrossOrigin
    @PostMapping(value = "api/Appindex")
    @ResponseBody
    public Object object0(@RequestBody OperationReq operationReq){
        return OperationService.queryOperation(operationReq);
    }



}

