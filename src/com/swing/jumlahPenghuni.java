
package com.swing;

import com.main.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;

public class jumlahPenghuni extends JLabel implements Runnable {

    public jumlahPenghuni() {
        super();
        fetchAndDisplayValue();
    }
    
        private void fetchAndDisplayValue(){
       try{
           Connection conn = (Connection) Config.configDB();
           String sql = ("SELECT COUNT(*) AS jumlah FROM penyewa ");
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
