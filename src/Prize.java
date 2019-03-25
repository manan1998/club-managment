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
public class Prize extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form Prize
     */SQLDEMO sobj;
     PreparedStatement pst;
     ResultSet rst;
     long id1=-1,id2=-1;
     long ed[];
     long pd[];
     int i;
    public Prize() {
        sobj=new SQLDEMO();
        ed=new long[100];
        pd=new long[100];
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
        try{i=1;
             pst=sobj.con.prepareCall("Select ParticipationID,Name from tbParticipation");
            rst=pst.executeQuery();
            while(rst.next()){
                pd[i]=rst.getInt(1);
                i++;
                Prize1WinnerComboBox.addItem(rst.getString(2).trim());
                Prize2WinnerComboBox.addItem(rst.getString(2).trim());
                Prize3WinnerComboBox.addItem(rst.getString(2).trim());
            }rst.close();
        }
        catch(Exception ex){
            ErrorLabel.setText("Error"+ex);
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==SaveButton){
            if(EventidComboBox.getSelectedIndex()==0)
                ErrorLabel.setText("Choose the Event as you cannot proceed ");
            if(ResultDateTField.getText()=="")
                ErrorLabel.setText("The date of announcement of result cannot be left blank");
            if(Prize1WinnerComboBox.getSelectedIndex()==0)
                ErrorLabel.setText("1st prize winner cannot be left blank");
            if(Prize2WinnerComboBox.getSelectedIndex()==0)
                ErrorLabel.setText("2nd prize winner cannot cannot be left blank");
            if(Prize3WinnerComboBox.getSelectedIndex()==0)
                ErrorLabel.setText("3rd prize winner cannot cannot be left blank");
            else{
                try{
                   pst=sobj.con.prepareCall("{call prcInsertResult(?,?,?,?,?)}");
                   pst.setLong(1,ed[EventidComboBox.getSelectedIndex()]);
                   pst.setString(2,ResultDateTField.getText());
                   pst.setLong(3,pd[Prize1WinnerComboBox.getSelectedIndex()]);
                   pst.setLong(4,pd[Prize2WinnerComboBox.getSelectedIndex()]);
                   pst.setLong(5,pd[Prize3WinnerComboBox.getSelectedIndex()]);

                   
                   
                   if(pst.execute()== false){
                ErrorLabel.setText("The declaration of result has been successfully done");
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
            ResultDateTField.setText("");
            Prize1WinnerComboBox.setSelectedIndex(0);
            Prize2WinnerComboBox.setSelectedIndex(0);
            Prize3WinnerComboBox.setSelectedIndex(0);
            
            
        }
        if(ae.getSource()==UpdateButton){
        if(id1 <0 && id2<0)
        ErrorLabel.setText("Please Search the information before updating");
        else{
            if(EventidComboBox.getSelectedIndex()==0)
                ErrorLabel.setText("Choose the Event as you cannot proceed ");
            if(ResultDateTField.getText()=="")
                ErrorLabel.setText("The date of announcement of result cannot be left blank");
            if(Prize1WinnerComboBox.getSelectedIndex()==0)
                ErrorLabel.setText("1st prize winner cannot be left blank");
            if(Prize2WinnerComboBox.getSelectedIndex()==0)
                ErrorLabel.setText("2nd prize winner cannot cannot be left blank");
            if(Prize3WinnerComboBox.getSelectedIndex()==0)
                ErrorLabel.setText("3rd prize winner cannot cannot be left blank");
            else{
                try{
                   pst=sobj.con.prepareCall("{call prcInsertResult(?,?,?,?,?)}");
                   pst.setLong(1,ed[EventidComboBox.getSelectedIndex()]);
                   pst.setString(2,ResultDateTField.getText());
                   pst.setLong(3,pd[Prize1WinnerComboBox.getSelectedIndex()]);
                   pst.setLong(4,pd[Prize2WinnerComboBox.getSelectedIndex()]);
                   pst.setLong(5,pd[Prize3WinnerComboBox.getSelectedIndex()]);

                   
                   
                   if(pst.execute()== false){
                ErrorLabel.setText("The updation of result has been successfully done");
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
        try{
            if((EventidComboBox.getSelectedIndex()==0) && ("".equals(ResultDateTField.getText())))
                 ErrorLabel.setText("Select the Event and enter the date of declaration of result");
            else{
            pst=sobj.con.prepareStatement("Select * from tbResult where EventId=? and ResultDate=?");
            pst.setLong(1,ed[EventidComboBox.getSelectedIndex()]);
            pst.setString(2,ResultDateTField.getText());
            rst=pst.executeQuery();
            if(rst.next()){
                id1=rst.getLong(1);
                id2=rst.getLong(2);
                Prize1WinnerComboBox.setSelectedIndex(new ArraySearch().searchArray(pd,rst.getLong(4)));
                Prize2WinnerComboBox.setSelectedIndex(new ArraySearch().searchArray(pd,rst.getLong(5)));
                Prize3WinnerComboBox.setSelectedIndex(new ArraySearch().searchArray(pd,rst.getLong(6)));
                               
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
        EventidLabel = new javax.swing.JLabel();
        ResultDateLabel = new javax.swing.JLabel();
        Prize1winnerLabel = new javax.swing.JLabel();
        Prize2WinnerLabel = new javax.swing.JLabel();
        Prize3WinnerLabel = new javax.swing.JLabel();
        ResultDateTField = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        EventidComboBox = new javax.swing.JComboBox<>();
        UpdateButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        ErrorLabel = new javax.swing.JLabel();
        Prize1WinnerComboBox = new javax.swing.JComboBox<>();
        Prize2WinnerComboBox = new javax.swing.JComboBox<>();
        Prize3WinnerComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HeadLabel.setText("Result of Prizes");

        EventidLabel.setText("Event ID");

        ResultDateLabel.setText("Result Date");

        Prize1winnerLabel.setText("Prize 1 Winner");

        Prize2WinnerLabel.setText("Prize 2 Winner");

        Prize3WinnerLabel.setText("Prize 3 Winner");

        ResultDateTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResultDateTFieldActionPerformed(evt);
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

        SearchButton.setText("Search");

        Prize1WinnerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select 1st Prize Winner" }));

        Prize2WinnerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select 2nd Prize Winner" }));

        Prize3WinnerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select 3rd Prize Winner" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EventidLabel)
                            .addComponent(ResultDateLabel)
                            .addComponent(Prize1winnerLabel)
                            .addComponent(Prize2WinnerLabel)
                            .addComponent(Prize3WinnerLabel))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Prize1WinnerComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ResultDateTField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(EventidComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Prize2WinnerComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Prize3WinnerComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(374, 374, 374)
                        .addComponent(HeadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(SaveButton)
                        .addGap(36, 36, 36)
                        .addComponent(UpdateButton)
                        .addGap(31, 31, 31)
                        .addComponent(SearchButton)
                        .addGap(43, 43, 43)
                        .addComponent(ResetButton)))
                .addContainerGap(999, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HeadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EventidLabel)
                    .addComponent(EventidComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResultDateLabel)
                    .addComponent(ResultDateTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Prize1winnerLabel)
                    .addComponent(Prize1WinnerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Prize2WinnerLabel)
                    .addComponent(Prize2WinnerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Prize3WinnerLabel)
                    .addComponent(Prize3WinnerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(UpdateButton)
                    .addComponent(SearchButton)
                    .addComponent(ResetButton))
                .addGap(34, 34, 34)
                .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(313, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ResultDateTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultDateTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResultDateTFieldActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Prize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prize().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JComboBox<String> EventidComboBox;
    private javax.swing.JLabel EventidLabel;
    private javax.swing.JLabel HeadLabel;
    private javax.swing.JComboBox<String> Prize1WinnerComboBox;
    private javax.swing.JLabel Prize1winnerLabel;
    private javax.swing.JComboBox<String> Prize2WinnerComboBox;
    private javax.swing.JLabel Prize2WinnerLabel;
    private javax.swing.JComboBox<String> Prize3WinnerComboBox;
    private javax.swing.JLabel Prize3WinnerLabel;
    private javax.swing.JButton ResetButton;
    private javax.swing.JLabel ResultDateLabel;
    private javax.swing.JTextField ResultDateTField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JButton UpdateButton;
    // End of variables declaration//GEN-END:variables
}
