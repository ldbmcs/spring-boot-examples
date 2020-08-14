package com.ldbmcs.secKill.common.exception;

import com.ldbmcs.secKill.common.web.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 * Created by ldbmcs on 2018-02-22 11:29
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class.getName());

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public JsonResult errorHandler(Exception ex, HttpServletResponse response) {
        cross(response);  // 支持跨域
        // 对不同错误进行不同处理
        if (ex instanceof com.ldbmcs.secKill.common.exception.IException) {
            return JsonResult.error(((IException) ex).getCode(), ex.getMessage());
        }
        logger.error(ex.getMessage(), ex);
        return JsonResult.error("系统错误").put("error", ex.toString());
    }

    private void cross(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, Authorization");
    }

}
