package com.javaliu.boot.base.result;

public class ResultOne<T> extends AbstractResult{

    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
