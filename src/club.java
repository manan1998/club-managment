// how to use update and search about the data ALSO reset isn't working*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manan
 */
import java.awt.event.*;
import java.sql.*;
public class club extends javax.swing.JFrame implements ActionListener{
    SQLDEMO sobj;
    long id=-1;
    PreparedStatement pst;
    ResultSet rst;
    /**
     * Creates new form club
     */
    public club() {
        initComponents();
        sobj=new SQLDEMO();
        SaveButton.addActionListener(this);
        ResetButton.addActionListener(this);
        UpdateButton.addActionListener(this);
        SearchButton.addActionListener(this);
    }
    @Override
        public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==SaveButton){
    if(NameTField.getText().equals(""))
        ErrorLabel.setText("Clubname cannot be left blank");
    if(DateTField.getText().equals(""))
        ErrorLabel.setText("Date of Registration cannot be left blank");
    if(TypeTField.getText().equals(""))
        ErrorLabel.setText("Type of club cannot be left blank");
    if(TeacherInchTField.getText().equals(""))
        ErrorLabel.setText("Teacher Incharge cannot be left blank");    
    if(StudentInchTField.getText().equals(""))
        ErrorLabel.setText("Student Incharge cannot be left blank");
    if(EmailTField.getText().equals(""))
        ErrorLabel.setText("Club Email cannot be left blank");
    if(PhonenoTField.getText().equals(""))
        ErrorLabel.setText("Contact number cannot be left blank");
    if(RfeeTField.getText().equals(""))
        ErrorLabel.setText("Club Fee cannot be left blank");
    else{
        sobj.Connect();
        try{
            pst=sobj.con.prepareCall("{call prcInsertClub(?,?,?,?,?,?,?,?,?,?)}");
            pst.setString(1,NameTField.getText());
            pst.setString(2,DateTField.getText());
            pst.setString(3,TypeTField.getText());
            pst.setString(4,TeacherInchTField.getText());
            pst.setString(5,StudentInchTField.getText());
            pst.setString(6,EmailTField.getText());
            pst.setString(7,FlinkTField.getText());
            pst.setString(8,WeblinkTField.getText());
            pst.setLong(9,Long.parseLong(PhonenoTField.getText()));
            pst.setInt(10,Integer.parseInt(RfeeTField.getText()));
                   
            if(pst.execute()== false){
                ErrorLabel.setText("The club has been successfully created");
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
    }
    if(ae.getSource()==ResetButton){
    NameTField.setText("");
    DateTField.setText("");
    TypeTField.setText("");
    TeacherInchTField.setText("");
    StudentInchTField.setText("");
    EmailTField.setText("");
    FlinkTField.setText("");
    WeblinkTField.setText("");
    PhonenoTField.setText("");
    RfeeTField.setText("");
    StatusTField.setText("");
    }
    if(ae.getSource()==UpdateButton){
    if(id<0)
        ErrorLabel.setText("To update the information perform a search firstly");
    else{
    if(NameTField.getText().equals(""))
        ErrorLabel.setText("Clubname cannot be left blank");
    if(DateTField.getText().equals(""))
        ErrorLabel.setText("Date of Registration cannot be left blank");
    if(TypeTField.getText().equals(""))
        ErrorLabel.setText("Type of club cannot be left blank");
    if(TeacherInchTField.getText().equals(""))
        ErrorLabel.setText("Teacher Incharge cannot be left blank");    
    if(StudentInchTField.getText().equals(""))
        ErrorLabel.setText("Student Incharge cannot be left blank");
    if(EmailTField.getText().equals(""))
        ErrorLabel.setText("Club Email cannot be left blank");
    if(PhonenoTField.getText().equals(""))
        ErrorLabel.setText("Contact number cannot be left blank");
    if(RfeeTField.getText().equals(""))
        ErrorLabel.setText("Club Fee cannot be left blank");
    else{
        sobj.Connect();
        try{
            pst=sobj.con.prepareCall("{call prcInsertClub(?,?,?,?,?,?,?,?,?,?)}");
            pst.setString(1,NameTField.getText());
            pst.setString(2,DateTField.getText());
            pst.setString(3,TypeTField.getText());
            pst.setString(4,TeacherInchTField.getText());
            pst.setString(5,StudentInchTField.getText());
            pst.setString(6,EmailTField.getText());
            pst.setString(7,FlinkTField.getText());
            pst.setString(8,WeblinkTField.getText());
            pst.setLong(9,Long.parseLong(PhonenoTField.getText()));
            pst.setInt(10,Integer.parseInt(RfeeTField.getText()));
                   
            if(pst.execute()== false){
                ErrorLabel.setText("The club information has been successfully updated");
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
    }}//for update
    if(ae.getSource()==SearchButton){
    sobj.Connect();
        id=-1;
        try{
            if(NameTField.getText()=="")
                ErrorLabel.setText("Please enter the name of the club to search records");
            else{
            pst=sobj.con.prepareStatement("Select * from tbClub where Name=?");
            pst.setString(1,NameTField.getText());
            rst=pst.executeQuery();
            if(rst.next()){
                id=rst.getLong(1);
                DateTField.setText(rst.getString(3));
                TypeTField.setText(rst.getString(4));
                TeacherInchTField.setText(rst.getString(5));
                StudentInchTField.setText(rst.getString(6));
                EmailTField.setText(rst.getString(7));
                FlinkTField.setText(rst.getString(8));
                WeblinkTField.setText(rst.getString(9));
                PhonenoTField.setText(Long.toString(rst.getLong(10)));
                RfeeTField.setText(Integer.toString(rst.getInt(11)));
                StatusTField.setText(rst.getString(12));
                
            }
            rst.close();
        }}
       catch(Exception ex){
            ErrorLabel.setText("Error"+ex);
       }}//for search
        
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
        NameLabel = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        TypeLabel = new javax.swing.JLabel();
        TeacherInchLabel = new javax.swing.JLabel();
        StudentInchLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        FlinkLabel = new javax.swing.JLabel();
        WeblinkLabel = new javax.swing.JLabel();
        PhonenoLabel = new javax.swing.JLabel();
        RfeeLabel = new javax.swing.JLabel();
        StatusLabel = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        NameTField = new javax.swing.JTextField();
        DateTField = new javax.swing.JTextField();
        TypeTField = new javax.swing.JTextField();
        TeacherInchTField = new javax.swing.JTextField();
        StudentInchTField = new javax.swing.JTextField();
        EmailTField = new javax.swing.JTextField();
        FlinkTField = new javax.swing.JTextField();
        WeblinkTField = new javax.swing.JTextField();
        PhonenoTField = new javax.swing.JTextField();
        RfeeTField = new javax.swing.JTextField();
        StatusTField = new javax.swing.JTextField();
        ErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HeadLabel.setText("Club Registration Form");

        NameLabel.setText("Name of Club or Society");

        DateLabel.setText("Date of Registration");

        TypeLabel.setText("Type of Club or Society");

        TeacherInchLabel.setText("Teacher Incharge");

        StudentInchLabel.setText("Student Incharge");

        EmailLabel.setText("E-mail");

        FlinkLabel.setText("Facebook Link");

        WeblinkLabel.setText("Web Link");

        PhonenoLabel.setText("Contact Number");

        RfeeLabel.setText("Registeration Fee");

        StatusLabel.setText("Status");

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        ResetButton.setText("Reset");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        UpdateButton.setText("Update");

        SearchButton.setText("Search");

        DateTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateTFieldActionPerformed(evt);
            }
        });

        WeblinkTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WeblinkTFieldActionPerformed(evt);
            }
        });

        StatusTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusTFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(HeadLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(SaveButton)
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(UpdateButton)
                                .addGap(50, 50, 50)
                                .addComponent(SearchButton)
                                .addGap(39, 39, 39)
                                .addComponent(ResetButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(StatusTField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(RfeeTField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PhonenoTField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(WeblinkTField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(FlinkTField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(EmailTField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(StudentInchTField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TeacherInchTField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TypeTField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(DateTField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NameTField, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(StudentInchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TeacherInchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EmailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(FlinkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(WeblinkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PhonenoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(RfeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(StatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(650, 981, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(HeadLabel)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TypeLabel)
                    .addComponent(TypeTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TeacherInchLabel)
                    .addComponent(TeacherInchTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentInchLabel)
                    .addComponent(StudentInchTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailLabel)
                    .addComponent(EmailTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FlinkLabel)
                    .addComponent(FlinkTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WeblinkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WeblinkTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhonenoLabel)
                    .addComponent(PhonenoTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RfeeLabel)
                    .addComponent(RfeeTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatusLabel)
                    .addComponent(StatusTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(UpdateButton)
                    .addComponent(SearchButton)
                    .addComponent(ResetButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void DateTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateTFieldActionPerformed

    private void StatusTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StatusTFieldActionPerformed

    private void WeblinkTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WeblinkTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WeblinkTFieldActionPerformed

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
            java.util.logging.Logger.getLogger(club.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(club.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(club.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(club.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new club().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateLabel;
    private javax.swing.JTextField DateTField;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField EmailTField;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JLabel FlinkLabel;
    private javax.swing.JTextField FlinkTField;
    private javax.swing.JLabel HeadLabel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NameTField;
    private javax.swing.JLabel PhonenoLabel;
    private javax.swing.JTextField PhonenoTField;
    private javax.swing.JButton ResetButton;
    private javax.swing.JLabel RfeeLabel;
    private javax.swing.JTextField RfeeTField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JTextField StatusTField;
    private javax.swing.JLabel StudentInchLabel;
    private javax.swing.JTextField StudentInchTField;
    private javax.swing.JLabel TeacherInchLabel;
    private javax.swing.JTextField TeacherInchTField;
    private javax.swing.JLabel TypeLabel;
    private javax.swing.JTextField TypeTField;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel WeblinkLabel;
    private javax.swing.JTextField WeblinkTField;
    // End of variables declaration//GEN-END:variables
}
