package com.zhaolei.spring_boot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class PersonAspect {

    private static final Logger log = LoggerFactory.getLogger(PersonAspect.class);

    @Pointcut("execution(public * com.zhaolei.spring_boot.controller.ControllTest.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //url
        log.info("url:{}", attributes.getRequest().getRequestURL());
        //IP地址
        log.info("ip:{}", attributes.getRequest().getRemoteAddr());
        //请求方式
        log.info("method:{}", attributes.getRequest().getMethod());
        //请求调用的类方法
        log.info("class_method:{}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //请求参数
        log.info("params_agrs:{}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {

    }

    @AfterReturning(pointcut = "log()",returning = "object")
    public void doReturn(Object object) {
        log.info("result:{}",object.toString());
    }


}
