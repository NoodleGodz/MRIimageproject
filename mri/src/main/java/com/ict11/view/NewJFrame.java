/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ict11.view;
import com.ict11.tools.ShrinkIcon;
import com.ict11.view.base.NewJFrame_Base;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class NewJFrame extends NewJFrame_Base {

    /**
     * Creates new form NewJFrame
     */
    private void closeframe()
    {
        this.setVisible(false);
    }

    public NewJFrame() {
        initComponents();
        //Countdown_and_next();
    }

    private void timerStart()
    {
        for (int i=0; i<=100; i++)
        {
            JBar.setValue(i);
            try {
                Thread.sleep(50) ;
            } catch (InterruptedException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Thread.sleep(100) ;
        } catch (InterruptedException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        FileView.main();  
        closeframe();
    }

    private void Countdown_and_next()
    {
        Thread t = new Thread(new Runnable() 
        {
            @Override
            public void run()
            {
                timerStart();
            }
        });
        t.start();
    }
    
    protected void JBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBarKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewJFrame Frame = new NewJFrame();
                Frame.setVisible(true);
                Frame.Countdown_and_next();
            }
        });
    }
    
    public static void start()
    {
        NewJFrame Frame = new NewJFrame();
        Frame.setVisible(true);
        Frame.Countdown_and_next();
    }

    
}
