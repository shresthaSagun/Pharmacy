/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Com.pharmacy.view;

import Com.pharmacy.common.DBConnection;
import Com.pharmacy.controller.ProductDAO;
import Com.pharmacy.controller.billDAO;
import Com.pharmacy.model.bill;
import Com.pharmacy.model.product;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sushil Shrestha
 */
public class searchBill extends javax.swing.JFrame {
ArrayList name=new ArrayList();
    DefaultTableModel model;
    /**
     * Creates new form searchBill
     */
    public searchBill() {
        initComponents();
           databasenama();
           model=new DefaultTableModel(null,new Object[]{"Drug Name","Expiry Date","","Quantity","Rate","Amount"});
        //set this object to jTable_Product
        jTable_bill.setModel(model);
    }
    private void createTable(){
        int rowCount=jTable_bill.getRowCount();
        for(int i=0;i<rowCount;i++) {
            model.removeRow(0);
        }
        }
private void clearFields() {
       // jTextField_billno.setText("");
        
    }
    void loadData(){
    String bno=jTextField_billno.getText();
        
        int p= Integer.parseInt(jTextField_billno.getText());
        System.out.println(p);
       
        
        
        if(jTextField_billno.getText().equals("")){
            System.out.println("out");
        }
        
            
            billDAO pDAO=new billDAO();
            ArrayList<bill> list=pDAO.fetchData(p);
            for(int i=0;i<list.size();i++)
        {
            
            model.addRow(new Object[]{list.get(i).getItem(),list.get(i).getExp_month(),list.get(i).getExp_year(),list.get(i).getQtysold(),list.get(i).getRate(),list.get(i).getAmount()});  
              //computeTotal();
            
        }
            
            
                clearFields();
        //if(z!=0){
            
        }
        
        //if(jTextField_discount.equals("0")){
          //  jLabel_grandtotal=(jLabel_total);
        //}

    /**f
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField_billno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_bill = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("SEARCH BILL");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField_billno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_billnoActionPerformed(evt);
            }
        });
        jTextField_billno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_billnoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_billnoKeyTyped(evt);
            }
        });

        jLabel1.setText("Enter Billno:");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable_bill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_bill);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_billno, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton1)
                        .addGap(99, 99, 99)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_billno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel2)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_billnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_billnoKeyTyped
        // TODO add your handling code here:
                char ch=evt.getKeyChar();
        if(!(ch>='0' && ch<='9')){
            evt.consume();
        }

    }//GEN-LAST:event_jTextField_billnoKeyTyped

    private void jTextField_billnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_billnoKeyPressed
        // TODO add your handling code here:
        
        switch(evt.getKeyCode()){
            case KeyEvent.VK_BACK_SPACE:
                break;
            case KeyEvent.VK_ENTER:
                jTextField_billno.setText(jTextField_billno.getText());
                break;
            default:
                EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                    String txt=jTextField_billno.getText();
                    autocomplete(txt);
                    
            }
       
        });
        }
        
    }//GEN-LAST:event_jTextField_billnoKeyPressed

    private void jTextField_billnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_billnoActionPerformed
        // TODO add your handling code here:
         /*       DefaultTableModel m= (DefaultTableModel)jTable_bill.getModel();
        while(model.getRowCount()>0){
            for(int i=0;i<model.getRowCount();i++){
            model.removeRow(i);
        }
        }

        loadData();*/
    }//GEN-LAST:event_jTextField_billnoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel m= (DefaultTableModel)jTable_bill.getModel();
        while(model.getRowCount()>0){
            for(int i=0;i<model.getRowCount();i++){
            model.removeRow(i);
        }
        }

        loadData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MainframeAdmin m=new MainframeAdmin();
            m.setTitle("Medical Store Management");
            m.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(searchBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_bill;
    private javax.swing.JTextField jTextField_billno;
    // End of variables declaration//GEN-END:variables

    public void databasenama() {
         
        try{
            Connection con=DBConnection.getConnection();
            String sql="select * from bill";
            Statement st=con.createStatement();
            if(con!=null)
            {
                System.out.println("Connection Sucessful");
            }
            else
                System.out.println("Connection failed");
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {
                String nama=rs.getString("billno");
                 
                name.add(nama);
            }
            rs.close();
                    
            con.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }


         }
    public void autocomplete(String txt){
        String complete= " ";
        int start=txt.length();
        int last=txt.length();
        int a;
        for(a=0;a<name.size();a++){
            if(name.get(a).toString().startsWith(txt)){
                complete=name.get(a).toString();
                last=complete.length();
                break;
            }
    }
        if(last>start){
            jTextField_billno.setText(complete);
            jTextField_billno.setCaretPosition(last);
            jTextField_billno.moveCaretPosition(start);
        }
        
    }
        
}
