package lab_2;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public InventoryServiceImpl inventoryServiceTarget() {
        return new InventoryServiceImpl();
    }

    @Bean
    public MethodBeforeAdvice loggingBeforeAdvice() {
        return new LoggingBeforeAdvice();
    }

    @Bean
    public AfterReturningAdvice loggingAfterReturningAdvice() {
        return new LoggingAfterReturningAdvice();
    }

    @Bean
    public ThrowsAdvice loggingThrowsAdvice() {
        return new LoggingThrowsAdvice();
    }

    @Bean
    public TimingInterceptor timingInterceptor() {
        return new TimingInterceptor();
    }

    @Bean
    public ProxyFactoryBean inventoryService() {
        ProxyFactoryBean factory = new ProxyFactoryBean();
        factory.setTarget(inventoryServiceTarget());
        factory.setInterceptorNames(
                "loggingBeforeAdvice",
                "loggingAfterReturningAdvice",
                "loggingThrowsAdvice",
                "timingInterceptor"
        );

        return factory;
    }

}
