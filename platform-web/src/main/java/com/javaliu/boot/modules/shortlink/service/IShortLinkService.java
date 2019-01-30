package com.javaliu.boot.modules.shortlink.service;

import com.javaliu.boot.modules.shortlink.entity.ShortLinkEntity;

public interface IShortLinkService {

    /**
     * 添加短连接
     * @param shortLinkEntity
     * @return
     */
    public ShortLinkEntity addShortLink(ShortLinkEntity shortLinkEntity);
}
