package com.ict11.view;


import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


 
public class LoginView {
 
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JPanel textbox;
    private JPanel LoButt;
    
    public boolean checkUser(String U,String P) 
    {
 
        if ("admin".equals(U)  && "admin".equals(P)) 
            {
            statusLabel.setText(U);
            return true;
            }
        return false;
    }    

    public LoginView(){
       prepareGUI();
    }
 
    public static void main() {
        LoginView swingDemo = new LoginView();
        swingDemo.showTextFieldDemo();
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(mainFrame, message, "Warning",JOptionPane.ERROR_MESSAGE);
    }

    private void prepareGUI() {
        mainFrame = new JFrame("OOPS- Group 5 - MRI image system");
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        textbox = new JPanel();
        LoButt = new JPanel();
        textbox.setLayout(new GridLayout(2,1));

        statusLabel.setSize(350, 100);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setLocationRelativeTo(null); 
        mainFrame.setVisible(true);
    }
 
    private void showTextFieldDemo() {
        headerLabel.setText("Please Login UwU:");
        JLabel namelabel = new JLabel("User ID:     ", JLabel.LEFT);
        JLabel passwordLabel = new JLabel("Password: ", JLabel.LEFT);
        final JTextField userText = new JTextField(10);
        final JPasswordField passwordText = new JPasswordField(10);

        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if (checkUser(userText.getText(),new String(passwordText.getPassword()))) 
                {

                    //StudentController studentController = new StudentController(studentView);
                    //studentController.showStudentView();
                    FileView.main();
                    mainFrame.setVisible(false);
                } 
                else 
                {
                    //statusLabel.setText(String.valueOf((checkUser(userText.getName(),passwordText.getName()))));
                    statusLabel.setText("admin / admin");
                    showMessage("Invalid username or password.");
                }
            }    
        });
        JPanel nameJPanel = new JPanel();
        JPanel PWJPanel = new JPanel();
        nameJPanel.add(namelabel);
        nameJPanel.add(userText);
        textbox.add(nameJPanel);
        PWJPanel.add(passwordLabel);
        PWJPanel.add(passwordText);
        textbox.add(PWJPanel);
        controlPanel.add(textbox);
        LoButt.add(loginButton);
        controlPanel.add(LoButt);
        
        mainFrame.setVisible(true);
    }
}