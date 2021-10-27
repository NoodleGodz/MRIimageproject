/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ict11.view;
import com.ict11.tools.ShrinkIcon;
import com.ict11.view.base.benhnhanview_Base;
import com.opencsv.exceptions.CsvValidationException;

import java.awt.Color;
import java.io.File;
import java.awt.Desktop;
import java.io.IOException;

import com.ict11.control.*;
/**
 *
 * @author Asus
 */
public class benhnhanview extends benhnhanview_Base {
  
    /**
     * C:\\Users\\Asus\\Desktop\\YABE\\dataset\\48452984\\1.jpg
     * Creates new form benhnhanview
     */
    public benhnhanview() 
    {
        initComponents();
        
        try {
            loaddata();
        } catch (CsvValidationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        updateinfo();
        loadimage(numberdisplay);
        
    }

    public patient patientFrame = new patient();
    public MRIimagelist imagearray = new MRIimagelist();
    public int numberdisplay=1;

    public void loaddata() throws CsvValidationException, IOException
    {
        try {
            patientFrame.readfile(FindFile.Patcsv());
            imagearray.readfile(FindFile.Procsv());
        } catch (Exception e) {
            JFK.executed();
            dispose();
        }
    }

    public void updateinfo()
    {
        jTextPane7.setText(patientFrame.ID);
        jTextPane6.setText(patientFrame.name);
        jTextPane5.setText(patientFrame.date_of_birth);
        jTextPane4.setText(Integer.toString(patientFrame.age));
        jTextPane8.setText(patientFrame.gender);
        jTextPane1.setText(patientFrame.address);
        jTextPane2.setText(patientFrame.bodypart);
        jTextPane3.setText(patientFrame.description);
    }

    public void loadimage(int x)
    {
        try {
            jLabel8.setIcon(imagearray.imagelist.get(x));
            jTextField5.setText(Integer.toString(x));
            jCheckBox1.setSelected(imagearray.Problem[x]);
            colorcue(x);
        } catch (Exception e) {
            JFK.executed();
            dispose();
        }
    }

    public void colorcue(int x) 
    {
        if (imagearray.Problem[x])
        {
            jCheckBox1.setBackground(Color.red);
        }
        else
        {
            jCheckBox1.setBackground(Color.green);    
        }   
    }

    public void openmethod()
    {
        File file = new File (FindFile.Patdir());
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
        }
    }

    public void returnmethod() 
    {
        IDView.main();
        this.setVisible(false);
        dispose();

    }

    public void editmethod()
    {
        jTextPane7.setEditable(true);
        jTextPane6.setEditable(true);
        jTextPane5.setEditable(true);
        jTextPane4.setEditable(true);
        jTextPane3.setEditable(true);
        jTextPane2.setEditable(true);
        jTextPane1.setEditable(true);
        jTextPane8.setEditable(true);
        jButton3.setEnabled(false);
        jButton2.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jButton7.setEnabled(true);
        jLabel11.setVisible(true);
        jLabel8.setIcon(new ShrinkIcon("resource\\hqdefault.jpg"));
        jCheckBox1.setBackground(Color.pink);
        jLabel10.setForeground(Color.MAGENTA);
        jLabel10.setText("Edit mode");
    }

    public void savemethod()
    {
        patientFrame.ID = jTextPane7.getText();
        patientFrame.name= jTextPane6.getText();    
        patientFrame.date_of_birth = jTextPane5.getText();  
        patientFrame.age = Integer.parseInt(jTextPane4.getText());  
        patientFrame.gender = jTextPane8.getText();
        patientFrame.address = jTextPane1.getText();
        patientFrame.bodypart = jTextPane2.getText();
        patientFrame.description = jTextPane3.getText();  
        patientFrame.writefile(FindFile.Patcsv());
        jTextPane7.setEditable(false);
        jTextPane6.setEditable(false);
        jTextPane5.setEditable(false);
        jTextPane4.setEditable(false);
        jTextPane3.setEditable(false);
        jTextPane2.setEditable(false);
        jTextPane1.setEditable(false);
        jTextPane8.setEditable(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jButton7.setEnabled(false);
        jLabel11.setVisible(false);
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Infomation");
        updateinfo();
        loadimage(numberdisplay);
    }

    /**
     * @param args the command line arguments
     */
    public static void start()
    {
        benhnhanview Frame = new benhnhanview();
        Frame.setVisible(true);
    }
    
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
            java.util.logging.Logger.getLogger(benhnhanview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(benhnhanview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(benhnhanview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(benhnhanview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new benhnhanview().setVisible(true);
            }
        });
    } 
    
    protected void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        editmethod();
    }//GEN-LAST:event_EditActionPerformed

    protected void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        returnmethod();
    }//GEN-LAST:event_jButton4ActionPerformed

    protected void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        openmethod();
    }//GEN-LAST:event_jButton5ActionPerformed

    protected void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        editmethod();
    }//GEN-LAST:event_jButton6ActionPerformed

    protected void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    protected void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        
        if (evt.getStateChange()==1)
        {imagearray.Problem[numberdisplay]=true;}
        else
        {imagearray.Problem[numberdisplay]=false;}   
        colorcue(numberdisplay);
        imagearray.writefile(FindFile.Procsv());
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    protected void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (imagearray.NumberofImages>numberdisplay)
        {
            numberdisplay++;
            loadimage(numberdisplay);

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    protected void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (1<numberdisplay)
        {
            numberdisplay--;
            loadimage(numberdisplay);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    protected void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    protected void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        savemethod();
    }//GEN-LAST:event_jButton7ActionPerformed

    protected void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        returnmethod();
    }//GEN-LAST:event_BackActionPerformed

    protected void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    protected void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed
}
