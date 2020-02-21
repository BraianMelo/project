package gui;

import csv.Files;
import db.DB;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import model.Dao.impl.TaskDaoJDBC;
import model.entities.Task;

public class MenuView extends javax.swing.JFrame {

    /**
     * Creates new form MenuView
     */
    public MenuView() {
        initComponents();
    }
    
    public MenuView(Integer id) throws Exception {
        Files files = new Files();
        loginView.peopleLogged.setId(id);
        initComponents();
        List<Task> list = new TaskDaoJDBC(DB.getConnection()).findAll();
        List<JPanel> panels = new ArrayList<>();
        int count = 0;
        Date today = new Date();
        for(Task task:list){
            if(today.after(task.getDeadline())){
                 new TaskDaoJDBC(DB.getConnection()).deleteByTittle(task.getTitle());
                 files.deleteFile(task.getTitle());
                 continue;
            }
            panels.add(new panelTask().getPanel(task.getTitle(), task.getDeadline().toString()));
            pnlMain.add(panels.get(count));
            ++count;
        }
        pnlMain.repaint();
        pnlMain.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTask = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlMain = new javax.swing.JPanel();

        pnlTask.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlTask.setMaximumSize(new java.awt.Dimension(380, 80));
        pnlTask.setMinimumSize(new java.awt.Dimension(380, 80));
        pnlTask.setPreferredSize(new java.awt.Dimension(380, 80));
        pnlTask.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pnlTaskKeyPressed(evt);
            }
        });
        pnlTask.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("jLabel6");
        pnlTask.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 40));

        lblDate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDate.setText("jLabel7");
        pnlTask.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 340, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/blueWallPaper.jpg"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        pnlTask.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 100));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setMaximumSize(new java.awt.Dimension(400, 400));
        jPanel3.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 4, 50, 40));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/blueWallPaper.jpg"))); // NOI18N
        jLabel1.setText("X");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 396, 50));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Add task");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 351, 400, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/blueWallPaper.jpg"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 348, 396, 50));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setLayout(new java.awt.GridLayout(50, 0, 10, 20));
        jScrollPane1.setViewportView(pnlMain);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 380, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        createTaskView task = new createTaskView(this);
        task.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void pnlTaskKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlTaskKeyPressed

    }//GEN-LAST:event_pnlTaskKeyPressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblDate;
    public javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTask;
    // End of variables declaration//GEN-END:variables
}
