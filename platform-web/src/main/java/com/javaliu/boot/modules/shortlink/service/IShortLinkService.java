package com.javaliu.boot.modules.shortlink.service;

import com.javaliu.boot.modules.shortlink.entity.ShortLinkEntity;

import java.util.Date;

public interface IShortLinkService {

    /**
     * 生成短连接
     * @param originalUrl       原始连接 URL
     * @param bizType           业务类型
     * @param expireDateTime    过期时间
     * @return
     */
    public ShortLinkEntity genShortLink(String originalUrl, int bizType, Date expireDateTime);
}
