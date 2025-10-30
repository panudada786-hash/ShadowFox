import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

// ====== BankAccount class ======
class BankAccount {
    private double balance;
    private final List<String> transactionHistory;

    public BankAccount() {
        balance = 0.0;
        transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        balance -= amount;
        transactionHistory.add("Withdrew: $" + amount);
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}

// ====== JUnit 5 Test Class ======
public class Bank {

    private BankAccount account;

    @BeforeEach
    public void setup() {
        account = new BankAccount();
    }

    @Test
    public void testInitialBalance() {
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    public void testDeposit() {
        account.deposit(100);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        account.deposit(200);
        account.withdraw(50);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    public void testOverdraft() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(50);
        });
        assertEquals("Insufficient balance.", exception.getMessage());
    }

    @Test
    public void testNegativeDeposit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100);
        });
        assertEquals("Deposit amount must be positive.", exception.getMessage());
    }

    @Test
    public void testNegativeWithdraw() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-20);
        });
        assertEquals("Withdrawal amount must be positive.", exception.getMessage());
    }

    @Test
    public void testTransactionHistory() {
        account.deposit(300);
        account.withdraw(100);
        List<String> history = account.getTransactionHistory();
        assertEquals(2, history.size());
        assertEquals("Deposited: $300.0", history.get(0));
        assertEquals("Withdrew: $100.0", history.get(1));
        }
}