package com.example.girl.exception;


/**
 * @Author: superC
 * @Date: 2018/11/6 17:35
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
