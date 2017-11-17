package com.zhaolei.spring_boot.utils;

import com.zhaolei.spring_boot.entities.Result;

public class ResultUtils {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }
}
