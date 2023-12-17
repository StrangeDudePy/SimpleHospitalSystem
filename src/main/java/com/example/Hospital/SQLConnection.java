package com.example.Hospital;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    
protected static final String URL = "jdbc:sqlite:/home/sefa/Desktop/Lecture Materials/OOP/Automation Hospital/maven-demo/Databases/HospitalInfo.db" ;

Connection connection = SQLConnection.connect(URL);
    public static Connection connect(String dbURL) {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(dbURL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database");
        }
    }

    public static void close(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
