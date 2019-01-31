package com.javaliu.boot.base.result;

public class ResultUtils {

    public static ResultOne successResultOne(Object t){
        ResultOne resultOne = new ResultOne<>();
        resultOne.setResult(t);
        return resultOne;
    }

    public static ResultOne failResultOne(int flag, String message){
        ResultOne resultOne = new ResultOne();
        resultOne.setFlag(flag);
        resultOne.setMessage(message);
        return resultOne;
    }

    public static ResultList failResultList(int flag, String message){
        ResultList resultList = new ResultList();
        resultList.setFlag(flag);
        resultList.setMessage(message);
        return resultList;
    }
}
