package core.application;

import core.application.ports.AccountRepositoryPort;
import core.domain.Account;
import core.domain.Account.AccountType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepositoryPort accountRepository;

    @InjectMocks
    private AccountService accountService;

    private Account testAccount;
    private UUID testAccountId;

    @BeforeEach
    void setUp() {
        testAccountId = UUID.randomUUID();
        testAccount = new Account(
            testAccountId,
            "ACC-001",
            "Juan Perez",
            AccountType.CHECKING,
            BigDecimal.valueOf(1000.00),
            LocalDateTime.now(),
            LocalDateTime.now(),
            true
        );
    }

    @Test
    void getAccount_WhenAccountExists_ReturnsAccount() {
        when(accountRepository.findById(testAccountId))
            .thenReturn(Optional.of(testAccount));

        Account result = accountService.getAccount(testAccountId.toString());

        assertNotNull(result);
        assertEquals(testAccountId, result.id());
        assertEquals("ACC-001", result.accountNumber());
        assertEquals("Juan Perez", result.ownerName());
        verify(accountRepository, times(1)).findById(testAccountId);
    }

    @Test
    void getAccount_WhenAccountNotExists_ThrowsException() {
        UUID nonExistentId = UUID.randomUUID();
        when(accountRepository.findById(nonExistentId))
            .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->
            accountService.getAccount(nonExistentId.toString())
        );
    }

    @Test
    void createAccount_WithValidData_ReturnsCreatedAccount() {
        when(accountRepository.save(any(Account.class)))
            .thenReturn(testAccount);

        Account result = accountService.createAccount(testAccount);

        assertNotNull(result);
        assertEquals("ACC-001", result.accountNumber());
        assertEquals("Juan Perez", result.ownerName());
        verify(accountRepository, times(1)).save(any(Account.class));
    }

    @Test
    void updateAccount_WithValidData_ReturnsUpdatedAccount() {
        Account updatedAccount = new Account(
            testAccountId,
            "ACC-001",
            "Juan Perez Actualizado",
            AccountType.CHECKING,
            BigDecimal.valueOf(2000.00),
            testAccount.createdAt(),
            LocalDateTime.now(),
            true
        );

        when(accountRepository.save(any(Account.class)))
            .thenReturn(updatedAccount);

        Account result = accountService.updateAccount(updatedAccount);

        assertNotNull(result);
        assertEquals("Juan Perez Actualizado", result.ownerName());
        assertEquals(BigDecimal.valueOf(2000.00), result.balance());
        verify(accountRepository, times(1)).save(any(Account.class));
    }

    @Test
    void deleteAccount_WithValidId_CompletesSuccessfully() {
        doNothing().when(accountRepository).deleteById(testAccountId);

        assertDoesNotThrow(() ->
            accountService.deleteAccount(testAccountId.toString())
        );

        verify(accountRepository, times(1)).deleteById(testAccountId);
    }

    @Test
    void getAllAccounts_WhenCalled_ReturnsAllAccounts() {
        List<Account> accounts = List.of(testAccount);
        when(accountRepository.findAll()).thenReturn(accounts);

        List<Account> result = accountService.getAllAccounts();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("ACC-001", result.get(0).accountNumber());
        verify(accountRepository, times(1)).findAll();
    }

    @Test
    void searchByOwnerName_WithValidName_ReturnsMatchingAccounts() {
        List<Account> accounts = List.of(testAccount);
        when(accountRepository.findByOwnerName("Juan Perez")).thenReturn(accounts);

        List<Account> result = accountService.searchByOwnerName("Juan Perez");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Juan Perez", result.get(0).ownerName());
        verify(accountRepository, times(1)).findByOwnerName("Juan Perez");
    }

    @Test
    void getAccount_WithInvalidId_ThrowsException() {
        String invalidId = "invalid-uuid-format";

        assertThrows(IllegalArgumentException.class, () ->
            accountService.getAccount(invalidId)
        );
    }

    @Test
    void createAccount_WithNullAccount_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            accountService.createAccount(null)
        );
    }
}