package bank;

public interface BankingOperations {
    void deposit(double amount);
    void withdrawal(double amount);
    double getAccountBalance();
}
