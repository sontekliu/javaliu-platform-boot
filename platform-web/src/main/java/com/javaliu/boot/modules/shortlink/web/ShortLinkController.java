package com.javaliu.boot.modules.shortlink.web;

import com.javaliu.boot.base.exception.wrapper.ServiceWrapperException;
import com.javaliu.boot.base.result.ResultOne;
import com.javaliu.boot.base.result.ResultUtils;
import com.javaliu.boot.modules.shortlink.service.IShortLinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping(value = "/shortLink/")
public class ShortLinkController {

    private static final Logger logger = LoggerFactory.getLogger(ShortLinkController.class);

    @Autowired
    private IShortLinkService shortLinkService;

    @ResponseBody
    @RequestMapping(value = "createShortKey")
    public ResultOne<String> createShortKey(HttpServletRequest request){
        String originalUrl = request.getParameter("originalUrl");
        ResultOne<String> resultOne = new ResultOne();
        try {
            originalUrl = "https://www.baidu.com";
            shortLinkService.genShortLink(originalUrl, 1, new Date());
            resultOne = ResultUtils.successResultOne();
        } catch (ServiceWrapperException e){
            resultOne = ResultUtils.failResultOne(1, e.getMessage());
        }
        return resultOne;
    }
}
