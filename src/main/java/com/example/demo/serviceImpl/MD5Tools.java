package com.example.demo.serviceImpl;

import org.springframework.util.DigestUtils;

public class MD5Tools {

    private  static String cipherText;

    public static String getCipherText(String plainText) {
        cipherText= DigestUtils.md5DigestAsHex(plainText.getBytes());
        return cipherText;
}

/*
    public void setCipherText(String plainText) {
        this.cipherText = cipherText;
    }
*/

    public static void main(String[] args) {
        MD5Tools md5Tools=new MD5Tools();
        System.out.println(md5Tools.getCipherText("HK"));
    }
}
