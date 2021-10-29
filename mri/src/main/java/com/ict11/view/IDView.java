package com.ict11.view;
import com.ict11.control.FindFile;
import com.ict11.view.base.IDView_Base;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowEvent;
import java.awt.Font;

import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
 
public class IDView extends IDView_Base{
 
    public IDView(){
        initComponents();
    }
 
    public static void main() {
        IDView demo = new IDView();
        demo.showActionListenerDemo();
    }

    public static void main2(String arg[]) {
        IDView demo = new IDView();
        demo.showActionListenerDemo();
    }

    private void showActionListenerDemo() {
        headerLabel.setText("Enter your Patient's ID here");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        final JPanel panel = new JPanel();
        panel.setBackground(Color.red);       
        final JTextArea userText = new JTextArea(2,20);
        
        final JButton okButton = new JButton("Find");
        okButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                //userText.setText(FindFile.dIRString());
                FindFile.SaveIDfolder(userText.getText());
                if (FindFile.FindID())
                {
                   panel.setBackground(Color.green);  
                   statusPanel.setVisible(true);
                }
                else
                {
                   panel.setBackground(Color.red);  
                   statusPanel.setVisible(false);
                   JOptionPane.showMessageDialog(mainFrame, "Invalid ID - Can't Find Folder", "Warning", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(okButton);
        userText.setColumns(20);
        userText.setSize(20,2);
        controlPanel.add(userText);
        controlPanel.add(panel);
        Action releasedAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                okButton.doClick();
            }
        };
        userText.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        userText.getActionMap().put("pressed",releasedAction);
        mainFrame.setVisible(true);
    }

    protected void jmi_actionPerformed(ActionEvent ae)
    {
        FileView.main();
        mainFrame.setVisible(false);
        mainFrame.dispose();
    }

    protected void jexit_actionPerformed(ActionEvent ae)
    {
        System.exit(0);
    }

    protected void mainFrame_windowClosing(WindowEvent windowEvent)
    {
        System.exit(0);
    }

    protected void nextButton_actionPerformed(ActionEvent e)
    {
        mainFrame.setVisible(false);
        mainFrame.dispose();
        benhnhanview.start();
    }
}