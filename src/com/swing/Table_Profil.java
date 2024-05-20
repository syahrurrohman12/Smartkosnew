package com.swing;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import com.main.Config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JLabel;

public class Table_Profil extends JTable {

    private void load_table(){
        try {
            int q;
            Connection conn = (Connection) Config.configDB();
            String sql = "SELECT * FROM penyewa";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            java.sql.ResultSetMetaData rss =rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel model = (DefaultTableModel) getModel();
            model.setRowCount(0);

            while(rs.next()){
                Vector v2 = new Vector();
                for (int i = 1; i <= q - 1; i++) {
                    v2.add(rs.getString("no_kamar"));
                    v2.add(rs.getString("email_penyewa"));
                    v2.add(rs.getString("nama_penyewa"));
                    v2.add(rs.getString("alamat_penyewa"));
                    v2.add(rs.getString("notelp_penyewa"));
                    v2.add(rs.getString("notelp_ortu"));
                }
                model.addRow(v2);
            }

            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
            e.printStackTrace();
        }
    }   


    public Table_Profil() {
        load_table();
        setShowHorizontalLines(true);
        setGridColor(new Color (230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            TableHeader header = new TableHeader(value + "");
            if (column == 3){
                header.setHorizontalAlignment(JLabel.CENTER);
            }
            return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (column != 3) {
                Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
                com.setBackground(Color.WHITE);
                setBorder(noFocusBorder);
                if(isSelected) {
                    com.setForeground(new Color(20, 20, 20));
                } else {
                    com.setForeground(new Color(129,128,128));
                }
                return com;
            }
            return new JLabel("");
            
            }
        
        });
        

    }
    
    JTable table = new JTable();


}    

