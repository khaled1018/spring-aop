package lab_1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingHandler implements InvocationHandler {

    private final Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("LOG: calling " + method.getName());
        Object result = method.invoke(target, args); //call the real method
        System.out.println("LOG: finished " + method.getName());
        return result;
    }
}
