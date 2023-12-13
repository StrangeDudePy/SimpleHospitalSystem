
package com.example.Hospital;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;



public class PatientManagement extends GUI {
    

    protected static String PURL="/home/sefa/Desktop/Lecture Materials/OOP/Automation Hospital/maven-demo/Databases/Patients.db";

    private static SQLConnection conn = new SQLConnection();

    JFrame pamanagementFrame = new JFrame();

    JTable pmanagemenTable = new JTable();


    //Arrays of Objects to store patient information data

    PatientInfo[][] arrdata;
    

    private static String[][] tableData(){
        Connection connection = conn.connect(PURL);
        
        String sqlQuerrty = "SELECT id, name, capacity FROM warehouses";

        conn.connect(PURL);

    }

    protected void CPManagementMenu(JFrame obj,JTable obj2){

          

    }


    
}
