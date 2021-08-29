package com.example.demo.serviceImpl;

import com.example.demo.service.OperationMapService;
import com.example.demo.entity.OperationRes;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OperationMapMMPL implements OperationMapService {
    @Override
    public Object queryOperation(Map<String, String> operationMapReq) {
        OperationRes operationRes=new OperationRes();
         String numberOne =new String();
         String numberTwo=new String();
          String operator=new String();
          String result=new String();
         String code ;
         String status ;
         String ooo="+–*/%";
        if (operationMapReq.get("numberOne")!=null){
            numberOne=operationMapReq.get("numberOne");
            if (operationMapReq.get("numberTwo")!=null){
                numberTwo=operationMapReq.get("numberTwo");
                if (operationMapReq.get("operator")!=null){
                    operator=operationMapReq.get("operator");
                    if (ooo.contains(operationMapReq.get("operator"))){
                        try {
                            Double one=Double.parseDouble(operationMapReq.get("numberOne")) ;
                            try{
                                Double two=Double.parseDouble(operationMapReq.get("numberTwo"));
                                if ("+".contains(operationMapReq.get("operator"))){
                                    Double res=one+two;
                                    result=res.toString();
                                    status="success";
                                    code="C0000";
                                }else if ("-".contains(operationMapReq.get("operator"))){
                                    Double res=one-two;
                                    result=res.toString();
                                    status="success";
                                    code="C0000";
                                }else if ("*".contains(operationMapReq.get("operator"))){
                                    Double res=one*two;
                                    result=res.toString();
                                    status="success";
                                    code="C0000";
                                }else if ("/".contains(operationMapReq.get("operator"))){
//                                    double dval1 = 0;
                                    double dval2 = 0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001;
                                    if ((two>=-dval2)&&(two<=dval2)){
                                        status="fail";
                                        code="C0007"; //除数为0
                                    }else {
                                        Double res=one/two;
                                        result=res.toString();
                                        status="success";
                                        code="C0000";
                                    }

                                }else if ("%".contains(operationMapReq.get("operator"))){
                                    double dval2 = 0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001;
                                    if ((two>=-dval2)&&(two<=dval2)){
                                        status="fail";
                                        code="C0007"; //除数为0
                                    }else {
                                        Double res=one%two;
                                        result=res.toString();
                                        status="success";
                                        code="C0000";
                                    }


                                }else {
                                    status="fail";
                                    code="C0004"; //不支持当前运算符
                                }
                            }catch (Exception e){
                                status="fail";
                                code="C0006"; //数字2格式不对（支持整数和小数）
                            }
                        }catch (Exception e){
                            status="fail";
                            code="C0005"; //数字1格式不对（支持整数和小数）
                        }
                    }else {
                        status="fail";
                        code="C0004"; //不支持当前运算符
                    }

                }else {
                    status="fail";
                    code="C0003"; //数字运算符为空
                }
            }else {
                status="fail";
                code="C0002"; //数字二为空
            }
        }else {
            status="fail";
            code="C0001"; //数字一为空
        }
        operationRes.setCode(code);
        operationRes.setNumberOne(numberOne);
        operationRes.setNumberTwo(numberTwo);
        operationRes.setOperator(operator);
        operationRes.setStatus(status);
        operationRes.setResult(result);



        return operationRes.toString();
    }
}
