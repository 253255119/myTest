package com.example.demo.models;

import java.io.Serializable;

public class MockResponse implements Serializable {
    private Integer id;

    private Integer mockId;

    private String resName;

    private Integer httpCode;

    private String resHeader;

    private Integer resTemporize;

    private String resCondition;

    private Integer ifCheck;

    private Integer ifValid;

    private Integer ifUseVariables;

    private String resBody;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMockId() {
        return mockId;
    }

    public void setMockId(Integer mockId) {
        this.mockId = mockId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public String getResHeader() {
        return resHeader;
    }

    public void setResHeader(String resHeader) {
        this.resHeader = resHeader == null ? null : resHeader.trim();
    }

    public Integer getResTemporize() {
        return resTemporize;
    }

    public void setResTemporize(Integer resTemporize) {
        this.resTemporize = resTemporize;
    }

    public String getResCondition() {
        return resCondition;
    }

    public void setResCondition(String resCondition) {
        this.resCondition = resCondition == null ? null : resCondition.trim();
    }

    public Integer getIfCheck() {
        return ifCheck;
    }

    public void setIfCheck(Integer ifCheck) {
        this.ifCheck = ifCheck;
    }

    public Integer getIfValid() {
        return ifValid;
    }

    public void setIfValid(Integer ifValid) {
        this.ifValid = ifValid;
    }

    public Integer getIfUseVariables() {
        return ifUseVariables;
    }

    public void setIfUseVariables(Integer ifUseVariables) {
        this.ifUseVariables = ifUseVariables;
    }

    public String getResBody() {
        return resBody;
    }

    public void setResBody(String resBody) {
        this.resBody = resBody == null ? null : resBody.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mockId=").append(mockId);
        sb.append(", resName=").append(resName);
        sb.append(", httpCode=").append(httpCode);
        sb.append(", resHeader=").append(resHeader);
        sb.append(", resTemporize=").append(resTemporize);
        sb.append(", resCondition=").append(resCondition);
        sb.append(", ifCheck=").append(ifCheck);
        sb.append(", ifValid=").append(ifValid);
        sb.append(", ifUseVariables=").append(ifUseVariables);
        sb.append(", resBody=").append(resBody);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}