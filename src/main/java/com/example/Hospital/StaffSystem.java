package com.example.Hospital;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StaffSystem extends SQLConnection {
    private static int AccessLevel ;
    private static Connection aconnect = null;
    private static String  accessQuerry = "Select AuthLevel FROM staffinfo WHERE staffnum = ?";
    private static final String STAFF_URL = "jdbc:sqlite:/home/sefa/Desktop/Lecture Materials/OOP/Automation Hospital/maven-demo/Databases/HospitalInfo.db";
    void createtablesstaff() {
        String doctorlogin = "CREATE TABLE IF NOT EXISTS staffinfo (\n "
                + "staffnum text PRIMARY KEY,\n"
                + "name_surname text NOT NULL , \n"
                + "policlinic text NOT NULL ,\n"
                + "pass text NOT NULL \n"
                + ");";

        try (Connection conn = connect(STAFF_URL);  // Use the connect method from SQLConnection
                Statement stmt = conn.createStatement()) {
            stmt.execute(doctorlogin);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        StaffSystem staf = new StaffSystem();
        staf.createtablesstaff();
    }


    public  int AccessCheck(String staffID){
        try{

            aconnect = DriverManager.getConnection(STAFF_URL);


            try 
                (PreparedStatement accesspstms = aconnect.prepareStatement(accessQuerry)){
                    accesspstms.setString(1, staffID);



                    try(ResultSet accResultSet = accesspstms.executeQuery() ){

                        if(accResultSet.next()){
                            AccessLevel = accResultSet.getInt("AuthLevel");
                        }


                        else{
                            System.out.println("ID Not Found");
                        }
                    }
                }


                
            

        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }


        finally{
            try {
                if (aconnect != null) {
                    aconnect.close();
                }
            } catch (SQLException e) {
                // Handle the closing exception if needed
                System.out.println("Error closing the connection: " + e.getMessage());
            }
        }

        return AccessLevel;
    }
}

