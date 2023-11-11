package work03;

import work01.Utilitor;
import work02.Person;
import java.util.Objects;

public class Account {
    private static long nextNo = 1_000_000_000;
    private final long no;
    private Person owner;
    private double balance;

    public Account(Person owner) {
        if (owner == null) {
            throw new NullPointerException();
        }
        this.owner = owner;
        balance = 0.0;
        long result = Utilitor.computeIsbn10(nextNo);
        while (result == 10) {
            nextNo++;
            result = Utilitor.computeIsbn10(nextNo);
        }
        no = 10 * nextNo + result;
        nextNo++;
    }

    public long getNo() {
        return no;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        Utilitor.testPositive(amount);
        balance += amount;
        return  balance;
    }

    public  double withdraw(double amount) {
        Utilitor.testPositive(amount);
        balance = balance - amount;
        Utilitor.testPositive(balance);
        return  balance;
    }

    public void transfer(double amount, Account account) {
        if (account == null) {
            throw new IllegalArgumentException();
        }
        withdraw(amount);
        account.deposit(amount);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("no=").append(no);
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return no == account.no && Double.compare(balance, account.balance) == 0 && Objects.equals(owner, account.owner);
    }
}
