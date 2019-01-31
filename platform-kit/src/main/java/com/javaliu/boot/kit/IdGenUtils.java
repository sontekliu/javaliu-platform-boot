package com.javaliu.boot.kit;

import java.util.UUID;

/**
 * <br> 类 名：IdGenUtils
 * <br> 描 述：ID生成器
 * <br> 作 者：javaliu
 * <br> 创 建：2017年08月01日
 * <br> 版 本：V1.0
 */
public class IdGenUtils {

    /**
     * 生成UUID的方法，此UUID不带"-"
     * @return
     * @author javaliu
     */
    public static String gen32Uuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 使用雪花算法生成 可按时间排序的长整形 ID
     * @return
     */
    public static long genDefaultSequenceId(){
        return SnowFlake.getInstance(0, 0).nextId();
    }

    /**
     * 使用雪花算法生成 可按时间排序的长整形 ID
     * @return
     */
    public static long genSequenceId(int dataCenterId, int machineId){
        return SnowFlake.getInstance(dataCenterId, machineId).nextId();
    }
}
