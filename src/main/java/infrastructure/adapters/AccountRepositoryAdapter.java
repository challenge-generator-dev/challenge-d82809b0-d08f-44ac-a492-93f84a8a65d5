// TODO(reto): archivo stubbeado; implementa los cuerpos.
package infrastructure.adapters;

import core.application.ports.AccountRepositoryPort;
import core.domain.Account;
import infrastructure.persistence.JpaAccountRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AccountRepositoryAdapter implements AccountRepositoryPort {

    private final JpaAccountRepository jpaRepository;

    public AccountRepositoryAdapter(JpaAccountRepository jpaRepository) {
        if (jpaRepository == null) {
            throw new IllegalArgumentException("JpaAccountRepository cannot be null");
        }
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Account> findById(UUID id) {
      throw new UnsupportedOperationException("TODO(reto): findById");
    }

    @Override
    public Account save(Account account) {
      throw new UnsupportedOperationException("TODO(reto): save");
    }

    @Override
    public List<Account> findAll() {
      throw new UnsupportedOperationException("TODO(reto): findAll");
    }

    @Override
    public List<Account> findByOwnerName(String ownerName) {
      throw new UnsupportedOperationException("TODO(reto): findByOwnerName");
    }

    @Override
    public void deleteById(UUID id) {
      throw new UnsupportedOperationException("TODO(reto): deleteById");
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
      throw new UnsupportedOperationException("TODO(reto): findByAccountNumber");
    }
}