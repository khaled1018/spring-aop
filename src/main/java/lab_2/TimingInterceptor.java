package lab_2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TimingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + invocation.getMethod().getName());

        try {
            System.out.println("Inside TimingInterceptor");
            return invocation.proceed();

        } finally {
            long timeTaken = System.currentTimeMillis() - start;
            System.out.println("END: took " + timeTaken + "ms");
        }
    }
}
