/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manan
 */
    import java.sql.*;
    import java.awt.event.*;
public class AddUser extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form AddUser
     */
    SQLDEMO sobj;
    PreparedStatement pst;

                   
    public AddUser() {
        initComponents();
        sobj=new SQLDEMO();
        CreateButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
    String pass1 = new String(PwdTField.getPassword());
    String pass2 = new String(CPwdTField.getPassword());
    if(UserTField.getText().equals(""))
        ErrorLabel.setText("Username cannot be blank");
    if(pass1.equals(""))
        ErrorLabel.setText("Password cannot be blank");
    if(pass1.equals(pass2)){
        sobj.Connect();
        try{
            pst=sobj.con.prepareCall("{call prcInsertUser(?,?)}");
            pst.setString(1,UserTField.getText());             
            pst.setString(2,pass1);
            if(pst.execute()== false){
                ErrorLabel.setText("User has been successfully created");
            }
            else{
                ErrorLabel.setText("Error occured");
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
        PwdLabel = new javax.swing.JLabel();
        CPwdLabel = new javax.swing.JLabel();
        UserTField = new javax.swing.JTextField();
        CreateButton = new javax.swing.JButton();
        PwdTField = new javax.swing.JPasswordField();
        CPwdTField = new javax.swing.JPasswordField();
        ErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HeadLabel.setText("Add User Form");

        UserLabel.setText("Username");

        PwdLabel.setText("Password");

        CPwdLabel.setText("Confirm Password");

        UserTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserTFieldActionPerformed(evt);
            }
        });

        CreateButton.setText("Create User");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        CPwdTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPwdTFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UserLabel)
                            .addComponent(PwdLabel)
                            .addComponent(CPwdLabel))
                        .addGap(155, 155, 155)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(PwdTField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UserTField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(CPwdTField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CreateButton)
                            .addComponent(HeadLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(978, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(HeadLabel)
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserLabel)
                    .addComponent(UserTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PwdLabel)
                    .addComponent(PwdTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CPwdLabel)
                    .addComponent(CPwdTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109)
                .addComponent(CreateButton)
                .addGap(27, 27, 27)
                .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(385, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserTFieldActionPerformed

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateButtonActionPerformed

    private void CPwdTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPwdTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPwdTFieldActionPerformed

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
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CPwdLabel;
    private javax.swing.JPasswordField CPwdTField;
    private javax.swing.JButton CreateButton;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JLabel HeadLabel;
    private javax.swing.JLabel PwdLabel;
    private javax.swing.JPasswordField PwdTField;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JTextField UserTField;
    // End of variables declaration//GEN-END:variables
}
