package com.ryan.network.exception;

import com.ryan.network.response.BaseResponse;

/**
 * 数据异常
 * author： sr on 2017/8/18.
 * e-mail：
 */

public class ResponseException extends Exception{
    private String mMessage;
    private String statusCode;
    public ResponseException(BaseResponse response) {
        super(response.getCode());
        mMessage = response.getErrorMsg();
        statusCode = response.getCode();
    }

    @Override
    public String getMessage() {
        return mMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
