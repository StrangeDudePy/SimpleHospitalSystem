package com.example.Hospital;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;


public class MainMenu extends GUI { 
   
    private static StaffSystem staffSystem = new StaffSystem();
    private static JButton addButton = new JButton("Add");
    private static JButton deleteButton = new JButton("Delete");

    private static JPanel buttonPanel = new JPanel(new FlowLayout());
    static PatientManagement managementObj = new PatientManagement();
    
    
    private static String[] IDdata, NameData;
    private static int[] NumberData;
    private static Date[] DateData;
    private static String[] TimeData;
    private static String[] TelNoData;
    
    static {
        IDdata = managementObj.getpatintID();
        NameData = managementObj.getpatintName();
        NumberData = managementObj.getpatintNo();
        DateData = managementObj.getpatintDate();
        TimeData = managementObj.getappointTime();
        TelNoData = managementObj.getpatinttelNo();
    }
    
    private static AddButton Addthing = new AddButton();
    




    protected static void createMainMenu(JButton option1,JPanel panel, JFrame frame) {

        frame.setSize(1200, 800);
        frame.add(panel);
        frame.setLayout(null);
        frame.setResizable(false);
        MainMenu nMainMenu = new MainMenu();
        PatientManagement mngObj = new PatientManagement();
        ImageIcon imageIcon = new ImageIcon("/home/sefa/Downloads/Medical Logo Design Template, Hospital Logo Vector - 1024x768.png");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon newImageIcon = new ImageIcon(newImage);

        // Resim etiketini oluştur ve konumunu ayarla
        JLabel imageLabel = new JLabel(newImageIcon);
        imageLabel.setBounds(400, 100, 400, 300);
        frame.add(imageLabel);

        option1 = new JButton("Patient Management System");
        option1.setBounds(300, 500, 600, 50);
        option1.addActionListener(e -> {
        mngObj.getpatintNo();
        mngObj.getpatintID();
        mngObj.getpatintName();
        mngObj.CreateTheO1(nMainMenu);
        
    });
        frame.add(option1);
    


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

     
    
    
        
}




        
        

    public void CreateOption1Page(JFrame x , JTable y){
        Object[][] data = new Object[100][6];
        
        x = new JFrame();
        x.setResizable(false);
       
      
        x.setTitle("Patients");
 
        for(int k = 0; NameData[k]!=null;k++)
        {
            for (int j = 0 ; j <= k ; j++){

          
                data[k][0] = NumberData[k];
                data[k][1] = NameData[k];
                data[k][2] = IDdata[k];
                data[k][3] = DateData[k];
                data[k][4] = TimeData[k];
                data[k][5] = TelNoData[k];

            }
            
        }
 
       



        String[] columnNames = { "Patient No", "Patient Name-Surname", "ID","Appointment Date" ,"Appoint Time","TelNo"};
 
       
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
            JOptionPane.showMessageDialog(alerfFrame, "Access Denied");
            
        }
       else {
            
            Addthing.getAddPatientMethod();
        }});

        deleteButton.addActionListener(e -> { if (staffSystem.AccessCheck(super.getid()) == 1){
            JFrame deletealerfFrame = new JFrame();
            JOptionPane.showMessageDialog(deletealerfFrame, "Access Denied");
            
        }
       else {
            Addthing.getDeletePatientMethod();
        }});

       
    
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);


        x.add(buttonPanel,BorderLayout.SOUTH);

        // Frame Size
        x.setSize(800, 400);
        // Frame Visible = true
        x.setVisible(true);
    
 
    }
}



