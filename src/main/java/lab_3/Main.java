package lab_3;

import lab_3.config.AppConfig;
import lab_3.service.AccountService;
import lab_3.service.OrderService;
import lab_3.service.ReportService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AccountService accountService =  context.getBean("accountServiceImpl", AccountService.class);
        OrderService orderService =  context.getBean("orderService", OrderService.class);
        ReportService reportService =  context.getBean("reportService", ReportService.class);

        System.out.println("balance: " + accountService.getBalance("acc-1"));
        accountService.deposit("acc-1", 100);
        System.out.println("withdraw: " + accountService.withdraw("acc-1", 1200));
        System.out.println("report: " + reportService.findReport("Q1"));

        try{
            System.out.println(reportService.generateAnnualReport());
        } catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        orderService.getOrder("o1");   // DB hit
        orderService.getOrder("o1");   // CACHE HIT
        orderService.getOrder("o2");   // CACHE HIT
        orderService.getOrder("o2");


    }
}
