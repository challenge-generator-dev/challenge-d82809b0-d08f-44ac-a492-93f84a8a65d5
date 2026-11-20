package core.application.ports;

import core.domain.Account;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepositoryPort {
    Account save(Account account);
    Optional<Account> findById(UUID id);
    List<Account> findAll();
    List<Account> findByOwnerName(String ownerName);
    void deleteById(UUID id);
    Optional<Account> findByAccountNumber(String accountNumber);
}