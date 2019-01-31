package com.javaliu.boot.base.result;

import com.google.gson.Gson;

public abstract class AbstractResult {
    private int flag = 0;  // 0 表示正确
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
