package com.haomu.reserve.utils.result;

public class Result<T> {
    private int code;
    private String msg;
    private T data;

    /*-------------------------- getter and setter --------------------------------*/
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /*----------------------------- constructor -----------------------------------*/
    /**
     * 构造器,自定义状态码,返回消息
     *
     * @param code 状态码
     * @param msg  返回消息
     */
    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 构造器,自定义状态码,返回消息,返回数据
     *
     * @param code 状态码
     * @param msg  返回消息
     * @param data 返回数据
     */
    private Result(int code, String msg, T data) {
        this(code, msg);
        this.data = data;
    }

    /**
     * 构造器,使用CodeMsg状态码与返回信息
     *
     * @param resultCode CodeMsg,参数如下:
     *                   <p> code 状态码
     *                   <p> msg  返回消息
     */
    private Result(ResultCode resultCode) {
        this(resultCode.getCode(), resultCode.getMsg());
    }

    /**
     * 构造器,使用CodeMsg状态码与返回信息,自定义返回数据
     *
     * @param resultCode CodeMsg,参数如下:
     *                   <p> code 状态码
     *                   <p> msg  返回消息
     * @param data       返回数据
     */
    private Result(ResultCode resultCode, T data) {
        this(resultCode);
        this.data = data;
    }


    /*------------------------- success constructor -------------------------------*/
    private Result(T data){
        this(ResultCode.SUCCESS, data);
    }

    /*------------------------------- success -------------------------------------*/
    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }

    /*-------------------------------- error --------------------------------------*/
    public static <T> Result<T> error(String msg) {
        return new Result<>(ResultCode.ERROR.getCode(), msg);
    }

}
