/**
 * All rights Reserved, Designed By MiGu
 * Copyright: Copyright(C) 2016-2020
 * Company MiGu Co., Ltd.
 */
package com.migu.consumer.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 项目名称: Rainbow Stone for cartoon 包: com.migu.rstone.aspect 类名称: LogAspect.java 类描述: web 请求日志切面类 创建人: guhao 创建时间:
 * 2017/7/28 14:36
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 定义一个切点.
     */
    @Pointcut("execution(public * com.migu.consumer.controller.*.*(..))")
    public void webLog() {
    }


    @Pointcut("execution(public * com.migu.consumer.client.*.*(..))")
    public void client() {
    }

    @Around("client()")
    public Object aroundClient(final ProceedingJoinPoint jp) throws Throwable {

        Object[] args = jp.getArgs();
        String clientName=getClientName(jp.getTarget().toString());
        String method = jp.getSignature().getName();

        LOG.info("invoke client {} method={}, params={}", clientName ,method, args[0]);
        StopWatch clock = new StopWatch();
        clock.start();

        Object result = jp.proceed();
        clock.stop();
        LOG.info("end invoke client {} method={}, rsp={}, costs={}ms", clientName ,method, result, clock.getTotalTimeMillis());
        return result;
    }

    protected String getClientName(String s) throws Exception {

        String clientName ="";
        if(s.contains("HardCodedTarget")&&s.contains("name")) {
            int i = s.indexOf(",");
            String s1 = s.substring(i + 1);
            String s2 = s1.substring(0, s1.indexOf(","));
            clientName = s2.split("=")[1];
        }
        return clientName;
    }

}
