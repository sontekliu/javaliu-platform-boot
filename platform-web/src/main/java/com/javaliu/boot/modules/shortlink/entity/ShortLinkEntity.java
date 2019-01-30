package com.javaliu.boot.modules.shortlink.entity;

import com.javaliu.boot.base.entity.BaseEntity;

import java.util.Date;

public class ShortLinkEntity extends BaseEntity {

    private String shortKey;
    private String originalUrl;
    private Date expireDateTime;
    private int bizType;

    public String getShortKey() {
        return shortKey;
    }

    public void setShortKey(String shortKey) {
        this.shortKey = shortKey;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Date getExpireDateTime() {
        return expireDateTime;
    }

    public void setExpireDateTime(Date expireDateTime) {
        this.expireDateTime = expireDateTime;
    }

    public int getBizType() {
        return bizType;
    }

    public void setBizType(int bizType) {
        this.bizType = bizType;
    }
}
