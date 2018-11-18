package com.common.cache.dto;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    private Integer code;

    private String errMsg;

    private Object result;

    public BaseResponse() {
    }

    public BaseResponse(Integer code, Object result) {
        this.code = code;
        this.result = result;
    }

    public BaseResponse(Integer code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }


    public static BaseResponse success(Object result) {
        return new BaseResponse(100, result);
    }

    public static BaseResponse fail(String errMsg) {
        return new BaseResponse(200, errMsg);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
