package com.example.demo.models;

import java.io.Serializable;

public class MockConfiguration implements Serializable {
    private Integer id;

    private String mockUrl;

    private String mockName;

    private String getReqheader;

    private String getReqbody;
    private Integer getReqType;

    private static final long serialVersionUID = 1L;

    public Integer getGetReqType() {
        return getReqType;
    }

    public void setGetReqType(Integer getReqType) {
        this.getReqType = getReqType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMockUrl() {
        return mockUrl;
    }

    public void setMockUrl(String mockUrl) {
        this.mockUrl = mockUrl == null ? null : mockUrl.trim();
    }

    public String getMockName() {
        return mockName;
    }

    public void setMockName(String mockName) {
        this.mockName = mockName == null ? null : mockName.trim();
    }

    public String getGetReqheader() {
        return getReqheader;
    }

    public void setGetReqheader(String getReqheader) {
        this.getReqheader = getReqheader == null ? null : getReqheader.trim();
    }

    public String getGetReqbody() {
        return getReqbody;
    }

    public void setGetReqbody(String getReqbody) {
        this.getReqbody = getReqbody == null ? null : getReqbody.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mockUrl=").append(mockUrl);
        sb.append(", mockName=").append(mockName);
        sb.append(", getReqheader=").append(getReqheader);
        sb.append(", getReqbody=").append(getReqbody);
        sb.append(", getReqType=").append(getReqType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}