package com.zhaolei.spring_boot.handler;

import com.zhaolei.spring_boot.entities.Result;
import com.zhaolei.spring_boot.exception.PersonException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class PersonExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e){
        Result result = new Result();
        if (e instanceof PersonException){
            PersonException personException = (PersonException) e;
            result.setMsg(personException.getMessage());
            result.setCode(personException.getCode());
            return result;
        }
        result.setCode(-1);
        result.setMsg("[其他错误]:" + e.getMessage());
        return result;
    }

}
