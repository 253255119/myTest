package com.example.demo.serviceImpl;

import com.example.demo.service.MD5ResService;
import com.example.demo.entity.MD5Req;
import com.example.demo.entity.MD5Res;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class MD5MMPL implements MD5ResService {
    @Override
    public Object queryMD5Req(MD5Req md5Req) {
        MD5Res md5Res =new MD5Res();
        String plainText=md5Req.getPlainText();
        String cipherText= DigestUtils.md5DigestAsHex(plainText.getBytes());
        md5Res.setCipherText(cipherText);
 /*       return "response{plainText='"
                +plainText+"',cipherText='"+cipherText+"'}";*/
 return md5Res.toString();
    }
}
