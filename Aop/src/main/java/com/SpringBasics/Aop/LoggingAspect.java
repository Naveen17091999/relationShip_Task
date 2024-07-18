package com.SpringBasics.Aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.SpringBasics.Aop.UserService.createUser(..))")
    public void logBeforeCreateUser() {
        System.out.println("Logging: About to create a user");
    }

    @After("execution(* com.SpringBasics.Aop.UserService.deleteUser(..))")
    public void logAfterDeleteUser() {
        System.out.println("After: Finished delete user method");
    }

    @AfterReturning(pointcut = "execution(* com.SpringBasics.Aop.UserService.getUser(..))", returning = "result")
    public void logAfterReturningGetUser(String result) {
        System.out.println("AfterReturning: User retrieved: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.SpringBasics.Aop.UserService.throwing(..))", throwing = "ex")
    public void logAfterThrowingDeleteUser(Exception ex) {
        System.out.println("AfterThrowing: An exception occurred: " + ex.getMessage());
    }

    @Around("execution(* com.SpringBasics.Aop.UserService.*(..))")
    public Object logAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around: Before executing " + joinPoint.getSignature().getName());
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        System.out.println("Around: After executing " + joinPoint.getSignature().getName() +
                ". Time taken: " + (end - start) + "ms");
        return result;
    }
}