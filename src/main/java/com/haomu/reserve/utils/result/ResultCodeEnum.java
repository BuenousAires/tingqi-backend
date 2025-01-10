package com.haomu.reserve.utils.result;

public enum ResultCodeEnum{
    SUCCESS(0,"操作成功"),
    ERROR  (1,"操作失败");

    private final int code;
    private final String msg;

    /*-------------------------- getter and setter --------------------------------*/

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /*----------------------------- constructor -----------------------------------*/
    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
