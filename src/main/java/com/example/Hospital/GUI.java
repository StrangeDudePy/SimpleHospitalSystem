package com.example.Hospital;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class GUI implements ActionListener{
       
    private static JLabel idlabel;
    private static JTextField userid;
    private static JLabel passLabel;
    private static JPasswordField passwordt;
    private static JButton conbutton;
    private static JLabel succes;
    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        frame.add(panel);

        panel.setLayout(null);

        idlabel = new JLabel("STAFF ID");
        idlabel.setBounds(10,20,80,25);
        panel.add(idlabel);

        userid = new JTextField(20);
        userid.setBounds(100,20,165,25);
        panel.add(userid);

        passLabel = new JLabel("Password");
        passLabel.setBounds(10,50,80,25);
        panel.add(passLabel);

        passwordt = new JPasswordField();
        passwordt.setBounds(100,50,165,25);
        panel.add(passwordt);

        conbutton = new JButton("Login");
        conbutton.setBounds(10,80,80,25);
        conbutton.addActionListener(new GUI());
        panel.add(conbutton);

        succes = new JLabel("");
        succes.setBounds(10,110,300,25);
        panel.add(succes);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String user = userid.getText();
        char [] passwordchar = passwordt.getPassword();
        String password = new String(passwordchar);
        System.out.println(user + password);
    }

  
}
