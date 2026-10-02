package lab_2;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class LoggingThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
        System.out.println(
                "ERROR in " + method.getName() + ": " + ex.getMessage()
        );
    }
}
