
package com.example.Hospital;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.Date;




public class PatientManagement extends GUI {
    MainMenu objMainMenu = new MainMenu();
    private JFrame o1Frame = new JFrame();
    private  JTable o1JTable= new JTable() ;
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
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date utilDate = dateFormat.parse(rNo.getString("AppointDate"));
                        appointDate[DateIndex] = new java.sql.Date(utilDate.getTime());
                        DateIndex++;
                    }
                }
            }
        }

    } catch (SQLException | ParseException e) {
        System.out.println("SQLException: " + e.getMessage());
    }

    System.out.println(appointDate[0]);
    return appointDate;
}


    public void CreateTheO1(MainMenu obj){
        obj.CreateOption1Page(o1Frame, o1JTable);
    }
     
   
   


    private void DeletePatient(){

    }

    private void ModifyPatient(){
        
    }

    private void AddPatient(){
        
    }

    protected void CreateConfirmationScreen(){
    
    JPanel mnpanel = new JPanel();
    JFrame mnframe = new JFrame();
    JLabel mnidlabel;
    JTextField mnuserid;
    JLabel mnpassLabel;
    JPasswordField mnpasswordt;
    JButton mnconbutton;
    JLabel mnsucces;
    JLabel mnauthTextLabel;
    JTextField mnauthTextField;

        mnframe.setSize(400,200);
        mnframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        mnframe.add(mnpanel);

        mnpanel.setLayout(null);

        mnidlabel = new JLabel("STAFF ID");
        mnidlabel.setBounds(10,20,80,25);
        mnpanel.add(mnidlabel);

        mnuserid = new JTextField();
        mnuserid.setBounds(180,20,165,25);
        mnpanel.add(mnuserid);

        mnpassLabel = new JLabel("Password");
        mnpassLabel.setBounds(10,50,80,25);
        mnpanel.add(mnpassLabel);

        mnpasswordt = new JPasswordField();
        mnpasswordt.setBounds(180,50,165,25);
        mnpanel.add(mnpasswordt);

        mnauthTextLabel = new JLabel("Authentication Code");
        mnauthTextLabel.setBounds(10, 80, 150, 25);
        mnpanel.add(mnauthTextLabel);

        mnauthTextField = new JTextField();
        mnauthTextField.setBounds(180,80, 165,25);
        mnpanel.add(mnauthTextField);

        
        mnconbutton = new JButton("Login");
        mnconbutton.setBounds(10,110,80,25);
        mnconbutton.addActionListener(new GUI());
        mnpanel.add(mnconbutton);

        mnsucces = new JLabel("");
        mnsucces.setBounds(10,110,300,25);
        mnpanel.add(mnsucces);

        mnframe.setVisible(true);
        frame.setResizable(false);
    }

    

    private void Authentication(){

    }


 }