package com.example.demo.serviceImpl;

import com.example.demo.service.MD5MAPResService;
import com.example.demo.entity.MD5Res;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Map;
@Service
public class MD5MAPMMPL implements MD5MAPResService {
    @Override
    public Object queryMD5Req(Map<String, String> req) {
        MD5Res md5Res =new MD5Res();
        String cipherText=new String();
        if (req.get("plainText")!=null){
            String plainText = req.get("plainText");
             cipherText = DigestUtils.md5DigestAsHex(plainText.getBytes());
            md5Res.setCipherText(cipherText);
        }else {
            try {
            String plainText = req.get("plainText");
            cipherText = DigestUtils.md5DigestAsHex(plainText.getBytes());
            md5Res.setCipherText(cipherText);}catch (Exception e){
             cipherText ="99999999";
            md5Res.setCipherText(cipherText);}
        }
        return md5Res.toString();
    }
}
