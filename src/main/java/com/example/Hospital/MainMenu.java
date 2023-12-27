package com.example.Hospital;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

public class MainMenu extends GUI { 
    private static StaffSystem staffSystem = new StaffSystem();
    private static JButton addButton = new JButton("Add");
    private static JButton deleteButton = new JButton("Delete");
    private static JButton editButton = new JButton("Edit");
    private static JPanel buttonPanel = new JPanel(new FlowLayout());
    static PatientManagement managementObj = new PatientManagement();
    
    
    private static String[] IDdata, NameData;
    private static int[] NumberData;
    private static Date[] DateData;
    private static String[] TimeData;
    
    static {
        IDdata = managementObj.getpatintID();
        NameData = managementObj.getpatintName();
        NumberData = managementObj.getpatintNo();
        DateData = managementObj.getpatintDate();
        TimeData = managementObj.getappointTime();
    }
    
    private static AddButton Addthing = new AddButton();
    




    protected static void createMainMenu(JButton option1, JButton option2, JButton option3, JButton option4, JPanel panel, JFrame frame) {

        frame.setSize(1200, 800);
        frame.add(panel);
        frame.setLayout(null);
        frame.setResizable(false);
        MainMenu nMainMenu = new MainMenu();
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
        mngObj.CreateTheO1(nMainMenu);
        
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




        
        

    public void CreateOption1Page(JFrame x , JTable y){
        Object[][] data = new Object[100][5];
        
        
        x = new JFrame();
        x.setResizable(false);
       
      
        x.setTitle("Patients");
 
        for(int k = 0; NameData[k]!=null;k++)
        {
            for (int j = 0 ; j <= k ; j++){
                data[k][j] = NumberData[k];
                data[k][j+1] = NameData[k];
                data[k][j+2] = IDdata[k];
                data[k][j+3] = DateData[k];
                data[k][j+4] = TimeData[k];

            }
            
        }
 
       



        String[] columnNames = { "Patient No", "Patient Name-Surname", "ID","Appointment Date" ,"Appoint Time"};
 
       
        y= new JTable(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {                
                return false;               
        }
        };
        y.setBounds(30, 40, 300, 450);
 
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(y);
        x.add(sp,BorderLayout.CENTER);

        
        addButton.addActionListener(e -> { if (staffSystem.AccessCheck(super.getid()) == 1){
            JFrame alerfFrame = new JFrame();
            Addthing.getAddPatientMethod();
            //JOptionPane.showMessageDialog(alerfFrame, "Access Denied");
            
        }
       else {
            
            Addthing.getAddPatientMethod();
        }});

        deleteButton.addActionListener(e -> { if (staffSystem.AccessCheck(super.getid()) == 1){
            JFrame deletealerfFrame = new JFrame();
            JOptionPane.showMessageDialog(deletealerfFrame, "Access Denied");
            
        }
       else {
            System.out.println("3");
        }});

        editButton.addActionListener(e -> { if (staffSystem.AccessCheck(super.getid()) == 1){
            JFrame alerfmodifyFrame = new JFrame();
            JOptionPane.showMessageDialog(alerfmodifyFrame, "Access Denied");
            
        }
       else {
            System.out.println("3");
        }});
    
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);

        x.add(buttonPanel,BorderLayout.SOUTH);

        // Frame Size
        x.setSize(800, 400);
        // Frame Visible = true
        x.setVisible(true);
    
 
    }
}



