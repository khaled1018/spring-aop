package lab_1;

import javax.security.auth.login.AccountException;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        NotificationService real = new NotificationServiceImpl();
        NotificationService proxy = (NotificationService) Proxy.newProxyInstance(
                NotificationService.class.getClassLoader(),
                new Class[]{NotificationService.class},
                new LoggingHandler(real)
        );
        proxy.sendEmail("Ahmed", "I'm sending email for you");
        proxy.sendSMS("Ahmed", "I'm sending message sms for you");
    }
}
