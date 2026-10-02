package lab_2;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LoggingAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(
                "SUCCESS: " + method.getName() + " returned " + returnValue
        );

        System.out.println("AFTER: " + method.getName() + " args: " + Arrays.toString(args));
    }
}
