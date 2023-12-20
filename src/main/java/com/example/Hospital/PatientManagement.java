
package com.example.Hospital;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.sql.*;



public class PatientManagement  {
    JFrame pamanagementFrame = new JFrame();
    JTable pmanagemenTable = new JTable();
    private JFrame o1Frame = new JFrame();
    private  JTable o1JTable= new JTable() ;
    protected static String PURL="jdbc:sqlite:Databases/Patients.db";
    private static String NoQuerry = "SELECT PatientNo FROM PatientsInfo";
    private static String IDQuerry = "SELECT ID FROM PatientsInfo";
    private static String PatientNameQuerry = "SELECT PatientName FROM PatientsInfo";
    private static String DateQuerry = "SELECT AppointDate FROM PatientsInfo";
    private static String TimeQuerry = "SELECT AppointTime FROM PatientsInfo";
    private static int patientsNOs[]= new int[100];
    private static String patientsID[] = new String[100];
    private static Date appointDate[] = new Date[100];
    private static String patientNames[] = new String[100];
    private static String appointTime[] = new String[100];

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


protected String[] getappointTime() {
        try {
            int TimeIndex = 0;
    
            // Create a connection
            try (Connection connectionOBJ = DriverManager.getConnection(PURL)) {
    
                try (PreparedStatement TimeStatement = connectionOBJ.prepareStatement(TimeQuerry)) {
    
                    try (ResultSet rTime = TimeStatement.executeQuery()) {
    
                        while (rTime.next()) {
                            appointTime[TimeIndex] = rTime.getString("AppointTime");
                            TimeIndex++;
                          
                        }
                    }
                }
            }
    
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    
        
        System.out.println(appointTime[0]);
        return appointTime;
    }







    public void CreateTheO1(MainMenu obj){
        obj.CreateOption1Page(o1Frame, o1JTable);
    }
     
   
   


    private void DeletePatient(){

    }

    private void ModifyPatient(){
        
    }

    
    /*private void CreatePatientAddPage(){
        JPanel addpanel = new JPanel();
        JFrame addFrame = new JFrame();
        JLabel patientNameLabel ;
        JLabel patientAppointDate ;
        JLabel patientIDLabel ;
        JTextField nameField;
        JTextField dateField;
        JTextField idfield;

        addFrame.setSize(400,300);
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addFrame.add(addpanel);

        addpanel.setLayout(null);


        patientNameLabel = new JLabel("Patient Name");
        patientNameLabel.setBounds(10,50,80,25);
        addpanel.add(patientNameLabel);

        nameField = new JTextField();
        nameField.setBounds(180,50,165,25);
        nameField.add(nameField);

        idfield = new JLabel("Patient ID");
        idfield.setBounds(10, 80, 150, 25);
        mnpanel.add(mnauthTextLabel);

        mnauthTextField = new JTextField();
        mnauthTextField.setBounds(180,80, 165,25);
        mnpanel.add(mnauthTextField);

        
        mnconbutton = new JButton("Login");
        mnconbutton.setBounds(10,110,80,25);
        mnconbutton.addActionListener(new GUI());
        mnpanel.add(mnconbutton);





    }
    */
    private void AddPatient(){
        
    }

    
    
   

 }