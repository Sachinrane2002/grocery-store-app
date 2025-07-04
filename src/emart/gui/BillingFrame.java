/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.gui;

import emart.dao.OrderDAO;
import emart.dao.ProductsDAO;
import emart.pojo.ProductsPojo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sachi
 */
public class BillingFrame extends javax.swing.JFrame {

    /**
     * Creates new form BillingSection
     */
    ArrayList<ProductsPojo> al = new ArrayList<>();
    DefaultTableModel tm;
    double grTotal=0.0;
    public BillingFrame() {
        initComponents();
        this.setLocationRelativeTo(this);
        tm=(DefaultTableModel)jtBiiling.getModel();
        txtPId.requestFocus();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtBiiling = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtPId = new javax.swing.JTextField();
        btnLogOut = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnGenreteBilling = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Billing Option", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        jtBiiling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product Name", "Product Comany", "Price", "Our Price", "Quantity", "Tax", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtBiiling);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product Id");

        txtPId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPIdActionPerformed(evt);
            }
        });

        btnLogOut.setBackground(new java.awt.Color(204, 0, 0));
        btnLogOut.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setText("LogOut");

        btnBack.setBackground(new java.awt.Color(204, 0, 0));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203)
                .addComponent(btnBack)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogOut)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnGenreteBilling.setBackground(new java.awt.Color(204, 0, 0));
        btnGenreteBilling.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGenreteBilling.setForeground(new java.awt.Color(255, 255, 255));
        btnGenreteBilling.setText("Ganrate Bill");
        btnGenreteBilling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenreteBillingActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("product Id");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGenreteBilling)
                        .addGap(224, 224, 224)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btnGenreteBilling))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPIdActionPerformed
       if(txtPId.getText().trim().isEmpty()){
           JOptionPane.showMessageDialog(null, "Please Enter Product Id!", "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }
       loadItemList(txtPId.getText().trim());
    }//GEN-LAST:event_txtPIdActionPerformed

    private void btnGenreteBillingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenreteBillingActionPerformed
        try{
            String ordId = OrderDAO.getNextOrderId();
            if(OrderDAO.addOrder(al, ordId) && ProductsDAO.updateStocks(al)){
                JOptionPane.showMessageDialog(null, "Order of Rs"+grTotal+"/- created successfully");
                ViewOrdersFrame vs = new ViewOrdersFrame();
                vs.setVisible(true);
                this.dispose();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "DB Error!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnGenreteBillingActionPerformed

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
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillingFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGenreteBilling;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtBiiling;
    private javax.swing.JTextField txtPId;
    // End of variables declaration//GEN-END:variables

    private void loadItemList(String pId) {
        try{
            ProductsPojo p = ProductsDAO.getProductsDetails(pId);
            if(p.getProductId()==null){
                 JOptionPane.showMessageDialog(null, "Please Enter valid  Product Id!", "Error", JOptionPane.ERROR_MESSAGE);
                 return;
            }
            int index = getProductId(pId);
            if(index==-1){
                Object [] rows = new Object[8];
                int quan=1;
                double amt=quan*p.getOurPrice();
                p.setQuantity(quan);
                p.setTotal(amt+(amt*p.getTax()/100));
                rows[0] = p.getProductId();
                rows[1]=p.getProductName();
                rows[2]=p.getProductCompanyName();
                rows[3]=p.getPrice();
                rows[4]=p.getOurPrice();
                rows[5]=p.getQuantity();
                rows[6]=p.getTax();
                rows[7]=p.getTotal();
                tm.addRow(rows);
                al.add(p);
                grTotal+=p.getTotal();
            }
            else{
                ProductsPojo prd=al.get(index);
                int oldq=(int)tm.getValueAt(index,5);
                double amt = prd.getOurPrice();
                int tax=prd.getTax();
                amt=amt+(amt*tax/100);
                double total=(double)tm.getValueAt(index, 7);
                tm.setValueAt(++oldq,index,5);
                tm.setValueAt(total+amt,index,7);
                grTotal+=amt;
                prd.setQuantity(oldq);
                prd.setTotal(total+amt);
                al.set(index,prd);
                
                
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "DB Error!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

   private int getProductId(String pid){
       int index=-1;
       for(int i=0;i<al.size();i++){
           ProductsPojo p = al.get(i);
           if(p.getProductId().equals(pid)){
               index=i;
               break;
           }
       }
       return index;
   }
}
