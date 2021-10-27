package com.ict11.view;
import com.ict11.control.FindFile;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;

import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
 
public class IDView {
    private JFrame mainFrame;
    private JLabel headerLabel;

    private JPanel controlPanel;
    private JPanel statusPanel;
    private JMenu jmenu;
    private JMenuBar jbar;
    private JMenuItem jmi, jexit;
 
    public IDView(){
       prepareGUI();
    }
 
    public static void main() {
        IDView demo = new IDView();
        demo.showActionListenerDemo();
    }

    public static void main2(String arg[]) {
        IDView demo = new IDView();
        demo.showActionListenerDemo();
    }

    private void prepareGUI() {
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
                FileView.main();
                mainFrame.setVisible(false);
                mainFrame.dispose();
            }
        });
        jexit = new JMenuItem("Exit");
        jexit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        jmenu.add(jmi);
        jmenu.add(jexit);
        jbar.add(jmenu);
        //\\
        mainFrame.setJMenuBar(jbar);
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusPanel);

        mainFrame.setTitle("ID");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
             {
            mainFrame.setVisible(false);
            mainFrame.dispose();
            benhnhanview.start();
            }
        });
        statusPanel.add(nextButton);
        statusPanel.setVisible(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
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
        userText.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),
                            "pressed");
        userText.getActionMap().put("pressed",releasedAction);
        mainFrame.setVisible(true);
    }
 
}