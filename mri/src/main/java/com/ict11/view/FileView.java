package com.ict11.view;

import com.ict11.control.FindFile;
import com.ict11.view.base.FileView_Base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
 
import javax.swing.JButton;
import javax.swing.JFileChooser;
//import javax.swing.JOptionPane;
import javax.swing.JTextArea;


 
public class FileView extends FileView_Base {
    //private JPanel backpanel;
    final JFileChooser fileDialog = new JFileChooser();
    final JTextArea commentTextArea = new JTextArea("", 2, 25);
 
    public FileView() {
        initComponents();
    }
 
    public static void main() {
        FileView demo = new FileView();
        demo.showFileChooserDemo();
    }
    
    private void showFileChooserDemo() {
        headerLabel.setText("Select the data folder");
        fileDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        JButton showFileDialogButton = new JButton("Open Folder");
        
        showFileDialogButton.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                showFileDialogButton_actionPerformed(e);
            }
        });
        controlPanel.add(commentTextArea);
        controlPanel.add(showFileDialogButton);
        mainFrame.setVisible(true);
    }

    private void showFileDialogButton_actionPerformed(ActionEvent e)
    {
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

    protected void mainFrame_windowClosing(WindowEvent windowEvent)
    {
        System.exit(0);
    }

    protected void nextButton_actionPerformed(ActionEvent e)
    {
        mainFrame.setVisible(false);
        mainFrame.dispose();
        IDView.main();
    }

    protected void jmi_actionPerformed(ActionEvent ae)
    {
        NewJFrame.start();
        mainFrame.setVisible(false);
        mainFrame.dispose();
    }

    protected void jexit_actionPerformed(ActionEvent ae)
    {
        System.exit(0);
    }
}