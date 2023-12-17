package com.example.Hospital;

import javax.swing.*;

import java.awt.Image;

public class MainMenu extends GUI {
    protected static void createMainMenu(JButton option1, JButton option2, JButton option3, JButton option4, JPanel panel, JFrame frame) {

        frame.setSize(1200, 800);
        frame.add(panel);
        frame.setLayout(null);
        frame.setResizable(false);

        PatientManagement mngObj = new PatientManagement();
        ImageIcon imageIcon = new ImageIcon("/home/sefa/Downloads/HospitalAdminPanel.png");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon newImageIcon = new ImageIcon(newImage);

        // Resim etiketini oluştur ve konumunu ayarla
        JLabel imageLabel = new JLabel(newImageIcon);
        imageLabel.setBounds(400, 100, 400, 300);
        frame.add(imageLabel);

        option1 = new JButton("Patient Management System");
        option1.setBounds(300, 450, 600, 50);
        option1.addActionListener(e -> {System.out.println("Poo");
        mngObj.getpatintNo();
        mngObj.getpatintID();
        mngObj.getpatintName();
        mngObj.getpatintDate();
    });
        frame.add(option1);
    

        option2 = new JButton("Option 2 ");
        option2.setBounds(300, 525, 600, 50);
        option2.addActionListener(new GUI());
        frame.add(option2);

        option3 = new JButton("Option 3 ");
        option3.setBounds(300, 600, 600, 50);
        option3.addActionListener(new GUI());
        frame.add(option3);

        option4 = new JButton("Option 4");
        option4.setBounds(300, 675, 600, 50);
        option4.addActionListener(new GUI());
        frame.add(option4);


        frame.setVisible(true);

     
    
    
        
}
}



