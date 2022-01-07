package Repositories;

import org.jdbcMaktab.Customer;
import org.jdbcMaktab.conClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositories {

    private static Connection connection = conClass.getConnection();


    public void createTable() throws SQLException {
        String sqlStatement = "CREATE TABLE IF NOT EXISTS customer(" +
                "first_name     VARCHAR(255)," +
                "last_name      VARCHAR(255)," +
                "national_code  VARCHAR(10)," +
                "account_id     INTEGER," +
                "FOREIGN KEY (account_id) REFERENCES account(id)" +
                ");";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
        preparedStatement.execute();
        System.out.println("Tock");
    }

    public void register(String firstName, String lastName, String nationalCode,int account_id) throws SQLException {
        String sqlStatement = "INSERT INTO customer VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
        preparedStatement.setString(1,firstName);
        preparedStatement.setString(2,lastName);
        preparedStatement.setString(3,nationalCode);
        preparedStatement.setInt(4,account_id);
        preparedStatement.executeUpdate();
    }
    public Customer findByNationalCode(String nationalCode) throws SQLException {
        String sqlStatement = "SELECT * FROM customer WHERE national_code = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
        preparedStatement.setString(1,nationalCode);
        ResultSet resultSet = preparedStatement.executeQuery();
        Customer customer = null;
        while(resultSet.next()){
             customer = new Customer(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3));
        }
        return customer;
    }

}
