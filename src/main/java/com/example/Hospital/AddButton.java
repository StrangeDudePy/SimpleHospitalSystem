package com.example.Hospital;
import javax.swing.*;

import com.github.lgooddatepicker.components.DatePicker;

import java.math.BigInteger;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;





//Add Button Functionalaties Here
public class AddButton extends MainMenu {
    private static ErrorPreventforAddMenu errobj = new ErrorPreventforAddMenu();
    protected static String AURL="jdbc:sqlite:Databases/Patients.db";
    private static JFrame addmenuFrame = new JFrame() ;
    private static JPanel addmenuPanel  = new JPanel();
    private static Object[] PatientData = new Object[6];
    private static RSA RSobject =new RSA();
    

    private static void AddPatient(){

        addmenuFrame.setSize(600,400);
        addmenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addmenuFrame.add(addmenuPanel);
        addmenuPanel.setLayout(null);

        JLabel idLabel = new JLabel("Patient ID ");
        idLabel.setBounds(250,10,100,50);
        addmenuPanel.add(idLabel);


        JTextField idTextField = new JTextField();
        idTextField.setBounds(150,50,300,25);
        addmenuPanel.add(idTextField);

        JLabel nameLabel = new JLabel("Name Surname");
        nameLabel.setBounds(230,60,200, 50);
        addmenuPanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150,100,300,25);
        addmenuPanel.add(nameField);

        JLabel telLabel = new JLabel("Telephone Number");
        telLabel.setBounds(220,110,300,50);
        addmenuPanel.add(telLabel);
       
        JTextField telTextField = new JTextField();
        telTextField.setBounds(150,150,300,25);
        addmenuPanel.add(telTextField);


        JLabel dateLabel = new JLabel("Appointment Date");
        dateLabel.setBounds(220,160,300,50);
        addmenuPanel.add(dateLabel);

        DatePicker myDatePicker= new DatePicker();
         myDatePicker.setBounds(200,200,200,25);
        addmenuPanel.add(myDatePicker);

        JLabel timeLabel = new JLabel("Appointment Time");
        timeLabel.setBounds(220,215,300,50);
        addmenuPanel.add(timeLabel);

        String times[] = {"09","10","11","12","13","14","15","16","17"};
        String minutes[] = new String[6];

        for (int minute = 0; minute < 60; minute=minute + 10) {
            
           if(minute % 10 == 0) {minutes[(minute/10)] = String.format("%02d", minute);
        
        }

            else{

            }
        }


        JComboBox<String> timehour = new JComboBox<>(times);
        timehour.setBounds(230,255,50,20);
        addmenuPanel.add(timehour);

        JLabel dotlabel = new JLabel(":");
        dotlabel.setBounds(283,255,30,20);
        addmenuPanel.add(dotlabel);


        JComboBox<String> timeminute = new JComboBox<>(minutes);
        timeminute.setBounds(290,255,50,20);
        addmenuPanel.add(timeminute);
        
        

        JButton selectDateButton = new JButton("Confirm");
        selectDateButton.setBounds(225,300,100,30);
        addmenuPanel.add(selectDateButton);
        selectDateButton.addActionListener(e -> {
            try{
            LocalDate myDate = myDatePicker.getDate();
            String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            java.sql.Date sqlDate = java.sql.Date.valueOf(myFormattedDate);
            System.out.println(myFormattedDate);
            PatientData[0]=idTextField.getText();
            PatientData[1]=nameField.getText();
            PatientData[2]=telTextField.getText();
            PatientData[3]=sqlDate;
            PatientData[4]=(String)timehour.getSelectedItem();
            PatientData[5]=(String) timeminute.getSelectedItem();
            errobj.getNameFormatter(PatientData);
           

            

            if(errobj.returnCheckMethod(PatientData, PatientData, PatientData,PatientData)){
                BigInteger nameInt= new BigInteger(errobj.getNameFormatter(PatientData).getBytes());
                BigInteger idInt = new BigInteger(PatientData[0].toString());
                nameInt = new BigInteger(errobj.getNameFormatter(PatientData).getBytes());
                BigInteger telInt = new BigInteger(PatientData[2].toString());
          


                
                String patientQuerry="INSERT INTO PatientsInfo (PatientNo,PatientName,AppointDate,ID,AppointTime,TelNo) VALUES(?,?,?,?,?,?)";


                try(Connection connec = DriverManager.getConnection(AURL)){

                    try(PreparedStatement inserstmt = connec.prepareStatement(patientQuerry)){
                        inserstmt.setInt(1,getLastNo()+1);
                        inserstmt.setString(2,RSobject.encrypt(nameInt).toString());
                        inserstmt.setDate(3,(java.sql.Date) PatientData[3]);
                        inserstmt.setString(4,RSobject.encrypt(idInt).toString());
                        inserstmt.setString(5,PatientData[4].toString()+":"+PatientData[5].toString());
                        inserstmt.setString(6,RSobject.encrypt(telInt).toString());


                        inserstmt.executeUpdate();
                    }
                }
                catch(SQLException b){
                    b.getMessage();
                }
                    
                
            }


          








                    
           /* for (int i =0 ; i<= 5;i++){
                System.out.println(PatientData[i]);
            }
            */ 
            
            }
            catch(NullPointerException a){
                System.out.println("Null Error");
                
            }
        });

       


        addmenuFrame.setVisible(true);
        addmenuFrame.setResizable(false);

    }

    public void getAddPatientMethod(){
        AddPatient();
       
    }

    
    private  static String  TimeFormatter(){
        String time = PatientData[4].toString();
        String minute = PatientData[5].toString();
        String timeString = time+":"+minute;
        return timeString;
    }

    public String getTimeFormatter(){
        return TimeFormatter();
    }


    private static int getLastNo(){
        int MaxNo=0;
        try(Connection conn = DriverManager.getConnection(AURL))
        {

            String noquery = "SELECT MAX (PatientNo) FROM PatientsInfo";

            try(PreparedStatement noStatement = conn.prepareStatement(noquery);
                ResultSet resultSet = noStatement.executeQuery()){
                {
                    if(resultSet.next()){
                        MaxNo = resultSet.getInt("PatientNo");
                        
                    }

                    else{
                        MaxNo=0;
                    }
                }


            }
        } catch(SQLException e){
            e.getMessage();
        }
        return MaxNo;
    }
    
}
