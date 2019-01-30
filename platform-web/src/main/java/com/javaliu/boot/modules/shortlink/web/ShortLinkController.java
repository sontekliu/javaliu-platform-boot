package com.javaliu.boot.modules.shortlink.web;

import com.javaliu.boot.modules.shortlink.entity.ShortLinkEntity;
import com.javaliu.boot.modules.shortlink.service.IShortLinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping(value = "/shortLink/")
public class ShortLinkController {

    private static final Logger logger = LoggerFactory.getLogger(ShortLinkController.class);

    @Autowired
    private IShortLinkService shortLinkService;

    @RequestMapping(value = "createShortKey")
    public String createShortKey(){
        ShortLinkEntity shortLinkEntity = new ShortLinkEntity();
        shortLinkEntity.setId(1L);
        shortLinkEntity.setShortKey("abcd");
        shortLinkEntity.setOriginalUrl("https://www.javaliu.com");
        shortLinkEntity.setBizType(2);
        shortLinkEntity.setExpireDateTime(new Date());
        shortLinkEntity.setCreateBy(1L);
        shortLinkEntity.setCreateDateTime(new Date());
        shortLinkEntity.setUpdateBy(1L);
        shortLinkEntity.setUpdateDateTime(new Date());
        shortLinkEntity.setDeleteFlag(0);
        shortLinkService.addShortLink(shortLinkEntity);
        return "添加成功";
    }
}
