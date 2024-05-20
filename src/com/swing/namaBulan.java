package com.swing;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;

public class namaBulan extends JLabel implements Runnable  {

    public namaBulan() {
        super();
        updateLabel();
    }
    
    private void updateLabel() {
        // Dapatkan tanggal dan waktu saat ini
        Calendar calendar = Calendar.getInstance();
        // Dapatkan bulan saat ini
        int bulan = calendar.get(Calendar.MONTH);
        // Format bulan menjadi MMMM-yy
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yy");
        // Format tanggal saat ini menjadi nama bulan
        String namaBulan = sdf.format(calendar.getTime());
        // Tampilkan nama bulan di JLabel
        setText(namaBulan);
    }
//private void fetchAndDisplayValue(){
//       try{
//           Connection conn = (Connection) Config.configDB();
//           String sql = ("SELECT tanggal FROM keuangan");
//           PreparedStatement pstm= conn.prepareStatement(sql);
//           ResultSet rs = pstm.executeQuery();
//           
//           if(rs.next()){
//               Date tanggal = rs.getDate("tanggal");
//                String namaBulan = new SimpleDateFormat("MMMM-yy").format(tanggal);
//                
//                // Tampilkan nama bulan di JLabel
//                setText(namaBulan);
//           }else{
//               setText("NULL");
//           }
//           
//           rs.close();
//           pstm.close();
//       } catch (Exception e){
//           System.err.println("eror");
//       }}
    @Override
    public void run(){
        throw new UnsupportedOperationException("Not Supported yet.");
    }

}

