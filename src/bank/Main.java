package bank;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        CreditCard cc1 = new CreditCard(1000, list1, "1231");
        CreditCard cc2 = new CreditCard(3000, list2, "1232");
        CreditCard cc3 = new CreditCard(15000, list3, "1233");

        cc1.deposit(1000);
        cc1.deposit(1040);
        cc1.withdrawal(2300);
        cc1.deposit(560);
        cc1.deposit(340);
        cc1.deposit(1880);

        cc2.deposit(1009);
        cc2.deposit(1000);
        cc2.withdrawal(1040);

        cc3.deposit(2300);
        cc3.deposit(560);
        cc3.withdrawal(1880);

        List<CreditCard> creditCards = new ArrayList<>();
        creditCards.add(cc1);
        creditCards.add(cc2);
        creditCards.add(cc3);

        System.out.println("Check account before 3 operations: " + cc1.checkAccountBefore(3));
        System.out.println("Get account balance: " + cc2.getAccountBalance());
        System.out.println("Show card with the fewest errors amount: " + CreditCard.theFewestErrors(creditCards));
        System.out.println("Larger account balance: " + CreditCard.largerAccountBalance(cc1, cc3));
    }
}
