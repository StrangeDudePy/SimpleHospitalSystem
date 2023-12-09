package com.example.Hospital;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StaffSystem extends SQLConnection {

    void createtabledoctor() {
        String doctorlogin = "CREATE TABLE IF NOT EXISTS staffinfo (\n "
                + "staffnum integer PRIMARY KEY,\n"
                + "name_surname text NOT NULL , \n"
                + "policlinic text NOT NULL \n"
                + ");";

        try (Connection conn = connect();  // Use the connect method from SQLConnection
                Statement stmt = conn.createStatement()) {
            stmt.execute(doctorlogin);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        StaffSystem staf = new StaffSystem();
        staf.createtabledoctor();
    }
}

