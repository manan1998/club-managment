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
public class Event extends javax.swing.JFrame implements ActionListener{
SQLDEMO sobj;
PreparedStatement pst;
ResultSet rst;
    /**
     * Creates new form Event
     */
long cd[];
long id;
    public Event() { 
    cd=new long[100];
        int index=1;
        sobj=new SQLDEMO();
        initComponents();
        SaveButton.addActionListener(this);//for save
        ResetButton.addActionListener(this);//for reset
        UpdateButton.addActionListener(this);//for update
        SearchButton.addActionListener(this);//for search
        sobj.Connect();
        try{
            pst=sobj.con.prepareStatement("Select ClubId,Name from tbClub");
            rst=pst.executeQuery();
            while(rst.next()){
                cd[index]=rst.getInt(1);
                index++;
                ClubidComboBox.addItem(rst.getString(2).trim());
            }
            rst.close();
        }
        catch(Exception ex){
            ErrorLabel.setText("Error"+ex);
        }        
    }
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==SaveButton){
    if(TitleTField.getText().equals(""))
        ErrorLabel.setText("Title of the event cannot be left blank");
    if(DateTField.getText().equals(""))
        ErrorLabel.setText("Date of the event cannot be left blank");
    if(VenueTField.getText().equals(""))
        ErrorLabel.setText("Venue of the event cannot be left blank");
    if(TypeTField.getText().equals(""))
        ErrorLabel.setText("Type of the event cannot be left blank");    
    if(TeacherInchTField.getText().equals(""))
        ErrorLabel.setText("Teacher Incharge of the event cannot be left blank");
    if(StudentInchTField.getText().equals(""))
        ErrorLabel.setText("Student Incharge of the event cannot be left blank");
    if(Prize1TField.getText().equals(""))
        ErrorLabel.setText("Prize 1 of the event cannot be left blank");
    if(Prize2TField.getText().equals(""))
        ErrorLabel.setText("Prize 2 of the event cannot be left blank");
    if(Prize3TField.getText().equals(""))
        ErrorLabel.setText("Prize 3 of the event cannot be left blank");
    if(DescriptionTField.getText().equals(""))
        ErrorLabel.setText("Description of the event cannot be left blank");
    if(PfeeTField.getText().equals(""))
        ErrorLabel.setText("Participation fee for the event cannot be left blank");
    if(ClubidComboBox.getSelectedIndex()==0)
        ErrorLabel.setText("Select the club to proceed as it cannot be left blank");
    else{
        try{sobj.Connect();
            pst=sobj.con.prepareCall("{call prcInsertEvent(?,?,?,?,?,?,?,?,?,?,?,?)}");
            pst.setString(1,TitleTField.getText());
            pst.setString(2,DateTField.getText());
            pst.setString(3,VenueTField.getText());
            pst.setString(4,TypeTField.getText());
            pst.setLong(5,cd[ClubidComboBox.getSelectedIndex()]);
            pst.setString(6,TeacherInchTField.getText());
            pst.setString(7,StudentInchTField.getText());
            pst.setString(8,Prize1TField.getText());
            pst.setString(9,Prize2TField.getText());
            pst.setString(10,Prize3TField.getText());
            pst.setString(11,DescriptionTField.getText());
            pst.setInt(12,Integer.parseInt(PfeeTField.getText()));
                   
            if(pst.execute()== false){
                ErrorLabel.setText("The registration of event has been successfully done");
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
    TitleTField.setText("");
    DateTField.setText("");
    VenueTField.setText("");
    TypeTField.setText("");
    TeacherInchTField.setText("");
    StudentInchTField.setText("");
    Prize1TField.setText("");
    Prize2TField.setText("");
    Prize3TField.setText("");
    DescriptionTField.setText("");
    StatusTField.setText("");
    PfeeTField.setText("");
    }
    if(ae.getSource()==UpdateButton){
    if(id <0)
        ErrorLabel.setText("Please Search the information before updating");
    else{
    if(TitleTField.getText().equals(""))
        ErrorLabel.setText("Title of the event cannot be left blank");
    if(DateTField.getText().equals(""))
        ErrorLabel.setText("Date of the event cannot be left blank");
    if(VenueTField.getText().equals(""))
        ErrorLabel.setText("Venue of the event cannot be left blank");
    if(TypeTField.getText().equals(""))
        ErrorLabel.setText("Type of the event cannot be left blank");    
    if(TeacherInchTField.getText().equals(""))
        ErrorLabel.setText("Teacher Incharge of the event cannot be left blank");
    if(StudentInchTField.getText().equals(""))
        ErrorLabel.setText("Student Incharge of the event cannot be left blank");
    if(Prize1TField.getText().equals(""))
        ErrorLabel.setText("Prize 1 of the event cannot be left blank");
    if(Prize2TField.getText().equals(""))
        ErrorLabel.setText("Prize 2 of the event cannot be left blank");
    if(Prize3TField.getText().equals(""))
        ErrorLabel.setText("Prize 3 of the event cannot be left blank");
    if(DescriptionTField.getText().equals(""))
        ErrorLabel.setText("Description of the event cannot be left blank");
    if(PfeeTField.getText().equals(""))
        ErrorLabel.setText("Participation fee for the event cannot be left blank");
    if(ClubidComboBox.getSelectedIndex()==0)
        ErrorLabel.setText("Select the club to proceed as it cannot be left blank");
    else{
        try{sobj.Connect();
            pst=sobj.con.prepareCall("{call prcInsertEvent(?,?,?,?,?,?,?,?,?,?,?,?)}");
            pst.setString(1,TitleTField.getText());
            pst.setString(2,DateTField.getText());
            pst.setString(3,VenueTField.getText());
            pst.setString(4,TypeTField.getText());
            pst.setLong(5,cd[ClubidComboBox.getSelectedIndex()]);
            pst.setString(6,TeacherInchTField.getText());
            pst.setString(7,StudentInchTField.getText());
            pst.setString(8,Prize1TField.getText());
            pst.setString(9,Prize2TField.getText());
            pst.setString(10,Prize3TField.getText());
            pst.setString(11,DescriptionTField.getText());
            pst.setInt(12,Integer.parseInt(PfeeTField.getText()));
                   
            if(pst.execute()== false){
                ErrorLabel.setText("The updation of data of event has been successfully done");
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
            if("".equals(TitleTField.getText()))
                ErrorLabel.setText("Enter the title of the event to perform the search");
            else{
            pst=sobj.con.prepareStatement("Select * from tbEvent where Title=?");
            pst.setString(1,TitleTField.getText());
            rst=pst.executeQuery();
            if(rst.next()){
                id=rst.getLong(1);
                ClubidComboBox.setSelectedIndex(new ArraySearch().searchArray(cd,rst.getLong(6)));
                DateTField.setText(rst.getString(3));
                VenueTField.setText(rst.getString(4));
                TypeTField.setText(rst.getString(5));
                TeacherInchTField.setText(rst.getString(7));
                StudentInchTField.setText(rst.getString(8));
                Prize1TField.setText(rst.getString(9));
                Prize2TField.setText(rst.getString(10));
                Prize3TField.setText(rst.getString(11));
                DescriptionTField.setText(rst.getString(12));
                StatusTField.setText(rst.getString(13));
                PfeeTField.setText(Long.toString(rst.getLong(14)));
                
            }
            rst.close();
        }}
       catch(Exception ex){
            ErrorLabel.setText("Error"+ex);
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
        TitleLabel = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        VenueLabel = new javax.swing.JLabel();
        TypeLabel = new javax.swing.JLabel();
        ClubidLabel = new javax.swing.JLabel();
        TeacherInchLabel = new javax.swing.JLabel();
        StudentInchLabel = new javax.swing.JLabel();
        Prize1Label = new javax.swing.JLabel();
        Prize2Label = new javax.swing.JLabel();
        Prize3Label = new javax.swing.JLabel();
        DescriptionLabel = new javax.swing.JLabel();
        StatusLabel = new javax.swing.JLabel();
        PfeeLabel = new javax.swing.JLabel();
        TitleTField = new javax.swing.JTextField();
        DateTField = new javax.swing.JTextField();
        VenueTField = new javax.swing.JTextField();
        TypeTField = new javax.swing.JTextField();
        TeacherInchTField = new javax.swing.JTextField();
        StudentInchTField = new javax.swing.JTextField();
        Prize1TField = new javax.swing.JTextField();
        Prize2TField = new javax.swing.JTextField();
        Prize3TField = new javax.swing.JTextField();
        DescriptionTField = new javax.swing.JTextField();
        StatusTField = new javax.swing.JTextField();
        PfeeTField = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        ClubidComboBox = new javax.swing.JComboBox<>();
        ErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HeadLabel.setText("Event Registration ");

        TitleLabel.setText("Title");

        DateLabel.setText("Date of Registration");

        VenueLabel.setText("Venue");

        TypeLabel.setText("Type of Event");

        ClubidLabel.setText("Club ID");

        TeacherInchLabel.setText("Teacher Incharge");

        StudentInchLabel.setText("Student Incharge");

        Prize1Label.setText("Prize 1");

        Prize2Label.setText("Prize 2");

        Prize3Label.setText("Prize 3");

        DescriptionLabel.setText("Description");

        StatusLabel.setText("Status");

        PfeeLabel.setText("Participation Fee");

        TitleTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitleTFieldActionPerformed(evt);
            }
        });

        DateTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateTFieldActionPerformed(evt);
            }
        });

        Prize1TField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Prize1TFieldActionPerformed(evt);
            }
        });

        Prize3TField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Prize3TFieldActionPerformed(evt);
            }
        });

        StatusTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusTFieldActionPerformed(evt);
            }
        });

        PfeeTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PfeeTFieldActionPerformed(evt);
            }
        });

        SaveButton.setText("Save");

        ResetButton.setText("Reset");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        UpdateButton.setText("Update");

        SearchButton.setText("Search");

        ClubidComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Club" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(545, 545, 545)
                        .addComponent(HeadLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(StudentInchLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TeacherInchLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(PfeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(VenueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(ClubidLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TypeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(StatusLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(DescriptionLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                        .addComponent(Prize3Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Prize1Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Prize2Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(DateLabel))
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TitleTField, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                        .addComponent(DateTField)
                                        .addComponent(VenueTField)
                                        .addComponent(TypeTField)
                                        .addComponent(TeacherInchTField)
                                        .addComponent(StudentInchTField)
                                        .addComponent(Prize1TField)
                                        .addComponent(Prize2TField)
                                        .addComponent(Prize3TField)
                                        .addComponent(DescriptionTField)
                                        .addComponent(StatusTField)
                                        .addComponent(ClubidComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(PfeeTField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SaveButton))
                                .addGap(48, 48, 48)
                                .addComponent(UpdateButton)
                                .addGap(49, 49, 49)
                                .addComponent(SearchButton)
                                .addGap(47, 47, 47)
                                .addComponent(ResetButton)))))
                .addContainerGap(965, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HeadLabel)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TitleTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DateLabel)
                    .addComponent(DateTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VenueLabel)
                    .addComponent(VenueTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TypeLabel)
                    .addComponent(TypeTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClubidLabel)
                    .addComponent(ClubidComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(Prize1Label)
                    .addComponent(Prize1TField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Prize2Label)
                    .addComponent(Prize2TField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Prize3Label)
                    .addComponent(Prize3TField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DescriptionLabel)
                    .addComponent(DescriptionTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatusLabel)
                    .addComponent(StatusTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PfeeLabel)
                    .addComponent(PfeeTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(UpdateButton)
                    .addComponent(SearchButton)
                    .addComponent(ResetButton))
                .addGap(38, 38, 38)
                .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TitleTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TitleTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TitleTFieldActionPerformed

    private void DateTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateTFieldActionPerformed

    private void Prize1TFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Prize1TFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Prize1TFieldActionPerformed

    private void Prize3TFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Prize3TFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Prize3TFieldActionPerformed

    private void StatusTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StatusTFieldActionPerformed

    private void PfeeTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PfeeTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PfeeTFieldActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Event().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ClubidComboBox;
    private javax.swing.JLabel ClubidLabel;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JTextField DateTField;
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JTextField DescriptionTField;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JLabel HeadLabel;
    private javax.swing.JLabel PfeeLabel;
    private javax.swing.JTextField PfeeTField;
    private javax.swing.JLabel Prize1Label;
    private javax.swing.JTextField Prize1TField;
    private javax.swing.JLabel Prize2Label;
    private javax.swing.JTextField Prize2TField;
    private javax.swing.JLabel Prize3Label;
    private javax.swing.JTextField Prize3TField;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JTextField StatusTField;
    private javax.swing.JLabel StudentInchLabel;
    private javax.swing.JTextField StudentInchTField;
    private javax.swing.JLabel TeacherInchLabel;
    private javax.swing.JTextField TeacherInchTField;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField TitleTField;
    private javax.swing.JLabel TypeLabel;
    private javax.swing.JTextField TypeTField;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel VenueLabel;
    private javax.swing.JTextField VenueTField;
    // End of variables declaration//GEN-END:variables


}
