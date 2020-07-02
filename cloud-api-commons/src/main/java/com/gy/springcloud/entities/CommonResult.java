package com.gy.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author gaoyue
 * @create 2020-07-01 15:01
 * 返回前端各种结果以及对应代码的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {


    private Integer code;
    private String message;
    private T       data;


    public CommonResult(Integer code, String message) {

        this(code, message, null);
    }
}
