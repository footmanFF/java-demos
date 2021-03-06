package com.footmanff.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Spring AOP: demo和注释
 *
 * @Pointcut 定义一个方法切面，一般用private方法，方法内不放逻辑
 * @Pointcut 注释的方法名
 *
 * <http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/aop.html>
 * Created by fm on 2017/4/23.
 */
@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    /**
     * 定义一个public方法的切面
     */
    @Pointcut("execution(public * *(..))")
    private void anyPublicOperation() {}

    /**
     * 尝试创建一个顶级接口的切面
     * 执行InterfaceTest接口所有子类的public方法
     */
    @Pointcut("execution(public * com.footmanff.spring.aop.InterfaceTest+.*(..))")
    private void interfaceOperation() {}

    /**
     * 切aop包下所有的类所有的public方法
     */
    // Pointcut("execution(public * com.footmanff.spring.aop.*.*(..))")
    
    /**
     * 定义一个属于com.fm.framework.spring.aop包的切面
     */
    @Pointcut("within(com.footmanff.spring.aop.*)")
    private void inAopClass() {}

    /**
     * 定义一个组合切面，包含 anyPublicOperation() 和 inTrading()
     */
    @Pointcut("anyPublicOperation() && inAopClass()")
    private void aopOperation() {}

    /**
     * 定时任务切面，带有Spring @Scheduled注解的方法
     */
    @Pointcut("@annotation(org.springframework.scheduling.annotation.Scheduled)")
    private void scheduled(){}

    @Pointcut("@annotation(com.footmanff.spring.aop.AnnoAop)")
    private void annoAop(){}
    
    @Pointcut("interfaceOperation() && annoAop()")
    private void combindAnnotationAndInterface(){}
    
    /**
     * 执行前拦截方法
     * @param joinPoint 切面信息对象
     */
    @Before("aopOperation()")
    private void before(JoinPoint joinPoint) {
        // System.out.println("aspect [ " + joinPoint.getTarget().getClass() + " ] before");
    }

    /**
     * 执行后拦截方法（不管异常还是正常返回都拦截）
     */
    @After("aopOperation()")
    private void after() {
        // System.out.println("aspect after");
    }

    /**
     * 正常返回结果后拦截方法
     * @param result
     */
    @AfterReturning(value = "aopOperation()", returning = "result")
    private void afterReturning(String result){
        System.out.println("aspect afterReturning [ " + result + " ]");
    }

    /**
     * 抛出异常后拦截方法
     * @param runtimeException
     */
    @AfterThrowing(value = "aopOperation()", throwing = "runtimeException")
    private void afterThrowing(RuntimeException runtimeException){
        System.out.println("aspect afterThrowing [ " + runtimeException.getMessage() + " ]");
    }

    /**
     * 前后加逻辑的切面
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("aopOperation()")
    private Object doBasicProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object retVal = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        return retVal;
    }

    /**
     * 接口子类所有方法的切面
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("interfaceOperation()")
    private Object aroundInterfaceOperation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object t = proceedingJoinPoint.proceed();
        return t;
    }

    /**
     * 给定时任务前后加逻辑
     * @param proceedingJoinPoint
     * @throws Throwable
     */
//    @Around("scheduled()")
//    private void aroundSchedule(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        try {
//            Object t = proceedingJoinPoint.proceed();
//            int a = 0;
//        } finally {}
//    }
    
    @Around( "interfaceOperation()" )
    private void aroundSchedule(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        AnnoAop annoAop = method.getAnnotation(AnnoAop.class);
        proceedingJoinPoint.proceed();
    }
    
}
