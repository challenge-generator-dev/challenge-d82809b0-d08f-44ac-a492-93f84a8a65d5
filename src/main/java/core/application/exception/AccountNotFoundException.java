package core.application.exception;


import core.domain.Account;
public class AccountNotFoundException extends RuntimeException {

    private final String accountId;
    private final String accountNumber;

    public AccountNotFoundException(String message) {
        super(message);
        this.accountId = null;
        this.accountNumber = null;
    }

    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.accountId = null;
        this.accountNumber = null;
    }

    public AccountNotFoundException(String message, String accountId) {
        super(message);
        this.accountId = accountId;
        this.accountNumber = null;
    }

    public AccountNotFoundException(String message, String accountId, String accountNumber) {
        super(message);
        this.accountId = accountId;
        this.accountNumber = accountNumber;
    }

    public AccountNotFoundException(String message, String accountId, Throwable cause) {
        super(message, cause);
        this.accountId = accountId;
        this.accountNumber = null;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AccountNotFoundException: ").append(getMessage());
        
        if (accountId != null) {
            sb.append(" [Account ID: ").append(accountId).append("]");
        }
        
        if (accountNumber != null) {
            sb.append(" [Account Number: ").append(accountNumber).append("]");
        }
        
        return sb.toString();
    }

    public String getDetailedMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("No se encontró la cuenta solicitada.\n");
        
        if (accountId != null) {
            sb.append("ID de cuenta: ").append(accountId).append("\n");
        }
        
        if (accountNumber != null) {
            sb.append("Número de cuenta: ").append(accountNumber).append("\n");
        }
        
        sb.append("Por favor, verifique los datos e intente nuevamente.");
        
        return sb.toString();
    }

    public boolean hasAccountId() {
        return accountId != null && !accountId.isEmpty();
    }

    public boolean hasAccountNumber() {
        return accountNumber != null && !accountNumber.isEmpty();
    }
}