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


/**
 *
 * @author admin
 */
public class doanhthudb implements dbInterface<doanhthu>{

    
     @Override
    public ArrayList<doanhthu> selectAll() {
        
        ArrayList<doanhthu> ketqua=new ArrayList<doanhthu>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection c=JDBC.getConnection();
            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM doanhthu";
            
            PreparedStatement st=c.prepareStatement(sql);
            
            System.out.println(sql);
            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
              String maDoanhthu=rs.getString("madoanhthu");
	      Date ngaydoanhthu=rs.getDate("ngaydoanhthu");
	      double tongtien=rs.getDouble("tongtien");
	      String ghichu=rs.getString("ghichu");
	     
              
             doanhthu dt=new doanhthu(maDoanhthu, ngaydoanhthu, tongtien, ghichu);
              ketqua.add(dt);
            }
             JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public doanhthu selectById(doanhthu t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(doanhthu t) {
       int ketqua=0;
        try {
            Connection c=JDBC.getConnection();
            
            String sql="insert into doanhthu(madoanhthu, ngaydoanhthu, tongien, ghichu) "
                    + "values (?,?,?,?)";
            PreparedStatement st=c.prepareStatement(sql);
            st.setString(1, t.getMadoanhthu());
          
            st.setDate(3,  t.getNgaydoanhthu());
            st.setDouble(4, t.getTongtien());
            st.setString(5, t.getGhichu());
            ketqua =st.executeUpdate();
            System.out.println(sql);
            JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int insertAll(ArrayList<doanhthu> arr) {
        int ketqua=0;
        for (doanhthu a : arr) {
            ketqua++;
            this.insert(a);
        }
        return ketqua;
    }

    @Override
    public int delete(doanhthu t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteAll(ArrayList<doanhthu> arr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(doanhthu t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     public ArrayList<doanhthu> selectbydate(Date batdau,Date ketthuc) {
        
        ArrayList<doanhthu> ketqua=new ArrayList<doanhthu>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection c=JDBC.getConnection();
            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM doanhthu where ngaydoanhthu between ? and ? ";
            
            PreparedStatement st=c.prepareStatement(sql);
            st.setString(1, batdau.toString());
            st.setString(2, ketthuc.toString());
            System.out.println("SELECT * FROM doanhthu where ngaydoanhthu between"+batdau+ "and "+ketthuc);
            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
              String maDoanhthu=rs.getString("madoanhthu");
	      Date ngaydoanhthu=rs.getDate("ngaydoanhthu");
	      double tongtien=rs.getDouble("tongtien");
	      String ghichu=rs.getString("ghichu");
	     
              
             doanhthu dt=new doanhthu(maDoanhthu, ngaydoanhthu, tongtien, ghichu);
              ketqua.add(dt);
            }
             JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

}
