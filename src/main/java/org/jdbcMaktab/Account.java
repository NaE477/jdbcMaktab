package org.jdbcMaktab;

import Repositories.AccountRepositories;

import java.sql.Connection;
import java.sql.SQLException;

public class Account {



    private String id;
    private Long amount;
    Connection connection = conClass.getConnection();

    private AccountRepositories accountRepositories = new AccountRepositories();

    public Long getAmount() {
        return amount;
    }

    public Account(String id) throws SQLException, ClassNotFoundException {
        this.id = id;
        this.amount = 0L;
    }

    public void withdraw(Long amount) {
        if (amount > this.amount)
            System.out.println("Insufficient funds!");
        else {
            this.amount -= amount;
            long newAmount = this.amount - amount;
        }
    }

    public void deposit(Long amount) {
        this.amount += amount;
    }

    public String getId() {
        return id;
    }
}
