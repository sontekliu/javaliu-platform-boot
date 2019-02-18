package com.javaliu.boot.modules.shortlink.web;

import com.javaliu.boot.base.exception.wrapper.ServiceWrapperException;
import com.javaliu.boot.base.result.ResultOne;
import com.javaliu.boot.base.result.ResultUtils;
import com.javaliu.boot.modules.shortlink.service.IShortLinkService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 生成短连接
     * @param request
     * @return
     */
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

    /**
     * 查询短连接
     * @param key
     * @return
     */
    @GetMapping("{key}")
    public String lookup(@PathVariable String key) {
        String originalUrl = shortLinkService.lookup(key);
        if (StringUtils.isBlank(originalUrl)) {
            // 如果没有找到长链接，跳转到404页面
            return "redirect:https://www.javaliu.com/404";
        }
        return "redirect:" + originalUrl;
    }
}
