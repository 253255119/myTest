package com.example.demo.entity;

import java.io.Serializable;

public class MD5Res implements Serializable {
    private static final long serialVersionUID = -4844393038152486431L;
    private String cipherText;

    public String getCipherText() {
        return cipherText;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }

    @Override
    public  String toString(){
        return "this response  is :{cipherText='"+cipherText+"'}";
    }


}
