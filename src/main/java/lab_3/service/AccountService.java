package lab_3.service;

public interface AccountService {

    double withdraw(String id, double amount);   // throws IllegalStateException if insufficient funds
    void deposit(String id, double amount);
    double getBalance(String id);
}
