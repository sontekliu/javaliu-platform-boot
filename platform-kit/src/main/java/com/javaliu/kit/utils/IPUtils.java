package com.javaliu.kit.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class IPUtils {
    /**
     * 日志记录器
     */
    private static final Logger LOG = LoggerFactory.getLogger(IPUtils.class);

    /**
     * 获取请求IP地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request){
        String userAddress = request.getHeader("X-Real-IP");
        if (StringUtils.isBlank(userAddress)) {
            userAddress = request.getHeader("X-Forwarded-For");
        }
        if (StringUtils.isBlank(userAddress)) {
            userAddress = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(userAddress)) {
            userAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(userAddress)) {
            userAddress = request.getRemoteAddr();
        }
        LOG.info("IP --> {}", userAddress);
        return userAddress;
    }
}
