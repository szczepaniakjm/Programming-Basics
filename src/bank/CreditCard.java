package bank;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CreditCard extends AbstractBankingOperations{
    private String pin;

    protected CreditCard() {}
    protected CreditCard(String pin) {
        this.pin = pin;
    }

    protected CreditCard(double accountBalance, List<String> operationsHistory, String pin) {
        super(accountBalance, operationsHistory);
        this.pin = pin;
    }

    protected String getPin() {
        return pin;
    }

    protected void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public void withdrawal(double amount) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give the Pin of the Card and press Enter");
        if (isPinCorrect(sc.nextLine())) {
            if (getAccountBalance() >= amount) {
                setAccountBalance(getAccountBalance() - amount);
                getOperationsHistory().add("WITHDRAWAL_" + amount);
            } else {
                getOperationsHistory().add("CANCELLED");
                System.out.println("Operation cancelled");
            }
        } else {
            getOperationsHistory().add("LOGIN_ERROR");
            System.out.println("Login error, unable to withdraw");
        }
    }

    protected boolean isPinCorrect(String pin) {
        return pin.equals(this.pin);
    }

    @Override
    protected void removeTransactionsHistory() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give the Pin of the Card and press Enter");
        if (isPinCorrect(sc.nextLine())) {
            super.removeTransactionsHistory();
        } else {
            getOperationsHistory().add("LOGIN_ERROR");
            System.out.println("Login error, unable to remove");
        }
    }

    protected static CreditCard theFewestErrors(List<CreditCard> cards) {
        return cards
                .stream()
                .collect(Collectors.toMap(Function.identity(), k -> k.getOperationsHistory().stream().filter(x -> x.startsWith("L")).count())) //key = card, value = errors amount
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .findFirst()
                .orElseThrow(NullPointerException::new)
                .getKey();

    }

    protected static CreditCard largerAccountBalance(CreditCard card1, CreditCard card2) {
        return card1.getAccountBalance() > card2.getAccountBalance() ? card1 : card2;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "pin='" + pin + '\'' +
                '}';
    }
}
