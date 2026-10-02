package lab_3.service;

import lab_3.aop.LogExecutionTime;
import lab_3.model.Account;
import lab_3.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

// bean name = "accountServiceImpl" (used by bean() in Part C, P10)
public class AccountServiceImpl implements AccountService {

    /** Flip to true in Main to simulate a failure halfway through transfer (Part F4). */
    public static volatile boolean FAIL_HALFWAY = false;

    private final AccountRepository repo;

    @Autowired
    public AccountServiceImpl(AccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public double withdraw(String id, double amount) {
        Account a = repo.find(id);
        if (a.getBalance() < amount) {
            throw new IllegalStateException("Insufficient funds in " + id);
        }
        a.setBalance(a.getBalance() - amount);
        return a.getBalance();
    }

    @LogExecutionTime
    @Override
    public void deposit(String id, double amount) {
        Account a = repo.find(id);
        a.setBalance(a.getBalance() + amount);
    }

    @Override
    public double getBalance(String id) {
        return repo.find(id).getBalance();
    }


    @Override
    public void transfer(String from, String to, double amount) {
        Account src = repo.find(from);
        Account dst = repo.find(to);
        if (src.getBalance() < amount) {
            throw new IllegalStateException("Insufficient funds in " + from);
        }
        src.setBalance(src.getBalance() - amount);      // debit done...
        if (FAIL_HALFWAY) {
            throw new RuntimeException("Simulated failure after debit!");
        }
        dst.setBalance(dst.getBalance() + amount);      // ...credit done
    }

    @Override
    public String getHealth() {
        return "OK";
    }
}
