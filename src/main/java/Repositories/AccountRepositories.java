package Repositories;

import org.jdbcMaktab.Customer;
import org.jdbcMaktab.conClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AccountRepositories {
    private Connection connection = conClass.getConnection();

    public void createTable() throws SQLException {
        String sqlStatement = "CREATE TABLE IF NOT EXISTS account(" +
                "id     INTEGER primary key," +
                "amount BIGINT" +
                ");";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
        preparedStatement.execute();
        System.out.println("Tick");
    }

    public void withdraw(long amount, Customer customer) throws SQLException {
        String sqlStatement = "UPDATE account SET amount = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
        preparedStatement.setString(2,customer.getAccount().getId());
        preparedStatement.setLong(1,customer.getAccount().getAmount() - amount);
        preparedStatement.executeUpdate();
    }
    public void deposit(long amount,Customer customer) throws SQLException {
        String sqlStatement = "UPDATE account SET amount = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
        preparedStatement.setLong(1,customer.getAccount().getAmount() + amount);
        preparedStatement.setString(2,customer.getAccount().getId());
        preparedStatement.executeUpdate();
    }

    public void register(int id, long amount) {
        try{
            String sqlStatement = "INSERT INTO account (id,amount) VALUES (?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setInt(1,id);
            preparedStatement.setLong(2,amount);
            preparedStatement.execute();
            System.out.println("Register done.");
        }

        catch (SQLException e){
            System.out.println("SQL EXCEPTION");
        }
    }

    public void getCustomerByNationalCode(String id, long newAmount) {

    }
}
