package lab_3.config;

import lab_3.repository.AccountRepository;
import lab_3.service.AccountServiceImpl;
import lab_3.service.OrderService;
import lab_3.service.ReportService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("lab_3")
public class AppConfig {

    @Bean
    public AccountRepository accountRepository() {
        return new AccountRepository();
    }

    @Bean
    public AccountServiceImpl accountServiceImpl() {
        return new AccountServiceImpl(accountRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderService();
    }

    @Bean
    public ReportService reportService() {
        return new ReportService();
    }

}
