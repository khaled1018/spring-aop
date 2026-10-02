package lab_2;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        InventoryService target = new InventoryServiceImpl();

        ProxyFactory proxyFactory = new ProxyFactory(target);

        proxyFactory.addAdvice(new LoggingBeforeAdvice());
        proxyFactory.addAdvice(new LoggingAfterReturningAdvice());
        proxyFactory.addAdvice(new LoggingThrowsAdvice());
        proxyFactory.addAdvice(new TimingInterceptor());

        InventoryService proxy = (InventoryService) proxyFactory.getProxy();

        System.out.println("--- Calling checkStock (Success path) ---");
        proxy.checkStock("SKU-123");
        System.out.println("\n--- Calling reserveStock (Exception path) ---");

        try{
            proxy.reserveStock("SKU-123", 150);
        } catch (IllegalArgumentException ex){
            System.out.println("Cannot reserve more than 100 units at once!");
        }

        // Using Configuration Proxy Factory Bean
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        InventoryService proxy = context.getBean("inventoryService", InventoryService.class);
//
//        System.out.println("--- Calling checkStock via Spring Container ---");
//        proxy.checkStock("SKU-999");
//
//        System.out.println("\n--- Calling reserveStock (Exception path) ---");
//        try{
//            proxy.reserveStock("SKU-123", 150);
//        } catch (IllegalArgumentException ex){
//            System.out.println("Cannot reserve more than 100 units at once!");
//        }

        // Apply logging to reserveStock method only
//        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
//        pointcut.setMappedName("reserveStock");
//        pointcut.setMappedName("checkStock");
//        Advisor advisor = new DefaultPointcutAdvisor(
//                pointcut, new LoggingBeforeAdvice()
//        );
//
//        ProxyFactory proxyFactory = new ProxyFactory(target);
//        proxyFactory.addAdvisor(advisor);
//
//        InventoryService proxy = (InventoryService) proxyFactory.getProxy();
//        System.out.println("--- Calling checkStock (Success path) ---");
//        proxy.checkStock("SKU-123");
//        System.out.println("\n--- Calling reserveStock (Exception path) ---");
//
//        try{
//            proxy.reserveStock("SKU-123", 150);
//        } catch (IllegalArgumentException ex){
//            System.out.println("Cannot reserve more than 100 units at once!");
//        }


    }
}
