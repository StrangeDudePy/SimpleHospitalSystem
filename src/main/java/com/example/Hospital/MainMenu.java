package com.example.Hospital;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MainMenu extends GUI{
   
    public static void createMainMenu(JButton option1,JButton option2,JButton option3,JButton option4, JPanel panel,JFrame fram){

        fram.setSize(1200,800);  
        fram.add(panel);
        fram.setLayout(null);

        fram.setResizable(false);
        

        option1 = new JButton("Patient Management System");
        option1.setBounds(300,300,600,50);
        option1.addActionListener(new GUI());
        fram.add(option1);

        option2 = new JButton("Option 2 ");
        option2.setBounds(300,375,600,50);
        option2.addActionListener(new GUI());
        fram.add(option2);

        option3 = new JButton("Option 3 ");
        option3.setBounds(300,450,600,50);
        option3.addActionListener(new GUI());
        fram.add(option3);

        option4 = new JButton("Option 4");
        option4.setBounds(300,450,600,50);
        option4.addActionListener(new GUI());
        fram.add(option4);

        fram.setVisible(true);


    }
}
