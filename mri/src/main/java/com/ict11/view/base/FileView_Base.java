package com.ict11.view.base;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class FileView_Base extends javax.swing.JFrame {
    public void initComponents() {
        mainFrame = new JFrame("OOPS- Group 5 - MRI image system");
        mainFrame.setSize(500, 300);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                mainFrame_windowClosing(windowEvent);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusPanel = new JPanel();

        controlPanel = new JPanel();
        //backpanel = new JPanel();
        //backpanel.setLayout(new GridLayout(1,4));

        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);  
        mainFrame.add(statusPanel);
        mainFrame.setLocationRelativeTo(null);
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                nextButton_actionPerformed(e);
            }
        });
        statusPanel.add(nextButton);
        statusPanel.setVisible(false);
        //
        jbar = new JMenuBar();
        jmenu = new JMenu("Options");
        jmi = new JMenuItem("Back");
        jmi.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae) 
            {
                jmi_actionPerformed(ae);
            }
        });
        jexit = new JMenuItem("Exit");
        jexit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jexit_actionPerformed(ae);
            }
        });
        jmenu.add(jmi);
        jmenu.add(jexit);
        jbar.add(jmenu);
        //\\
        mainFrame.setJMenuBar(jbar);
        mainFrame.setVisible(true);
    }

    protected abstract void mainFrame_windowClosing(WindowEvent windowEvent);
    protected abstract void nextButton_actionPerformed(ActionEvent e);
    protected abstract void jmi_actionPerformed(ActionEvent ae);
    protected abstract void jexit_actionPerformed(ActionEvent ae);

    protected JFrame mainFrame;
    protected JLabel headerLabel;
    protected JPanel statusPanel;
    protected JPanel controlPanel;
    protected JMenu jmenu;
    protected JMenuBar jbar;
    protected JMenuItem jmi, jexit;
}
