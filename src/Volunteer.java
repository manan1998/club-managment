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
public class Volunteer extends javax.swing.JFrame implements ActionListener{
PreparedStatement pst;
SQLDEMO sobj;
ResultSet rst;
long rd[];
long ed[];
long id=-1;
int i;
    /**
     * Creates new form Volunteer
     */
    public Volunteer() {
        sobj=new SQLDEMO();
        rd=new long[100];
        ed=new long[100];
        initComponents();
        SaveButton.addActionListener(this);
        ResetButton.addActionListener(this);
        UpdateButton.addActionListener(this);
        SearchButton.addActionListener(this);
        sobj.Connect();
        try{i=1;
            pst=sobj.con.prepareStatement("Select EventId,Title from tbEvent");
            rst=pst.executeQuery();
            while(rst.next()){
                ed[i]=rst.getInt(1);
                i++;
                EventIdComboBox.addItem(rst.getString(2).trim());
                }rst.close();
            }
        catch(Exception ex){
            ErrorLabel.setText("Error"+ex);
            } 
        sobj.Connect();
        try{i=1;
            pst=sobj.con.prepareStatement("Select RegistrationId, Name from tbMemRegister");
            rst=pst.executeQuery();
            while(rst.next()){
                rd[i]=rst.getInt(1);
                i++;
                RegistrationIdComboBox.addItem(rst.getString(2).trim());
            }rst.close();
        }
        catch(Exception ex){
            ErrorLabel.setText("Error"+ex);
            } 
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==SaveButton){
            if(EventIdComboBox.getSelectedItem()==null)
                ErrorLabel.setText("Select one of the events as it cannot be left blank");
            if(RegistrationIdComboBox.getSelectedItem()==null)
                ErrorLabel.setText("Select one of the member as it cannot be left blank");
            if("".equals(DescriptionTField.getText()))
                ErrorLabel.setText("Please enter the duty description to get the duty assigned as it cannot be left blank");
            if("".equals(DateTField.getText()))
                ErrorLabel.setText("Please enter the assigning date as it cannot be left blank");
            else{
        try{            
            pst=sobj.con.prepareCall("{call prcInsertVolunteer(?,?,?,?)}");
            pst.setLong(1,ed[EventIdComboBox.getSelectedIndex()]);
            pst.setLong(2,rd[RegistrationIdComboBox.getSelectedIndex()]);
            pst.setString(3,DescriptionTField.getText());
            pst.setString(4,DateTField.getText());
                               
            if(pst.execute()== false){
                ErrorLabel.setText("The registration for volunteer has been successfully done");
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
        EventIdComboBox.setSelectedIndex(0);
        RegistrationIdComboBox.setSelectedIndex(0);
        DescriptionTField.setText("");
        DateTField.setText("");
        StatusTField.setText("");
    }
    if(ae.getSource()==UpdateButton){
        if(id<0)
            ErrorLabel.setText("Please perform search first to perform updation of data");
        else{
            if(EventIdComboBox.getSelectedItem()==null)
                ErrorLabel.setText("Select one of the events as it cannot be left blank");
            if(RegistrationIdComboBox.getSelectedItem()==null)
                ErrorLabel.setText("Select one of the member as it cannot be left blank");
            if("".equals(DescriptionTField.getText()))
                ErrorLabel.setText("Please enter the duty description to get the duty assigned as it cannot be left blank");
            if("".equals(DateTField.getText()))
                ErrorLabel.setText("Please enter the assigning date as it cannot be left blank");
            else{
        try{            
            pst=sobj.con.prepareCall("{call prcInsertVolunteer(?,?,?,?)}");
            pst.setLong(1,ed[EventIdComboBox.getSelectedIndex()]);
            pst.setLong(2,rd[RegistrationIdComboBox.getSelectedIndex()]);
            pst.setString(3,DescriptionTField.getText());
            pst.setString(4,DateTField.getText());
                               
            if(pst.execute()== false){
                ErrorLabel.setText("The registration for volunteer has been successfully done");
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
        }//for update
    if(ae.getSource()==SearchButton){
    sobj.Connect();
        id=-1;
        try{
            if((EventIdComboBox.getSelectedIndex()==0) && (RegistrationIdComboBox.getSelectedIndex()==0))
                ErrorLabel.setText("Please select event and registration name of the member for searching");
            else{
            pst=sobj.con.prepareStatement("Select * from tbVolunteer where EventID=? and RegistrationID=?");
            pst.setLong(1,ed[EventIdComboBox.getSelectedIndex()]);
            pst.setLong(2,rd[RegistrationIdComboBox.getSelectedIndex()]);
            rst=pst.executeQuery();
            if(rst.next()){
                id=rst.getLong(1);
                DescriptionTField.setText(rst.getString(4));
                DateTField.setText(rst.getString(5));
                StatusTField.setText(rst.getString(6));
                
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
        EventidLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DescriptionLabel = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        StatusLabel = new javax.swing.JLabel();
        DescriptionTField = new javax.swing.JTextField();
        DateTField = new javax.swing.JTextField();
        StatusTField = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        EventIdComboBox = new javax.swing.JComboBox<>();
        UpdateButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        RegistrationIdComboBox = new javax.swing.JComboBox<>();
        ErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HeadLabel.setText("Volunteer Registration");

        EventidLabel.setText("Event ID");

        jLabel4.setText("Registration ID");

        DescriptionLabel.setText("Duty Description");

        DateLabel.setText("Assigning Date");

        StatusLabel.setText("Status");

        DescriptionTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescriptionTFieldActionPerformed(evt);
            }
        });

        SaveButton.setText("Save");

        ResetButton.setText("Reset");

        EventIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Event" }));
        EventIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventIdComboBoxActionPerformed(evt);
            }
        });

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        RegistrationIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Registration" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EventidLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DescriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(DateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(DescriptionTField)
                                .addComponent(DateTField)
                                .addComponent(StatusTField)
                                .addComponent(EventIdComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RegistrationIdComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(446, 446, 446)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(HeadLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SaveButton)
                                        .addGap(42, 42, 42)
                                        .addComponent(UpdateButton)
                                        .addGap(51, 51, 51)
                                        .addComponent(SearchButton)
                                        .addGap(37, 37, 37)
                                        .addComponent(ResetButton))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(658, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HeadLabel)
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EventidLabel)
                    .addComponent(EventIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(RegistrationIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DescriptionLabel)
                    .addComponent(DescriptionTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DateLabel)
                    .addComponent(DateTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatusLabel)
                    .addComponent(StatusTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(UpdateButton)
                    .addComponent(SearchButton)
                    .addComponent(ResetButton))
                .addGap(83, 83, 83)
                .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(209, 209, 209))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DescriptionTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescriptionTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescriptionTFieldActionPerformed

    private void EventIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventIdComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EventIdComboBoxActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Volunteer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateLabel;
    private javax.swing.JTextField DateTField;
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JTextField DescriptionTField;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JComboBox<String> EventIdComboBox;
    private javax.swing.JLabel EventidLabel;
    private javax.swing.JLabel HeadLabel;
    private javax.swing.JComboBox<String> RegistrationIdComboBox;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JTextField StatusTField;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
