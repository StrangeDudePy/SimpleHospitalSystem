package com.example.Hospital;
import javax.swing.*;

import com.github.lgooddatepicker.components.DatePicker;


import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Calendar;




//Add Button Functionalaties Here
public class AddButton extends MainMenu {
    private static JFrame addmenuFrame = new JFrame() ;
    private static JPanel addmenuPanel  = new JPanel();
    


    private static void AddPatient(){

        addmenuFrame.setSize(600,400);
        addmenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addmenuFrame.add(addmenuPanel);
        addmenuPanel.setLayout(null);

        JLabel nameLabel = new JLabel("Patient ID ");
        nameLabel.setBounds(250,25,100,50);
        addmenuPanel.add(nameLabel);

        

        JTextField namTextField = new JTextField();
        namTextField.setBounds(150,65,300,25);
        addmenuPanel.add(namTextField);

        JLabel datLabel = new JLabel("Appointment Date");
        datLabel.setBounds(225,105,200, 50);
        addmenuPanel.add(datLabel);

        DatePicker myDatePicker= new DatePicker();

        JButton selectDateButton = new JButton();
        selectDateButton.setBounds(225,205,100,30);
        addmenuPanel.add(selectDateButton);
        selectDateButton.addActionListener(e -> {
            LocalDate myDate = myDatePicker.getDate();
            String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
            
            System.out.println(myFormattedDate);
        
        });

        myDatePicker.setBounds(225, 145,200,30);
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
