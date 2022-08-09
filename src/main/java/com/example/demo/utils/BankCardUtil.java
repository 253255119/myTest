package com.example.demo.utils;

import java.util.List;
import java.util.Vector;

/**
 * @Author: 25325
 * @Description: 银行卡
 * @DateTime: 2022-08-09 22:19
 **/
public class BankCardUtil {

    public static  String getBankCard(String ccumber ,int length){
        while (ccumber.length()<(length-1)){
           ccumber += new Double(Math.random()*10).intValue();
        }
        String reversedCCnumberString=strrev(ccumber);
        List<Integer> integerList=new Vector<>();
        for (int i =0;i<reversedCCnumberString.length();i++){
            integerList.add(new Integer(String.valueOf(reversedCCnumberString.charAt(i))));
        }
        int sum=0;
        int pos=0;
        Integer[] integers=integerList.toArray(new Integer[integerList.size()]);
        while (pos< length-1){
            int odd =integers[pos]*2;
            if (odd>9){
                odd -=9;
            }
            sum +=odd;
            if (pos != (length-2)){
                sum +=integers[pos +1];
            }
            pos+=2;
        }
        int checkdigit=new Double(((Math.floor(sum/10)+1)*10-sum)%10).intValue();
        ccumber+=checkdigit;
 return ccumber;
    }

   public   static  String strrev(String s){
        if (s==null){
            return "";
        }
        String revstr="";
       for (int i=s.length()-1;i>=0;i--){
           revstr += s.charAt(i);
       }
        return revstr;
  }

    public static void main(String[] args) {
        System.out.println(getBankCard("67755",19));
    }

}
