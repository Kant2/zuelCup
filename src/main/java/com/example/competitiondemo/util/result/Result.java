package com.example.competitiondemo.util.result;

import lombok.Data;

/**
 * 统一API响应结果
 */
@Data
public class Result<T> {

    private int code;
    private String message;
    private T data;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        return this;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

}
