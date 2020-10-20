package com.atguigu.servicebase.handler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //生成有参数构造方法
@NoArgsConstructor //生成无参数构造方法
public class GuliExceptionHandler extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    private String msg;

    @Override
    public String toString() {
        return "GuliExceptionHandler{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
