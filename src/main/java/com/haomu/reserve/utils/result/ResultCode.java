package com.haomu.reserve.utils.result;



public class ResultCode {
    private int code;
    private String msg;

    /*----------------------------- constructor -----------------------------------*/
    public ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /*------------------------------- builder -------------------------------------*/
    private ResultCode(Builder builder) {
        this.code = builder.code;
        this.msg = builder.msg;
    }

    static class Builder {
        private int code;
        private String msg;

        public Builder setCode(int code) {
            this.code = code;
            return this;
        }
        public Builder setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public ResultCode build() {
            return new ResultCode(this);
        }
    }

    /*-------------------------------- method -------------------------------------*/
    private static ResultCode dispose(ResultCodeEnum codeEnum) {
        return new ResultCode.Builder()
                .setCode(codeEnum.getCode())
                .setMsg(codeEnum.getMsg())
                .build();
    }

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

    /*-------------------------------- const --------------------------------------*/
    // 默认成功
    public final static ResultCode SUCCESS = dispose(ResultCodeEnum.SUCCESS);

    // 默认失败
    public final static ResultCode ERROR = dispose(ResultCodeEnum.ERROR);
}

