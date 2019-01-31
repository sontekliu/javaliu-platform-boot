package com.javaliu.boot.base.result;

import java.util.List;

public class ResultList<T> extends AbstractResult{

    private List<T> result;

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
