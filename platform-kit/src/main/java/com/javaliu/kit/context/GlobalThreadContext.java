package com.javaliu.kit.context;

public class GlobalThreadContext {

    private static final ThreadLocal<GlobalThreadContext> CONTEXT = new ThreadLocal<>();

    /**
     * 构造方法私有化
     */
    private GlobalThreadContext(){}

    /**
     * 获取 GlobalThreadContext 实例
     * @return
     */
    public static final GlobalThreadContext getThreadInstance(){
        GlobalThreadContext globalThreadContext = CONTEXT.get();
        if(null == globalThreadContext){
            globalThreadContext = new GlobalThreadContext();
            CONTEXT.set(globalThreadContext);
        }
        return globalThreadContext;
    }

    public void remove(){
        CONTEXT.remove();
    }

    private String ipAddress;
    private String uuid;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
