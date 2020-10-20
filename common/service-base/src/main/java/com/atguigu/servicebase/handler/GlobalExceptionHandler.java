package com.atguigu.servicebase.handler;

import com.atguigu.commonutils.R;
import com.atguigu.commonutils.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.common.ExpressionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//统一异常处理类
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.error();
    }

    //特殊异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了自定义异常");
    }

    //自定义异常处理
    @ExceptionHandler(GuliExceptionHandler.class)
    @ResponseBody
    public R error(GuliExceptionHandler e) {
        log.error(ExceptionUtil.getMessage(e));  //记录异常到日志
        e.printStackTrace();
        return R.error().message(e.getMsg()).code(e.getCode());
    }
}
