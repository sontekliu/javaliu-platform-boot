package com.javaliu.boot.base.result;

import com.google.gson.Gson;

public abstract class AbstractResult {
    public static final int SUCCESS = 0;
    public static final int SYSTEM_ERROR = 9999;
    private int flag = SUCCESS;  // 0 表示正确
    private String message;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 转换成 json 对象
     * @return
     */
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
