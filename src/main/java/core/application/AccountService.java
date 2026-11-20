// TODO(reto): archivo stubbeado; implementa los cuerpos.
package core.application;

import core.application.exception.AccountNotFoundException;
import core.application.ports.AccountRepositoryPort;
import core.domain.Account;
import java.util.UUID;

public class AccountService {

    private final AccountRepositoryPort accountRepository;

    public AccountService(AccountRepositoryPort accountRepository) {
        if (accountRepository == null) {
            throw new IllegalArgumentException("AccountRepositoryPort cannot be null");
        }
        this.accountRepository = accountRepository;
    }

    public Account getAccount(String id) {
      throw new UnsupportedOperationException("TODO(reto): getAccount");
    }

    public Account createAccount(Account account) {
      throw new UnsupportedOperationException("TODO(reto): createAccount");
    }

    public Account updateAccount(Account account) {
      throw new UnsupportedOperationException("TODO(reto): updateAccount");
    }

    public void deleteAccount(String id) {
      throw new UnsupportedOperationException("TODO(reto): deleteAccount");
    }

    public java.util.List<Account> getAllAccounts() {
      throw new UnsupportedOperationException("TODO(reto): getAllAccounts");
    }

    public java.util.List<Account> searchByOwnerName(String ownerName) {
      throw new UnsupportedOperationException("TODO(reto): searchByOwnerName");
    }
}