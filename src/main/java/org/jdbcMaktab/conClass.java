package org.jdbcMaktab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conClass {

    private static Connection connection;
    private static conClass conClass = new conClass();

    private conClass(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.
                    getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "postgres");
        } catch (SQLException e) {
            System.out.println();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
