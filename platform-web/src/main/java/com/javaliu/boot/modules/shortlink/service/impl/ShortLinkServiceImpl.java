package com.javaliu.boot.modules.shortlink.service.impl;

import com.javaliu.boot.modules.shortlink.entity.ShortLinkEntity;
import com.javaliu.boot.modules.shortlink.mapper.ShortLinkMapper;
import com.javaliu.boot.modules.shortlink.service.IShortLinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortLinkServiceImpl implements IShortLinkService {

    private static final Logger logger = LoggerFactory.getLogger(ShortLinkServiceImpl.class);

    @Autowired
    private ShortLinkMapper shortLinkMapper;


    @Override
    public ShortLinkEntity addShortLink(ShortLinkEntity shortLinkEntity) {
        shortLinkMapper.insertOne(shortLinkEntity);
        return shortLinkEntity;
    }
}
