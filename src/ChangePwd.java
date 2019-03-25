/*how to check that username is correct and also old password matches or not*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manan
 */import java.awt.event.*;
 import java.sql.*;
public class ChangePwd extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form ChangePwd
     */PreparedStatement pst;
        SQLDEMO sobj;
    
    public ChangePwd() {
        sobj=new SQLDEMO();
        initComponents();
        ChangePwdButton.addActionListener(this);
    }

        public void actionPerformed(ActionEvent ae){
    String pass1 = new String(OldPwdPField.getPassword());
    String pass2 = new String(NewPwdPField.getPassword());
    String pass3 = new String(CNewPwdPField.getPassword());
    if(UserTField.getText().equals(""))
        ErrorLabel.setText("Username cannot be blank");
    if(pass1.equals(""))
        ErrorLabel.setText("Old Password cannot be blank");
    if(pass2.equals(""))
        ErrorLabel.setText("New Password cannot be left blank");
    if(pass2.equals(pass3)){
        sobj.Connect();
        try{
            pst=sobj.con.prepareCall("{call prcUpdatePass(?,?,?)}");
            pst.setString(1,UserTField.getText());             
            pst.setString(2,pass2);
            pst.setString(3,pass1);
            if(pst.executeUpdate()>0){
                ErrorLabel.setText("Password changed successfully");
            }
        }
        catch(Exception ex){
            ErrorLabel.setText("Error "+ex);
                           }
        sobj.Disconnect();
    }
     else
         ErrorLabel.setText("Passwords do not match");
    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeadLabel = new javax.swing.JLabel();
        UserLabel = new javax.swing.JLabel();
        OldPwdLabel = new javax.swing.JLabel();
        NewPwdLabel = new javax.swing.JLabel();
        CNewPwdLabel = new javax.swing.JLabel();
        UserTField = new javax.swing.JTextField();
        ChangePwdButton = new javax.swing.JButton();
        OldPwdPField = new javax.swing.JPasswordField();
        NewPwdPField = new javax.swing.JPasswordField();
        CNewPwdPField = new javax.swing.JPasswordField();
        ErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HeadLabel.setText("Change Password Form");

        UserLabel.setText("Username");

        OldPwdLabel.setText("Old Password");

        NewPwdLabel.setText("New Password");

        CNewPwdLabel.setText("Confirm New Password");

        ChangePwdButton.setText("Change Password");
        ChangePwdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangePwdButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NewPwdLabel)
                                .addGap(256, 256, 256)
                                .addComponent(NewPwdPField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(CNewPwdLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CNewPwdPField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(UserLabel)
                                    .addGap(282, 282, 282)
                                    .addComponent(UserTField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(OldPwdLabel)
                                .addGap(262, 262, 262)
                                .addComponent(OldPwdPField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ChangePwdButton)
                            .addComponent(HeadLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(976, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(HeadLabel)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UserTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserLabel))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OldPwdLabel)
                    .addComponent(OldPwdPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewPwdLabel)
                    .addComponent(NewPwdPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CNewPwdLabel)
                    .addComponent(CNewPwdPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(ChangePwdButton)
                .addGap(58, 58, 58)
                .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(294, 294, 294))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChangePwdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangePwdButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChangePwdButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ChangePwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePwd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CNewPwdLabel;
    private javax.swing.JPasswordField CNewPwdPField;
    private javax.swing.JButton ChangePwdButton;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JLabel HeadLabel;
    private javax.swing.JLabel NewPwdLabel;
    private javax.swing.JPasswordField NewPwdPField;
    private javax.swing.JLabel OldPwdLabel;
    private javax.swing.JPasswordField OldPwdPField;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JTextField UserTField;
    // End of variables declaration//GEN-END:variables
}
