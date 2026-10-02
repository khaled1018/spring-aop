package lab_3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AdviceAspect {

    @Before("execution(* lab_3.service.AccountService.*(..))")
    public void logBefore(JoinPoint jp) {
        System.out.println("BEFORE: " + jp.getSignature().getName() + " " + Arrays.toString(jp.getArgs()));
    }

    @After("execution(* lab_3.service.AccountService.*(..))")
    public void logAfter(JoinPoint jp) {
        System.out.println("AFTER (always)");
    }

    @AfterReturning(pointcut = "execution(* lab_3.service.AccountService.*(..))",
            returning = "result"
    )
    public void logSuccess(JoinPoint jp, Object result) {
        System.out.println("SUCCESS: " + jp.getSignature() + " returned " + result);
    }

    @AfterThrowing(pointcut = "execution(* lab_3.service.AccountService.*(..))",
            throwing = "ex")
    public void logFailure(JoinPoint jp, Exception ex) {
        System.out.println("ERROR in " + jp.getSignature() + ": " + ex.getMessage());
    }

//    @Around("execution(* lab_3.service.AccountService.*(..))")
//    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
//
//        long start = System.currentTimeMillis();
//        System.out.println("START: " + pjp.getSignature());
//
//        Object result = pjp.proceed();
//
//        System.out.println("END: " + pjp.getSignature() + " took " + (System.currentTimeMillis() - start) + "ms");
//
//        return result;
//
//        // It will return exception ===> Null return value from advice does not match primitive return type for:
//        // public abstract double lab_3.service.AccountService.getBalance(java.lang.String)
////        return null;
//    }

    @Around("execution(* lab_3.service.AccountService.withdraw(..))")
    public Object capAmount(ProceedingJoinPoint pjp) throws Throwable {

        Object[] args = pjp.getArgs();

        double amount = (double) args[1];
        if(amount > 1000) {
            System.out.println("Capping amount: " + amount + " to 1000");
            args[1] = 1000.0;
        }

        return pjp.proceed(args);
    }

    @Around("@annotation(lab_3.aop.LogExecutionTime)")
    public Object timeIt(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed(pjp.getArgs());
        System.out.println("Log Execution Time: " + (System.currentTimeMillis() - start) + "ms");
        return result;
    }

}
