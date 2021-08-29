package com.example.demo.entity;

import java.io.Serializable;

public class OperationReq implements Serializable {
    private static final long serialVersionUID = 6237204089595148733L;
    private String numberOne;
    private String numberTwo;
    private  String operator;
    public String getNumberOne() {
        return numberOne;
    }
    public String getNumberTwo() {
        return numberTwo;
    }
    public String getOperator() {
        return operator;
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

    @Override
    public String toString() {
        return "OperationReq{" +
                "numberOne='" + numberOne + '\'' +
                ", numberTwo='" + numberTwo + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
