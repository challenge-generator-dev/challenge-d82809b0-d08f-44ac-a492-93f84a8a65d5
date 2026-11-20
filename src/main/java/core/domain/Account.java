package core.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Account(
    @NotNull UUID id,
    @NotBlank String accountNumber,
    @NotBlank String ownerName,
    @NotNull AccountType accountType,
    @PositiveOrZero BigDecimal balance,
    @NotNull LocalDateTime createdAt,
    @NotNull LocalDateTime updatedAt,
    boolean isActive
) {
    public enum AccountType {
        SAVINGS,
        CHECKING,
        FIXED_TERM
    }

    public Account {
        if (id == null) {
            id = UUID.randomUUID();
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (updatedAt == null) {
            updatedAt = LocalDateTime.now();
        }
        if (balance == null) {
            balance = BigDecimal.ZERO;
        }
    }

    public Account updateBalance(BigDecimal newBalance) {
        if (newBalance == null || newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        return new Account(
            this.id,
            this.accountNumber,
            this.ownerName,
            this.accountType,
            newBalance,
            this.createdAt,
            LocalDateTime.now(),
            this.isActive
        );
    }

    public Account deactivate() {
        return new Account(
            this.id,
            this.accountNumber,
            this.ownerName,
            this.accountType,
            this.balance,
            this.createdAt,
            LocalDateTime.now(),
            false
        );
    }
}