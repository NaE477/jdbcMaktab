package session13_excersice;

import java.util.Random;

public class Bank {
    private CustomerList customerList;

    public Bank() {
        this.customerList = new CustomerList();
    }

    public void register(String firstName, String lastName, String nationalCode) {
        Customer newCustomer = new Customer(firstName, lastName, nationalCode);
        // ye addad random -> shomare hesab
        Random random = new Random();
        Account account = new Account(String.valueOf(random.nextLong()));
        newCustomer.setAccount(account);
        customerList.add(newCustomer);
    }

    public void withdraw(String nationalCode, Long amount) {
        Customer c = customerList.get(nationalCode);
        c.getAccount().withdraw(amount);
    }

    public void deposit(String nationalCode, Long amount) {
        Customer c = customerList.get(nationalCode);
        c.getAccount().deposit(amount);
    }
}
