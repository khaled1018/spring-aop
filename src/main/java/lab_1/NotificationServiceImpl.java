package lab_1;

public class NotificationServiceImpl implements NotificationService {
    @Override
    public void sendEmail(String to, String message) {
        System.out.println("Sending email to " + to + " with message " + message);
    }

    @Override
    public void sendSMS(String to, String message) {
        System.out.println("Sending SMS to " + to + " with message " + message);
    }
}
