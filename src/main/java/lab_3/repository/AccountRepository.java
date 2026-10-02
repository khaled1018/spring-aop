package lab_3.repository;

import lab_3.model.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


public class AccountRepository {
    private final Map<String, Account> store = new HashMap<>();

    public AccountRepository() {
        store.put("acc-1", new Account("acc-1", 5000.0));
        store.put("acc-2", new Account("acc-2", 2000.0));
    }

    public Account find(String id) {
        Account a = store.get(id);
        if (a == null) throw new IllegalArgumentException("No such account: " + id);
        return a;
    }
}
