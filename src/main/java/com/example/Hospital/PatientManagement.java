
package com.example.Hospital;
import java.text.SimpleDateFormat;
import javax.swing.*;

import java.sql.*;



public class PatientManagement  {
    JFrame pamanagementFrame = new JFrame();
    JTable pmanagemenTable = new JTable();
    private JFrame o1Frame = new JFrame();
    private JTable o1JTable= new JTable() ;
    protected static String PURL="jdbc:sqlite:Databases/Patients.db";
    private static String NoQuerry = "SELECT PatientNo FROM PatientsInfo";
    private static String IDQuerry = "SELECT ID FROM PatientsInfo";
    private static String PatientNameQuerry = "SELECT PatientName FROM PatientsInfo";
    private static String DateQuerry = "SELECT AppointDate FROM PatientsInfo";
    private static String TimeQuerry = "SELECT AppointTime FROM PatientsInfo";
    private static String TelNoQuerry = "SELECT TelNo FROM PatientsInfo";
    private static int patientsNOs[]= new int[100];
    private static String patientsID[] = new String[100];
    private static Date appointDate[] = new Date[100];
    private static String patientNames[] = new String[100];
    private static String appointTime[] = new String[100];
    private static String telNo[] = new String[100];
    private static JFrame deleteFrame = new JFrame();
    private static JFrame conFrame = new JFrame();



    protected int[] getpatintNo() {
        try {
            int NoIndex = 0;
    
            
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
                        java.sql.Date D =rNo.getDate("AppointDate");
                        appointDate[DateIndex] = D;
                        DateIndex++;
                    }
                }
            }
        }

    } catch (SQLException e ) {
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



protected String[] getpatinttelNo() {
        try {
            int telNoIndex = 0;
    
            // Create a connection
            try (Connection connectionOBJ = DriverManager.getConnection(PURL)) {
    
                try (PreparedStatement NoStatement = connectionOBJ.prepareStatement(TelNoQuerry)) {
    
                    try (ResultSet rNo = NoStatement.executeQuery()) {
    
                        while (rNo.next()) {

                        
                            telNo[telNoIndex] = rNo.getString("TelNo");
                            telNoIndex++;
                          
                        }
                    }
                }
            }
    
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        
        

        System.out.println(telNo[0]);
        return telNo;
    }



    public void CreateTheO1(MainMenu obj){
        obj.CreateOption1Page(o1Frame, o1JTable);
    }
     
   
   


    private void DeletePatient() {
        deleteFrame.setSize(600, 400);
        
        

        deleteFrame.setLayout(null);
        deleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
   
        JLabel idfLabel = new JLabel("Patient ID");
        idfLabel.setBounds(250,25,100, 25);
        deleteFrame.add(idfLabel);
    
        JTextField idfTextField = new JTextField();
        idfTextField.setBounds(150, 50, 300, 25);
        deleteFrame.add(idfTextField);

        JButton deleteButton = new JButton("Confirm");
        deleteButton.setBounds(225,100,125,25);
        deleteFrame.add(deleteButton);
        deleteButton.addActionListener(e -> {
            conFrame.dispose();
            String idtodelete = idfTextField.getText();
            conFrame.setLayout(null);
            conFrame.setSize(500,200);

            deleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JLabel confirmLabel = new JLabel("Enter 'CONFIRM' to the box to confirm your action");
            confirmLabel.setBounds(75, 25, 370, 25);
            conFrame.add(confirmLabel);

            JTextField conTextField = new JTextField();
            conTextField.setBounds(150,50 ,200,25);
            conFrame.add(conTextField);


            JButton con2Button = new JButton("OK");
            con2Button.setBounds(200,100,75, 25);
            conFrame.add(con2Button);
            con2Button.addActionListener(a -> {
                if(conTextField.getText().equals("CONFIRM")){
                    String columnValueToDelete = idtodelete;
            
                    try (Connection connection = DriverManager.getConnection(PURL)) {
                        String sql = "DELETE FROM PatientsInfo WHERE ID = ?";
                        
                        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                            preparedStatement.setString(1, columnValueToDelete);
                            preparedStatement.executeUpdate();
                            JFrame alerfFrame = new JFrame();
                            JOptionPane.showMessageDialog(conFrame,"USER DELETED SUCCESSFULLY,RESTART THE PROGRAM TO SEE THE CHANGES","USERINFO",JOptionPane.INFORMATION_MESSAGE);
                            conFrame.dispose();
                            deleteFrame.dispose();
                         
                        }
                    } catch (SQLException b) {
                        JFrame alerfFrame = new JFrame();
                        JOptionPane.showMessageDialog(conFrame,"ERROR","SYSTEM ERROR",JOptionPane.WARNING_MESSAGE);
                    }

                }

                else{
                    JFrame alerfFrame = new JFrame();
                    JOptionPane.showMessageDialog(conFrame,"Wrong Input","title",JOptionPane.WARNING_MESSAGE);
                }
            });

            conFrame.setVisible(true);
            conFrame.setResizable(false);

            



            
        });
    

     

        deleteFrame.setVisible(true);
        deleteFrame.setResizable(false);
    }


    public void getDeletePatientMethod(){
        DeletePatient();
    }
    


    
    
   

 }