package com.example.demo.entity;


import java.io.Serializable;

public class MD5Req implements Serializable {
    private static final long serialVersionUID = -5465888828280420390L;

    private String plainText;
    private String yyy;


    public String getYyy() {
        return yyy;
    }


    public void setYyy(String yyy) {
        this.yyy = yyy;
    }

    public String getPlainText() {
        return plainText;
    }
    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

   /*    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }*/

    @Override
    public String toString() {

        return "req{plainText='"+plainText+"',"+"yyy='"+yyy+"'}";
    }
}
