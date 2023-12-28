package com.example.Hospital;
import javax.swing.*;

import com.github.lgooddatepicker.components.DatePicker;


import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;





//Add Button Functionalaties Here
public class AddButton extends MainMenu {
    private static JFrame addmenuFrame = new JFrame() ;
    private static JPanel addmenuPanel  = new JPanel();
    private static java.sql.Date StoredDate[] = new Date[1];


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





        DatePicker myDatePicker= new DatePicker();
        JButton selectDateButton = new JButton();
        selectDateButton.setBounds(225,300,100,30);
        addmenuPanel.add(selectDateButton);
        selectDateButton.addActionListener(e -> {
            try{
            LocalDate myDate = myDatePicker.getDate();
            String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            java.sql.Date sqlDate = java.sql.Date.valueOf(myFormattedDate);
            StoredDate[0]= sqlDate;
            System.out.println(myFormattedDate);
            }
            catch(NullPointerException a){
                
            }
        });

        myDatePicker.setBounds(200,250,200,25);
        addmenuPanel.add(myDatePicker);


        addmenuFrame.setVisible(true);
        addmenuFrame.setResizable(false);

    }

    public void getAddPatientMethod(){
        AddPatient();
    }

 /*   private Date[] getDate(){
       Date currentDate = new Date();
       java.sql.Date curDate = new java.sql.Date(currentDate.getTime());
       java.sql.Date appointDate[] = new java.sql.Date[30];
        
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(curDate);

    }
    */ 

}
