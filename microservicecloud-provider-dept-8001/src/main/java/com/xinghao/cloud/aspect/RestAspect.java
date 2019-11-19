package com.xinghao.cloud.aspect;

import com.xinghao.cloud.utils.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author caoxinghao
 * @Date 2019/11/19 10:35
 * @Description:
 */
@Aspect
@Component
public class RestAspect {


    /**
     * 五种切面定义类型
     * @Before: 前置通知, 在方法执行之前执行
     * @After: 后置通知, 在方法执行之后执行 。
     * @AfterRunning: 返回通知, 在方法返回结果之后执行
     * @AfterThrowing: 异常通知, 在方法抛出异常之后
     * @Around: 环绕通知, 围绕着方法执行
     */

    /**
     * JoinPoint对象封装了SpringAop中切面方法的信息,在切面方法中添加JoinPoint参数,就可以获取到封装了该方法信息的JoinPoint对象.
     * 常用api:
     * Signature getSignature();	获取封装了署名信息的对象,在该对象中可以获取到目标方法名,所属类的Class等信息
     * Object[] getArgs();	获取传入目标方法的参数对象
     * Object getTarget();	获取被代理的对象
     * Object getThis();	获取代理对象
     * ProceedingJoinPoint对象
     * ProceedingJoinPoint对象是JoinPoint的子接口,该对象只用在@Around的切面方法中,
     * 添加了
     * Object proceed() throws Throwable //执行目标方法
     * Object proceed(Object[] var1) throws Throwable //传入的新的参数去执行目标方法
     * 两个方法.
     */



    private static Logger logger = LoggerFactory.getLogger(RestAspect.class);
    /**
     * 切入点
     */
    @Pointcut("execution(* com.xinghao.cloud.controller..*.*(..))")
    public void controllerMethodPointcut(){

    }

    /**
     * 在此切入点之前执行
     */
    @Before("controllerMethodPointcut()")
    public void before(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String ip = IpUtils.getIPAddress(request);

        String declaringTypeName = signature.getDeclaringTypeName();

        System.out.println("请求的ip地址"+ip);
        System.out.println("declaringTypeName"+declaringTypeName);
        System.out.println("执行的方法的名字为："+methodName);
        logger.info("方法名字",methodName);
    }



}
