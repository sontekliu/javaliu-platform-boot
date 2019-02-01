package com.javaliu.boot.common.interceptor;

import com.javaliu.boot.common.context.ThreadContext;
import com.javaliu.kit.context.GlobalThreadContext;
import com.javaliu.kit.utils.IPUtils;
import com.javaliu.kit.utils.IdGenUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        GlobalThreadContext threadContext = GlobalThreadContext.getThreadInstance();
        threadContext.setIpAddress(IPUtils.getIpAddress(request));
        threadContext.setUuid(IdGenUtils.gen32Uuid());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清除绑定线程的数据
        ThreadContext.getThreadInstance().remove();
        GlobalThreadContext.getThreadInstance().remove();
    }
}
