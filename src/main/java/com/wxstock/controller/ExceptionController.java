package com.wxstock.controller;

import com.wxstock.service.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;

/**
 * Created by wcong on 15/6/11.
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result onError(HttpServletRequest request, Exception re) throws Exception {
        if (re instanceof BindException) {
            return Result.error(2, re.getMessage());
        }
        String requestUrl = request.getRequestURI();
        String parameters = request.getQueryString();
        return Result.error(-1, "意料之外的错误");
    }
}
