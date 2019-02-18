package com.javaliu.boot.modules.shortlink.kit;

import org.apache.commons.lang3.RandomUtils;

public class Base62 {
    private static final String BASE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * 将数值转换为字符串
     * @param num
     * @return
     */
    public static String toBase62(long num){
        StringBuilder str = new StringBuilder();
        int baseLength = BASE.length();
        do {
           int i = (int)(num % baseLength);
           str.append(BASE.charAt(i));
           num /= baseLength;
        }while (num > 0);
        return str.reverse().toString();
    }

    /**
     * 将字符串转换为ID
     * @param input
     * @return
     */
    public static long toBase10(String input){
        int baseLength = BASE.length();
        long result = 0;
        String temp = new StringBuilder(input).reverse().toString();
        for (int i = 0; i < temp.length(); i++){
            int charIndex = BASE.indexOf(temp.charAt(i));
            result += charIndex * Math.pow(baseLength, i);
        }
        return result;
    }

    /**
     * 一个长整型，每隔 5 位插入一个随机数0，1，直到高位都是 0 为止。
     * @param val
     * @return
     */
    public static long insertRandomBitPer5Bits(long val) {
        long result = val;
        long high = val;
        for (int i = 0; i < 10; i++) {
            if (high == 0) {
                break;
            }
            int pos = 5 + 5 * i + i;
            high = result >> pos;
            result = ((high << 1 | RandomUtils.nextInt(0, 2)) << pos)
                    | (result & (-1L >>> (64 - pos)));
        }
        return result;
    }
}
