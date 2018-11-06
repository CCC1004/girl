package com.example.girl.utils;

import com.example.girl.domain.Girl;
import com.example.girl.domain.Result;

/**
 * @Author: superC
 * @Date: 2018/11/6 16:53
 */
public class ResultUtils {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(1);
        result.setMessage("成功");
        result.setData(object);
        return  result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code ,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return  result;
    }

}
