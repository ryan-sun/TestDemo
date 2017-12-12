package com.ryan.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * 返回数据格式
 * author： sr on 2017/8/17.
 * e-mail：
 */

public class BaseResponse {
    @SerializedName("code")
    private String code;
    @SerializedName("errorMsg")
    private String errorMsg;
//    @SerializedName("subjects")
//    private T data;
    @SerializedName("success")
    private boolean success;
    @SerializedName("errorType")
    private int errorType;

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
