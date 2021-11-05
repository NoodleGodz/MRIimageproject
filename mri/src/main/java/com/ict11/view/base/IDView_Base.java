package com.ict11.view.base;

import com.ict11.view.base.IDView_Base;

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
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public abstract class IDView_Base {
    
    public void initComponents() {
        mainFrame = new JFrame("ID benh nhan");
        mainFrame.setSize(500, 300);
        mainFrame.setLayout(new GridLayout(3, 1));
        headerLabel = new JLabel("", JLabel.CENTER);
        statusPanel = new JPanel();
        new JLabel("", JLabel.CENTER);
        headerLabel.setSize(350,300);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        
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
            public void actionPerformed(ActionEvent ae) 
            {
                jexit_actionPerformed(ae);
            }
        });
        jmenu.add(jmi);
        jmenu.add(jexit);
        jbar.add(jmenu);

        mainFrame.setJMenuBar(jbar);
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusPanel);

        mainFrame.setTitle("OOPS- Group 4 - MRI image system");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                mainFrame_windowClosing(windowEvent);
            }
        });
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                nextButton_actionPerformed(e);
            }
        });
        statusPanel.add(nextButton);
        statusPanel.setVisible(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    protected abstract void jmi_actionPerformed(ActionEvent ae);
    protected abstract void jexit_actionPerformed(ActionEvent ae);
    protected abstract void mainFrame_windowClosing(WindowEvent windowEvent);
    protected abstract void nextButton_actionPerformed(ActionEvent e);

    protected JFrame mainFrame;
    protected JLabel headerLabel;
    protected JPanel controlPanel;
    protected JPanel statusPanel;
    protected JMenu jmenu;
    protected JMenuBar jbar;
    protected JMenuItem jmi, jexit;
}
