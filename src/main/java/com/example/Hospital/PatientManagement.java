
package com.example.Hospital;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.Time;
import java.sql.Date;




public class PatientManagement extends GUI {
    

    protected static String PURL="jdbc:sqlite:/home/sefa/Desktop/Lecture Materials/OOP/Automation Hospital/maven-demo/Databases/Patients.db";
    JFrame pamanagementFrame = new JFrame();
    JTable pmanagemenTable = new JTable();
    private static String NoQuerry = "SELECT PatientNo FROM PatientsInfo";
    private static String IDQuerry = "SELECT ID FROM PatientsInfo";
    private static String PatientNameQuerry = "SELECT PatientName FROM PatientsInfo";
    private static String DateQuerry = "SELECT AppointDate FROM PatientsInfo";
    private static int patientsNOs[]= new int[100];
    private static String patientsID[] = new String[100];
    private static Date appointDate[] = new Date[100];
    private static String patientNames[] = new String[100];

    protected int[] getpatintNo() {
        try {
            int NoIndex = 0;
    
            // Create a connection
            try (Connection connectionOBJ = DriverManager.getConnection(PURL)) {
    
                try (PreparedStatement NoStatement = connectionOBJ.prepareStatement(NoQuerry)) {
    
                    try (ResultSet rNo = NoStatement.executeQuery()) {
    
                        while (rNo.next()) {
                            patientsNOs[NoIndex] = rNo.getInt("PatientNo");
                            NoIndex++;
                          
                        }
                    }
                }
            }
    
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        
        

        System.out.println(patientsNOs[0]);
        return patientsNOs;
    }
    
    protected String[] getpatintID() {
        try {
            int IDIndex = 0;
    
            // Create a connection
            try (Connection connectionOBJ = DriverManager.getConnection(PURL)) {
    
                try (PreparedStatement NoStatement = connectionOBJ.prepareStatement(IDQuerry)) {
    
                    try (ResultSet rNo = NoStatement.executeQuery()) {
    
                        while (rNo.next()) {
                            patientsID[IDIndex] = rNo.getString("ID");
                            IDIndex++;
                          
                        }
                    }
                }
            }
    
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    
        
        System.out.println(patientsID[0]);
        return patientsID;
    }
    
  protected String[] getpatintName() {
        try {
            int NameIndex = 0;
    
            // Create a connection
            try (Connection connectionOBJ = DriverManager.getConnection(PURL)) {
    
                try (PreparedStatement NoStatement = connectionOBJ.prepareStatement(PatientNameQuerry)) {
    
                    try (ResultSet rNo = NoStatement.executeQuery()) {
    
                        while (rNo.next()) {
                            patientNames[NameIndex] = rNo.getString("PatientName");
                            NameIndex++;
                          
                        }
                    }
                }
            }
    
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        
        

        System.out.println(patientNames[0]);
        return patientNames;
    }        


   protected Date[] getpatintDate() {
    try {
        int DateIndex = 0;

        // Create a connection
        try (Connection connectionOBJ = DriverManager.getConnection(PURL)) {

            try (PreparedStatement NoStatement = connectionOBJ.prepareStatement(DateQuerry)) {

                try (ResultSet rNo = NoStatement.executeQuery()) {

                    while (rNo.next()) {
                        appointDate[DateIndex] = rNo.getDate("AppointDate");
                        DateIndex++;
                    }
                }
            }
        }

    } catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
    }

    System.out.println(appointDate[0]);
    return appointDate;
}

     
   

    protected void CPManagementMenu(JFrame obj,JTable obj2){

          

    }



 }