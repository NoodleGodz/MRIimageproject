package com.ict11.view;

import com.ict11.control.FindFile;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
 
public class FileView {
 
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JPanel statusPanel;
    private JPanel controlPanel;
    private JMenu jmenu;
    private JMenuBar jbar;
    private JMenuItem jmi, jexit;
    //private JPanel backpanel;
 
    public FileView() {
        prepareGUI();
    }
 
    public static void main() {
        FileView demo = new FileView();
        demo.showFileChooserDemo();
    }
 
    private void prepareGUI() {

        mainFrame = new JFrame("OOPS- Group 5 - MRI image system");
        mainFrame.setSize(500, 300);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
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
            mainFrame.setVisible(false);
            mainFrame.dispose();
            IDView.main();
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
                NewJFrame.start();
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
        mainFrame.setVisible(true);
    }
 
    private void showFileChooserDemo() {
        headerLabel.setText("Select the data folder");
        final JFileChooser fileDialog = new JFileChooser();
        fileDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        final JTextArea commentTextArea = new JTextArea("", 2, 25);

        JButton showFileDialogButton = new JButton("Open Folder");
        
        showFileDialogButton.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileDialog.showOpenDialog(mainFrame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    java.io.File file = fileDialog.getSelectedFile();
                    commentTextArea.setEditable(false);
                    commentTextArea.setText(""+file.getAbsolutePath());
                    /** 
                    if (file.getName().equals("Benh Nhan"))
                    {
                    statusPanel.setVisible(true);
                    }
                    else
                    {
                        statusPanel.setVisible(false);
                        JOptionPane.showMessageDialog(mainFrame, "Invalid Folder - Must be /Benh Nhan", "Warning", JOptionPane.ERROR_MESSAGE);
                        
                    }
                    */
                    FindFile.SaveDir(file);
                    statusPanel.setVisible(true);
                    
                } else {
                    commentTextArea.setText("Open command cancelled by user.");
                    statusPanel.setVisible(false);
                }
            }
        });
        controlPanel.add(commentTextArea);
        controlPanel.add(showFileDialogButton);
        mainFrame.setVisible(true);
    }
}