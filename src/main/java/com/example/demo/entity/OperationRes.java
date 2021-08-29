package com.example.demo.entity;

import java.io.Serializable;

public class OperationRes implements Serializable {
    private String numberOne;
    private String numberTwo;
    private  String operator;
    private  String result;
    private String code;
    private String status;
    public String getNumberOne() {
        return numberOne;
    }
    public String getNumberTwo() {
        return numberTwo;
    }
    public String getOperator() {
        return operator;
    }
    public String getResult() {
        return result;
    }
    public String getCode() {
        return code;
    }
    public String getStatus() {
        return status;
    }
    public void setNumberOne(String numberOne) {
        this.numberOne = numberOne;
    }
    public void setNumberTwo(String numberTwo) {
        this.numberTwo = numberTwo;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "{\"code\":\""+code+"\",\"status\":\""+status+"\","+
                "\"numberOne\":\"" + numberOne + '\"' +
                ",\"numberTwo\":\"" + numberTwo + '\"' +
                ", \"operator\":\"" + operator + '\"' +
                ", \"result\":\"" + result + '\"' +
                '}';
    }
}
