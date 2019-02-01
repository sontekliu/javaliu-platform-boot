package com.javaliu.boot.common.interceptor;

import com.javaliu.boot.modules.account.entity.AccountEntity;
import com.javaliu.boot.common.context.ThreadContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ThreadContext threadContext = ThreadContext.getThreadInstance();
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setCode("admin");
        accountEntity.setEmail("admin@123.com");
        accountEntity.setNickName("admin昵称");
        accountEntity.setStatus(0);
        accountEntity.setHeadImage("path/to/image.png");
        accountEntity.setPassword("123");
        accountEntity.setSalt("12345678");
        accountEntity.setCreateBy(123L);
        accountEntity.setCreateDateTime(new Date());
        accountEntity.setUpdateBy(123L);
        accountEntity.setUpdateDateTime(new Date());
        threadContext.setAccountEntity(accountEntity);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清除绑定线程的数据
        ThreadContext.getThreadInstance().remove();
    }
}
