package infrastructure.persistence;

import core.domain.Account;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio Spring Data de cuentas. Solo expone operaciones de persistencia:
 * el mapeo a dominio y los contratos de puerto viven en infrastructure.adapters.AccountRepositoryAdapter.
 */
@Repository
public interface JpaAccountRepository extends JpaRepository<AccountEntity, UUID> {

    default Account save(Account account) {
        AccountEntity entity = AccountEntity.fromDomain(account);
        AccountEntity savedEntity = save(entity);
        return savedEntity.toDomain();
    }

    List<AccountEntity> findByOwnerNameContainingIgnoreCase(String ownerName);

    Optional<AccountEntity> findByAccountNumber(String accountNumber);
}

@Entity
@Table(name = "accounts")
@EntityListeners(AuditingEntityListener.class)
class AccountEntity {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Column(nullable = false)
    private String ownerName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Account.AccountType accountType;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean isActive;

    public AccountEntity() {
    }

    public AccountEntity(UUID id, String accountNumber, String ownerName, Account.AccountType accountType,
                         BigDecimal balance, LocalDateTime createdAt, LocalDateTime updatedAt, boolean isActive) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.accountType = accountType;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isActive = isActive;
    }

    public static AccountEntity fromDomain(Account account) {
        return new AccountEntity(
                account.id(),
                account.accountNumber(),
                account.ownerName(),
                account.accountType(),
                account.balance(),
                account.createdAt(),
                account.updatedAt(),
                account.isActive()
        );
    }

    public Account toDomain() {
        return new Account(
                id,
                accountNumber,
                ownerName,
                accountType,
                balance,
                createdAt,
                updatedAt,
                isActive
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Account.AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(Account.AccountType accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}