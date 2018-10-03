package bank;

import java.util.List;
import java.util.Objects;

public abstract class AbstractBankingOperations implements BankingOperations {
    private double accountBalance;
    private List<String> operationsHistory;

    @Override
    public void deposit(double amount) {
        if (amount > 0 ) {
            accountBalance += amount;
            operationsHistory.add("DEPOSIT_"+amount);
        }
        else {
            operationsHistory.add("CANCELLED");
        }
    }

    protected AbstractBankingOperations(){ }
    protected AbstractBankingOperations(double accountBalance, List<String> operationsHistory) {
        this.accountBalance = accountBalance;
        this.operationsHistory = operationsHistory;
    }

    protected void setOperationsHistory(List<String> operationsHistory) {
        for (int i = 0; i < operationsHistory.size(); i++) {
            if (!operationsHistory.get(i).matches("(DEPOSIT|WITHDRAWAL|CANCELLED|LOGIN_ERROR)_?\\d*")){
                System.out.println("Error in saving operation on index: " + i);
            }
        }
        this.operationsHistory = operationsHistory;
    }

    // deposit or withdrawal in String format
    protected static double amount(String amountTxt) {
        String[] amount = amountTxt.split("_");
        return amount[0].startsWith("W")
                ? Double.parseDouble(amount[amount.length - 1])
                : -Double.parseDouble(amount[amount.length - 1]);
    }

    protected double checkAccountBefore(int n){
        double sum = operationsHistory
                .stream()
                .skip(operationsHistory.size() - n)
                .filter(x -> endsWithDigit(x))
                .map(x -> amount(x))
                .reduce(0.0, (x1, x2) -> x1 + x2);
        return accountBalance + sum;
    }

    protected boolean endsWithDigit(String a){
        return  a.matches("[A-Z]+_(\\d+\\.)?\\d+");
    }

    protected int amountOfCancelledOperations(){
        return (int) operationsHistory
                .stream()
                .filter( x -> x.equalsIgnoreCase("CANCELLED"))
                .count();
    }

    protected void removeTransactionsHistory(){
        operationsHistory.removeAll(getOperationsHistory());

    }

    protected void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    protected List<String> getOperationsHistory() {
        return operationsHistory;
    }

    @Override
    public double getAccountBalance() {
        return accountBalance;
    }

    @Override
    public String toString() {
        return "AbstractBankingOperations{" +
                "accountBalance=" + accountBalance +
                ", operationsHistory=" + operationsHistory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractBankingOperations that = (AbstractBankingOperations) o;
        return Double.compare(that.accountBalance, accountBalance) == 0 &&
                Objects.equals(operationsHistory, that.operationsHistory);
    }

    @Override
    public int hashCode() {

        return Objects.hash(accountBalance, operationsHistory);
    }
}
