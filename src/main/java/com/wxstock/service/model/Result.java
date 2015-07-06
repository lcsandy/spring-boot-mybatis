package com.wxstock.service.model;

import lombok.Data;

/**
 * public result
 * Created by wcong on 15/5/22.
 */
@Data
public class Result<T> {

    private boolean success;

    private int code;

    private String message;

    private T data;


    public static <T> Result<T> success(T t) {
        Result<T> result = new Result<T>();
        result.success = true;
        result.code = 0;
        result.data = t;
        return result;
    }

    public static Result error(int code, String message) {
        Result result = new Result();
        result.success = false;
        result.code = code;
        result.message = message;
        return result;
    }
}
