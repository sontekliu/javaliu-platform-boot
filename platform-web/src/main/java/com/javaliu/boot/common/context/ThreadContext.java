package com.javaliu.boot.common.context;

import com.javaliu.boot.modules.account.entity.AccountEntity;

public class ThreadContext {

    private static final ThreadLocal<ThreadContext> CONTEXT = new ThreadLocal<>();

    /**
     * 构造方法私有化
     */
    private ThreadContext(){}

    /**
     * 获取 ThreadContext 实例
     * @return
     */
    public static final ThreadContext getThreadInstance(){
        ThreadContext threadContext = CONTEXT.get();
        if(null == threadContext){
            threadContext = new ThreadContext();
            CONTEXT.set(threadContext);
        }
        return threadContext;
    }

    public void remove(){
        CONTEXT.remove();
    }

    private AccountEntity accountEntity;

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }
}
