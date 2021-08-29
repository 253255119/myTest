package com.example.demo.entity;

import java.io.Serializable;

public class UserLoginRes implements Serializable {
    private static final long serialVersionUID = 5036465933455576097L;
    private  String code;
    private  String msg;
    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{\"" +
                "code\":\"" + code + "\",\"msg\":\"" +msg+
                "\"}";
    }
}
