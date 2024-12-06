/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.hoadon;
import model.loaisanpham;

/**
 *
 * @author admin
 */
public class loaispdb  {
     public ArrayList<loaisanpham> selectAll() {
 ArrayList<loaisanpham> ketqua=new ArrayList<loaisanpham>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection c=JDBC.getConnection();
            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM loaisanpham";
            
            PreparedStatement st=c.prepareStatement(sql);
            
            System.out.println(sql);
            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
              String maloai=rs.getString("maloai");
	      String tenloai=rs.getString("tenloai");
	      
	     
              
             loaisanpham l=new loaisanpham(maloai, tenloai);
              ketqua.add(l);
            }
             JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;    
    }
      public loaisanpham selectById(String t) {
         loaisanpham ketqua=null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection c=JDBC.getConnection();
            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM loaisanpham where tenloai=?";
            
            PreparedStatement st=c.prepareStatement(sql);
            st.setString(1, t);
            System.out.println(sql);
            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
              String maloai=rs.getString("maloai");
	      String tenloai =rs.getString("tenloai");
            loaisanpham l=new loaisanpham(maloai, tenloai);
              ketqua=l;
            }
             JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
         return ketqua;
    }
      public int insert(loaisanpham t) {
       int ketqua=0;
        try {
            Connection c=JDBC.getConnection();
            
            String sql="insert into loaisanpham  (tenloai) "
                    + "values (?)";
            PreparedStatement st=c.prepareStatement(sql);
            st.setString(1, t.getTenloai());
          
           
            
            ketqua =st.executeUpdate();
            System.out.println(sql);
            JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
}
