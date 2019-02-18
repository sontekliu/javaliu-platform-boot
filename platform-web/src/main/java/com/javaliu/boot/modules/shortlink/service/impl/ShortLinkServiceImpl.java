package com.javaliu.boot.modules.shortlink.service.impl;

import com.javaliu.boot.base.exception.wrapper.ServiceWrapperException;
import com.javaliu.boot.common.utils.BaseEntityUtils;
import com.javaliu.kit.utils.IdGenUtils;
import com.javaliu.boot.modules.shortlink.entity.ShortLinkEntity;
import com.javaliu.boot.modules.shortlink.kit.Base62;
import com.javaliu.boot.modules.shortlink.mapper.ShortLinkMapper;
import com.javaliu.boot.modules.shortlink.service.IShortLinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShortLinkServiceImpl implements IShortLinkService {

    private static final Logger logger = LoggerFactory.getLogger(ShortLinkServiceImpl.class);

    @Autowired
    private ShortLinkMapper shortLinkMapper;

    @Override
    public ShortLinkEntity genShortLink(String originalUrl, int bizType, Date expireDateTime) {
        if(null == originalUrl){
            logger.error("原始连接不能为空");
            throw new NullPointerException("原始连接不能为空");
        }
        if(null == expireDateTime){
            // 待优化部分 TODO
            // 默认加一天
            LocalDateTime localDateTime = LocalDateTime.ofInstant(expireDateTime.toInstant(), ZoneId.systemDefault());
            localDateTime.plusDays(1);
            expireDateTime = Date.from(localDateTime.toInstant(localDateTime.atZone(ZoneId.systemDefault()).getOffset()));
        }
        ShortLinkEntity shortLinkEntity = new ShortLinkEntity();
        long id = IdGenUtils.genDefaultSequenceId();
        shortLinkEntity.setId(id);
        // 将ID每隔 5 位插入一个随时数0,1，直到高位全部是 0 为止。
        id = Base62.insertRandomBitPer5Bits(id);
        String shortKey = Base62.toBase62(id);
        shortLinkEntity.setShortKey(shortKey);
        shortLinkEntity.setOriginalUrl(originalUrl);
        shortLinkEntity.setBizType(bizType);
        shortLinkEntity.setExpireDateTime(expireDateTime);
        // 待优化部分
        BaseEntityUtils.setBaseParam(shortLinkEntity);
        try{
            shortLinkMapper.insertOne(shortLinkEntity);
        } catch (Exception e){
            logger.error("保存短连接数据异常", e);
            throw new ServiceWrapperException("保存短连接数据异常", e);
        }
        return shortLinkEntity;
    }

    @Override
    public String lookup(String key) {
        Map<String, Object> params = new HashMap<>();
        params.put("shortKey", key);
        ShortLinkEntity shortLinkEntity = shortLinkMapper.selectOneBy(params);
        if(null == shortLinkEntity){
            return null;
        }
        return shortLinkEntity.getOriginalUrl();
    }
}
