package lab_1;

public interface NotificationService {
    public void sendEmail(String to, String message);
    public void sendSMS(String to, String message);
}
