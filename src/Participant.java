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
public class Participant extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form Participant
     */SQLDEMO sobj;
     PreparedStatement pst;
     ResultSet rst;
     long ed[];
     int i;
     long id=-1;
    public Participant() {
        sobj = new SQLDEMO();
        ed=new long[100];
        initComponents();
        SaveButton.addActionListener(this);
        ResetButton.addActionListener(this);
        UpdateButton.addActionListener(this);
        SearchButton.addActionListener(this);
        sobj.Connect();
        try{i=1;
            pst=sobj.con.prepareCall("Select EventId,Title from tbEvent");
            rst=pst.executeQuery();
            while(rst.next()){
                ed[i]=rst.getInt(1);
                i++;
                EventidComboBox.addItem(rst.getString(2).trim());
            }rst.close();
        }
        catch(Exception ex){
                ErrorLabel.setText("Error"+ex);
                }
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==SaveButton){
           if(NameTField.getText()=="")
               ErrorLabel.setText("Name cannot be left blank");
           if(CourseTField.getText()=="")
               ErrorLabel.setText("Course of the applicant cannot be left blank");
           if(YearTField.getText()=="")
               ErrorLabel.setText("Year of the applicant cannot be left blank");
           if(RollnoTField.getText()=="")
               ErrorLabel.setText("Roll number of the applicant cannot be left blank");
           if(PhonenoTField.getText()=="")
               ErrorLabel.setText("Phone number of the applicant cannot be left blank");
           if(AddressTField.getText()=="")
               ErrorLabel.setText("Address of the applicant cannot be left blank");
           if(CityTField.getText()=="")
               ErrorLabel.setText("City of the applicant cannot be left blank");
           if(DateTField.getText()=="")
               ErrorLabel.setText("Registration date cannot be left blank");
           if(AmntPaidTField.getText()=="")
               ErrorLabel.setText("Amount Paid by the applicant cannot be left blank");
           if(BalanceTField.getText()=="")
               ErrorLabel.setText("Balance amount cannot be left blank");
           if(EventidComboBox.getSelectedItem().toString().equals(""))
               ErrorLabel.setText("Event ID cannot be left blank");
           else{
               try{
                   pst=sobj.con.prepareCall("{call prcInsertParticipation(?,?,?,?,?,?,?,?,?,?,?,?)}");
                   pst.setString(1,NameTField.getText());
                   pst.setString(2,CourseTField.getText());
                   pst.setInt(3,Integer.parseInt(YearTField.getText()));
                   pst.setLong(4,Long.parseLong(RollnoTField.getText()));
                   pst.setLong(5,Long.parseLong(PhonenoTField.getText()));
                   pst.setString(6,AddressTField.getText());
                   pst.setString(7,CityTField.getText());
                   pst.setLong(8,ed[EventidComboBox.getSelectedIndex()]);
                   pst.setString(9,DateTField.getText());
                   pst.setInt(10,Integer.parseInt(AmntPaidTField.getText()));
                   pst.setInt(11,Integer.parseInt(BalanceTField.getText()));
                   pst.setString(12,EmailTField.getText());
                   
                   if(pst.execute()== false){
                ErrorLabel.setText("The registration for participation has been successfully done");
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
            EventidComboBox.setSelectedIndex(0);
            NameTField.setText("");
            CourseTField.setText("");
            YearTField.setText("");
            RollnoTField.setText("");
            PhonenoTField.setText("");
            AddressTField.setText("");
            CityTField.setText("");
            DateTField.setText("");
            AmntPaidTField.setText("");
            BalanceTField.setText("");
            EmailTField.setText("");
        }
        if(ae.getSource()==UpdateButton){
        if(id <0)
        AmntpaidLabel.setText("Please Search the information before updating");
        else{
            if(NameTField.getText()=="")
               ErrorLabel.setText("Name cannot be left blank");
           if(CourseTField.getText()=="")
               ErrorLabel.setText("Course of the applicant cannot be left blank");
           if(YearTField.getText()=="")
               ErrorLabel.setText("Year of the applicant cannot be left blank");
           if(RollnoTField.getText()=="")
               ErrorLabel.setText("Roll number of the applicant cannot be left blank");
           if(PhonenoTField.getText()=="")
               ErrorLabel.setText("Phone number of the applicant cannot be left blank");
           if(AddressTField.getText()=="")
               ErrorLabel.setText("Address of the applicant cannot be left blank");
           if(CityTField.getText()=="")
               ErrorLabel.setText("City of the applicant cannot be left blank");
           if(DateTField.getText()=="")
               ErrorLabel.setText("Registration date cannot be left blank");
           if(AmntPaidTField.getText()=="")
               ErrorLabel.setText("Amount Paid by the applicant cannot be left blank");
           if(BalanceTField.getText()=="")
               ErrorLabel.setText("Balance amount cannot be left blank");
           if(EventidComboBox.getSelectedItem().toString().equals(""))
               ErrorLabel.setText("Event ID cannot be left blank");
           else{
               try{
                   pst=sobj.con.prepareCall("{call prcInsertParticipation(?,?,?,?,?,?,?,?,?,?,?,?)}");
                   pst.setString(1,NameTField.getText());
                   pst.setString(2,CourseTField.getText());
                   pst.setInt(3,Integer.parseInt(YearTField.getText()));
                   pst.setLong(4,Long.parseLong(RollnoTField.getText()));
                   pst.setLong(5,Long.parseLong(PhonenoTField.getText()));
                   pst.setString(6,AddressTField.getText());
                   pst.setString(7,CityTField.getText());
                   pst.setLong(8,ed[EventidComboBox.getSelectedIndex()]);
                   pst.setString(9,DateTField.getText());
                   pst.setInt(10,Integer.parseInt(AmntPaidTField.getText()));
                   pst.setInt(11,Integer.parseInt(BalanceTField.getText()));
                   pst.setString(12,EmailTField.getText());
                   
                   if(pst.execute()== false){
                ErrorLabel.setText("The updation of information for participation has been successfully done");
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
            if("".equals(NameTField.getText()))
                ErrorLabel.setText("Enter the name of the participant to perform the search");
            else{
            pst=sobj.con.prepareStatement("Select * from tbParticipation where Name=?");
            pst.setString(1,NameTField.getText());
            rst=pst.executeQuery();
            if(rst.next()){
                id=rst.getLong(1);
                EventidComboBox.setSelectedIndex(new ArraySearch().searchArray(ed,rst.getLong(9)));
                CourseTField.setText(rst.getString(3));
                YearTField.setText(Integer.toString(rst.getInt(4)));
                RollnoTField.setText(rst.getString(5));
                PhonenoTField.setText(Long.toString(rst.getLong(6)));
                AddressTField.setText(rst.getString(7));
                CityTField.setText(rst.getString(8));
                DateTField.setText(rst.getString(10));
                AmntPaidTField.setText(Integer.toString(rst.getInt(11)));
                BalanceTField.setText(Integer.toString(rst.getInt(12)));
                EmailTField.setText(rst.getString(13));
                
            }
            rst.close();
        }}
       catch(Exception ex){
            AmntpaidLabel.setText("Error"+ex);
       }
        }//for search
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
        CourseLabel = new javax.swing.JLabel();
        YearLabel = new javax.swing.JLabel();
        RollnoLabel = new javax.swing.JLabel();
        PhonenoLabel = new javax.swing.JLabel();
        AddressLabel = new javax.swing.JLabel();
        CityLabel = new javax.swing.JLabel();
        EventidLabel = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        AmntpaidLabel = new javax.swing.JLabel();
        BalanceLabel = new javax.swing.JLabel();
        NameTField = new javax.swing.JTextField();
        CourseTField = new javax.swing.JTextField();
        YearTField = new javax.swing.JTextField();
        RollnoTField = new javax.swing.JTextField();
        PhonenoTField = new javax.swing.JTextField();
        AddressTField = new javax.swing.JTextField();
        CityTField = new javax.swing.JTextField();
        DateTField = new javax.swing.JTextField();
        AmntPaidTField = new javax.swing.JTextField();
        BalanceTField = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        EventidComboBox = new javax.swing.JComboBox<>();
        UpdateButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        ErrorLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        EmailTField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HeadLabel.setText("Participant Registration Form");

        NameLabel.setText("Name");

        CourseLabel.setText("Course");

        YearLabel.setText("Year");

        RollnoLabel.setText("Roll No.");

        PhonenoLabel.setText("Phone Number");

        AddressLabel.setText("Address");

        CityLabel.setText("City");

        EventidLabel.setText("Event ID");

        DateLabel.setText("Registration Date");

        AmntpaidLabel.setText("Amount Paid");

        BalanceLabel.setText("Balance");

        CourseTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseTFieldActionPerformed(evt);
            }
        });

        YearTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearTFieldActionPerformed(evt);
            }
        });

        AddressTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressTFieldActionPerformed(evt);
            }
        });

        CityTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityTFieldActionPerformed(evt);
            }
        });

        DateTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateTFieldActionPerformed(evt);
            }
        });

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        ResetButton.setText("Reset");

        EventidComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Event" }));

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        SearchButton.setText("Search");

        EmailLabel.setText("Email ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AddressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(CityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(96, 96, 96)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AddressTField)
                                    .addComponent(CityTField)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EventidLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                .addGap(96, 96, 96)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DateTField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(EventidComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(PhonenoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(RollnoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(YearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CourseLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(96, 96, 96)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CourseTField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(NameTField))
                                    .addComponent(YearTField)
                                    .addComponent(RollnoTField)
                                    .addComponent(PhonenoTField)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(AmntpaidLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                        .addComponent(BalanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(EmailLabel))
                                .addGap(96, 96, 96)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AmntPaidTField)
                                    .addComponent(BalanceTField)
                                    .addComponent(EmailTField)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(SaveButton)))))
                        .addGap(36, 36, 36)
                        .addComponent(UpdateButton)
                        .addGap(45, 45, 45)
                        .addComponent(SearchButton)
                        .addGap(34, 34, 34)
                        .addComponent(ResetButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(581, 581, 581)
                        .addComponent(HeadLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(860, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HeadLabel)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLabel)
                    .addComponent(NameTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CourseLabel)
                    .addComponent(CourseTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(YearLabel)
                    .addComponent(YearTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RollnoLabel)
                    .addComponent(RollnoTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhonenoLabel)
                    .addComponent(PhonenoTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddressLabel)
                    .addComponent(AddressTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CityLabel)
                    .addComponent(CityTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EventidLabel)
                    .addComponent(EventidComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DateLabel)
                    .addComponent(DateTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmntpaidLabel)
                    .addComponent(AmntPaidTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BalanceLabel)
                    .addComponent(BalanceTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailLabel)
                    .addComponent(EmailTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(ResetButton)
                    .addComponent(UpdateButton)
                    .addComponent(SearchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CourseTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CourseTFieldActionPerformed

    private void YearTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YearTFieldActionPerformed

    private void AddressTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressTFieldActionPerformed

    private void CityTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CityTFieldActionPerformed

    private void DateTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateTFieldActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Participant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Participant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Participant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Participant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Participant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddressLabel;
    private javax.swing.JTextField AddressTField;
    private javax.swing.JTextField AmntPaidTField;
    private javax.swing.JLabel AmntpaidLabel;
    private javax.swing.JLabel BalanceLabel;
    private javax.swing.JTextField BalanceTField;
    private javax.swing.JLabel CityLabel;
    private javax.swing.JTextField CityTField;
    private javax.swing.JLabel CourseLabel;
    private javax.swing.JTextField CourseTField;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JTextField DateTField;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField EmailTField;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JComboBox<String> EventidComboBox;
    private javax.swing.JLabel EventidLabel;
    private javax.swing.JLabel HeadLabel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NameTField;
    private javax.swing.JLabel PhonenoLabel;
    private javax.swing.JTextField PhonenoTField;
    private javax.swing.JButton ResetButton;
    private javax.swing.JLabel RollnoLabel;
    private javax.swing.JTextField RollnoTField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel YearLabel;
    private javax.swing.JTextField YearTField;
    // End of variables declaration//GEN-END:variables
}
