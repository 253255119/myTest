package com.example.demo.serviceImpl;

import com.example.demo.service.OperationService;
import com.example.demo.entity.OperationReq;
import com.example.demo.entity.OperationRes;
import org.springframework.stereotype.Service;

@Service
public class OperationMMPL implements OperationService {
    @Override
    public Object queryOperation(OperationReq operationReq) {
        OperationRes operationRes=new OperationRes();
        String numberOne =operationReq.getNumberOne();
        String numberTwo=operationReq.getNumberTwo();
        String operator=operationReq.getOperator();
        String result=new String();
        String code = new String();
        String status = new String();
        String ooo="+–*/%";
        if (numberOne!=null){
            if (numberTwo!=null){
                if (operator!=null){
                    if (ooo.contains(operator)){
                        try {
                            Double one=Double.parseDouble(numberOne) ;
                            try{
                                Double two=Double.parseDouble(numberTwo);
                                if ("+".contains(operator)){
                                    Double res=one+two;
                                    result=res.toString();
                                    status="success";
                                    code="C0000";
                                }else if ("-".contains(operator)){
                                    Double res=one-two;
                                    result=res.toString();
                                    status="success";
                                    code="C0000";
                                }else if ("*".contains(operator)){
                                    Double res=one*two;
                                    result=res.toString();
                                    status="success";
                                    code="C0000";
                                }else if ("/".contains(operator)){
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

                                }else if ("%".contains(operator)){
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
