
package com.form;

import com.main.Config;
    import java.sql.Connection;
    import javax.swing.table.DefaultTableModel;
    import java.sql.Statement;
    import java.sql.ResultSet;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Form_1 extends javax.swing.JPanel {
Connection conn;
    
private DefaultTableModel model;
    
//private void autonumber() {
//    try {
//        Connection conn = Config.configDB();
//        Statement s = conn.createStatement();
//        String sql = "SELECT MAX(no_kamar) AS max_no_kamar FROM kamar";
//        ResultSet rs = s.executeQuery(sql);
//
//        if (rs.next()) {
//            String lastNoKamar = rs.getString("max_no_kamar");
//            if (lastNoKamar != null) {
//                String NoKamar = lastNoKamar.substring(2); // Menghapus prefix "NK"
//                String NK = "" + (Integer.parseInt(NoKamar) + 1);
//                String Nol = "";
//
//                if (NK.length() == 1) {
//                    Nol = "00";
//                } else if (NK.length() == 2) {
//                    Nol = "0";
//                }
//
//                txtNoKamar.setText("NK" + Nol + NK);
//            } else {
//                txtNoKamar.setText("KA001");
//            }
//        }
//
//        rs.close();
//        s.close();
//    } catch (Exception e) {
//        e.printStackTrace();
//        System.out.println("autonumber error: " + e.getMessage());
//    }
//}

    private void autonumber(){
        try{
            Connection conn = (Connection) Config.configDB();
            Statement s = conn.createStatement();
            String sql ="SELECT MAX(no_kamar) AS max_no_kamar FROM kamar";
//            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()){
                String NoKamar = rs.getString("max_no_kamar").substring(2);
                String KA = "" + (Integer.parseInt(NoKamar) + 1);
                String Nol = "";
                
                if(KA.length()==1){
                    Nol = "0";
                }else if(KA.length()==2){
                    Nol = "";
//                }else if(KA.length()==3){
//                    Nol = "";
                }
                
                txtNoKamar.setText("KA" + Nol + KA);
                
            }else{
                txtNoKamar.setText("KA01");
            }
            rs.close();
            s.close();
        }catch(Exception e){
            System.out.println("autonumber error: " + e.getMessage());
        }
    }
//    
    public void clear(){
        
        txtNoKamar.setText("");
        txtHargaKamar.setText("");
        cmbFilter.getSelectedItem();
        cmbTipeKamar.getSelectedItem();
        cmbStatusKamar.getSelectedItem();
        
    }
    public void load_table(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        
        try{
            Connection conn = (Connection) Config.configDB();
            Statement s = conn.createStatement();
            String sql = "SELECT * FROM kamar";
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
                Object[]o = new Object[4];
                o [0] = rs.getString("no_kamar");
                o [1] = rs.getString("tipe_kamar");
                o [2] = rs.getString("harga_kamar");
                o [3] = rs.getString("status_kamar");
                
                
                
                model.addRow(o);
            }
            rs.close();
            s.close();
        }catch (SQLException e){
            System.out.println("terjadi kesalahan" + e.getMessage());
        }
    }

    public Form_1() {
        initComponents();
//        this.setLocationRelativeTo();
        
        txtNoKamar.setEnabled(false);
        
        model = new DefaultTableModel();
        
        table_Histori1.setModel(model);
        
        model.addColumn("No Kamar");
        model.addColumn("Tipe Kamar");
        model.addColumn("Harga Kamar");
        model.addColumn("Status Kamar");
        model.addColumn("Aksi");
        
        
        load_table();
        autonumber();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTambah = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHargaKamar = new javax.swing.JTextField();
        cmbTipeKamar = new javax.swing.JComboBox<>();
        cmbStatusKamar = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmbFilter = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        txtNoKamar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Histori1 = new com.swing.Table_Kamar();

        btnTambah.setText("Tambah");

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 153));
        jLabel2.setText("kamar");

        jLabel3.setText("No. Kamar             :");

        jLabel4.setText("Harga Kamar         :");

        jLabel5.setText("Tipe kamar     :");

        jLabel6.setText("Status Kamar  : ");

        txtHargaKamar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtHargaKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaKamarActionPerformed(evt);
            }
        });

        cmbTipeKamar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "      ", "Kamar Mandi Luar", "Kamar Mandi Dalam" }));
        cmbTipeKamar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        cmbStatusKamar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "     ", "Terisi", "Tersedia" }));
        cmbStatusKamar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        cmbStatusKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusKamarActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel7.setText("Filter by                  :");

        cmbFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "     ", "Terisi", "Tersedia" }));
        cmbFilter.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(null);

        table_Histori1.setEditingColumn(0);
        table_Histori1.setEditingRow(0);
        jScrollPane2.setViewportView(table_Histori1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtHargaKamar)
                            .addComponent(txtNoKamar)
                            .addComponent(cmbFilter, 0, 165, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(cmbTipeKamar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStatusKamar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNoKamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmbTipeKamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHargaKamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbStatusKamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtHargaKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaKamarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaKamarActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//String no_kamar = (String)cmbKa.getSelectedItem();
//String no_kamar1 = (String)cmbKb.getSelectedItem();
String no_kamar = txtNoKamar.getText();
String tipe_kamar = (String)cmbTipeKamar.getSelectedItem();
String harga_kamar = txtHargaKamar.getText();
String status_kamar = (String)cmbStatusKamar.getSelectedItem();

try{
            Connection conn = (Connection) Config.configDB();
            String sql = "INSERT INTO kamar VALUES (?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, no_kamar);
            pstm.setString(2, tipe_kamar);
            pstm.setString(3, harga_kamar);
            pstm.setString(4, status_kamar);
            pstm.executeUpdate();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
}catch(Exception e){
    System.out.println("Data gagal ditambahkan" + e.getMessage());
}finally{
    load_table();
    autonumber();
    clear();
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbStatusKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusKamarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStatusKamarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbFilter;
    private javax.swing.JComboBox<String> cmbStatusKamar;
    private javax.swing.JComboBox<String> cmbTipeKamar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private com.swing.Table_Kamar table_Histori1;
    private javax.swing.JTextField txtHargaKamar;
    private javax.swing.JTextField txtNoKamar;
    // End of variables declaration//GEN-END:variables
}
