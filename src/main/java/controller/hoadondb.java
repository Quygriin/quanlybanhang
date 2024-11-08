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
import model.doanhthu;
import model.hoadon;

/**
 *
 * @author admin
 */
public class hoadondb implements dbInterface<hoadon>{

    @Override
    public ArrayList<hoadon> selectAll() {
 ArrayList<hoadon> ketqua=new ArrayList<hoadon>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection c=JDBC.getConnection();
            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM hoadon";
            
            PreparedStatement st=c.prepareStatement(sql);
            
            System.out.println(sql);
            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
              String maHoaDon=rs.getString("mahoadon");
	      String makh=rs.getString("makh");
	      double tongtien=rs.getDouble("tongtien");
	      Date ngayTao=rs.getDate("ngaytao");
	     
              
             hoadon dt=new hoadon(maHoaDon, makh, tongtien, ngayTao);
              ketqua.add(dt);
            }
             JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;    
    }

    @Override
    public hoadon selectById(hoadon t) {
         hoadon ketqua=null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection c=JDBC.getConnection();
            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM khachhang where makh=?";
            
            PreparedStatement st=c.prepareStatement(sql);
            st.setString(1, t.getMahoadon());
            System.out.println(sql);
            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
              String maKhachHang=rs.getString("mahoadon");
	      String tenkh =rs.getString("makh");
	      Date ngaySinh=rs.getDate("ngaytao");
	      Double tongtien=rs.getDouble("tongtien");
	      
              
             hoadon hd=new hoadon(maKhachHang, maKhachHang, tongtien, ngaySinh);
              ketqua=hd;
            }
             JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
         return ketqua;
    }

    @Override
    public int insert(hoadon t) {
       int ketqua=0;
        try {
            Connection c=JDBC.getConnection();
            
            String sql="insert into hoadon  (mahoadon, makh, tongtien, ngaytao) "
                    + "values (?,?,?,?)";
            PreparedStatement st=c.prepareStatement(sql);
            st.setString(1, t.getMahoadon());
            st.setString(2, t.getMakhachhang());
            st.setDouble(3,  t.getTongtien());
            st.setDate(4, t.getNgaytao());
           
            
            ketqua =st.executeUpdate();
            System.out.println(sql);
            JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int insertAll(ArrayList<hoadon> arr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(hoadon t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteAll(ArrayList<hoadon> arr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(hoadon t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
