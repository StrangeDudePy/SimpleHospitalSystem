package com.example.Hospital;
import javax.swing.*;
//Add Button Functionalaties Here
public class AddButton extends MainMenu {
    private static JFrame addmenuFrame = new JFrame() ;
    private static JPanel addmenuPanel  = new JPanel();


    private static void AddPatient(){

        addmenuFrame.setSize(600,400);
        addmenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addmenuFrame.add(addmenuPanel);
        addmenuPanel.setLayout(null);

        JLabel nameLabel = new JLabel("Patient Name");
        nameLabel.setBounds(250,25,100,50);
        addmenuPanel.add(nameLabel);

        JTextField namTextField = new JTextField();
        namTextField.setBounds(150,65,300,25);
        addmenuPanel.add(namTextField);



        addmenuFrame.setVisible(true);
        addmenuFrame.setResizable(false);

    }

    public void getAddPatientMethod(){
        AddPatient();
    }

}
