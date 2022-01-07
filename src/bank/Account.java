package session13_excersice;

public class Account {
    private String id;
    private Long amount;

    public Account(String id) {
        this.id = id;
        this.amount = 0L;
    }

    public void withdraw(Long amount) {
        if (amount > this.amount)
            System.out.println("Insufficient funds!");
        else
            this.amount -= amount;

    }

    public void deposit(Long amount) {
        this.amount += amount;
    }
}
