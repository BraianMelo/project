/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import csv.Files;
import db.DB;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Dao.impl.TaskDaoJDBC;
import model.entities.Task;

/**
 *
 * @author Braian
 */
public class panelTask {
    
    public JPanel pnlTask = new javax.swing.JPanel();
    public JLabel lblTitle = new javax.swing.JLabel();
    public JLabel lblDate = new javax.swing.JLabel();
    public JLabel jLabel5 = new javax.swing.JLabel();
    
    
    public JPanel getPanel(String tittle,String date){

    
    pnlTask.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlTask.setMaximumSize(new java.awt.Dimension(380, 80));
        pnlTask.setMinimumSize(new java.awt.Dimension(380, 80));
        pnlTask.setPreferredSize(new java.awt.Dimension(380, 80));;
        pnlTask.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText(tittle);
        pnlTask.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 40));

        lblDate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDate.setText(date);
        pnlTask.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 340, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/blueWallPaper.jpg"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        pnlTask.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 100));
        
        return pnlTask;
    }
                         
    
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {            
        String text[] =  new Files().getArchiveText(lblTitle.getText());
        String text2 = "";
        for(int c = 0;c < text.length;++c){
            text2 += text[c];
            text2 += "\n";
        }
        try{
            JOptionPane.showMessageDialog(null, text2);
        } catch (Exception ex) {
            Logger.getLogger(panelTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    
}
