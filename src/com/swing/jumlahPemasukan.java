
package com.swing;

import com.main.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;

public class jumlahPemasukan extends JLabel implements Runnable  {

    public jumlahPemasukan() {
        super();
        fetchAndDisplayValue();
    }
    
private void fetchAndDisplayValue(){
       try{
           Connection conn = (Connection) Config.configDB();
           String sql = "SELECT tgl_transaksi, SUM(total_harga) AS jumlah " +
                         "FROM detail_bayar " +
                         "JOIN transaksi ON transaksi.id_transaksi = detail_bayar.id_transaksi " +
                         "WHERE MONTH(tgl_transaksi) = MONTH(CURDATE()) " +
                         "GROUP BY tgl_transaksi";
           PreparedStatement pstm= conn.prepareStatement(sql);
           ResultSet rs = pstm.executeQuery();
           
           if(rs.next()){
               String valueFromDB = rs.getString("jumlah");
               setText(valueFromDB);
           }else{
               setText("NULL");
           }
           
           rs.close();
           pstm.close();
       } catch (Exception e){
           System.err.println("eror");
       }}
    @Override
    public void run(){
        throw new UnsupportedOperationException("Not Supported yet.");
    }
}
