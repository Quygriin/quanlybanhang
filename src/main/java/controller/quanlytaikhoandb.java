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
import model.khachhang;
import model.quanlytaikhoan;
import model.sanpham;

/**
 *
 * @author admin
 */
public class quanlytaikhoandb implements dbInterface<quanlytaikhoan>{

    @Override
    public ArrayList<quanlytaikhoan> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public int insert(quanlytaikhoan t) {
       int ketqua=0;
        try {
            Connection c=JDBC.getConnection();
            
            String sql="insert into taikhoan(tennguoidung,tentaikhoan,matkhau,email,sdt) values (?,?,?,?,?) ";
                  
            PreparedStatement st=c.prepareStatement(sql);
            st.setString(1, t.getTennguoidung());
            st.setString(2, t.getTaikhoan());
            st.setString(3,  t.getMatkhau());
            st.setString(4, t.getEmail());
            st.setString(5, t.getSdt());
            
            
            ketqua =st.executeUpdate();
            System.out.println(sql);
            JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int insertAll(ArrayList<quanlytaikhoan> arr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(quanlytaikhoan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteAll(ArrayList<quanlytaikhoan> arr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(quanlytaikhoan t) {
    int ketqua = 0;
    try {
        Connection c = JDBC.getConnection();
        if (c == null) {
            System.out.println("Kết nối thất bại.");
            return ketqua;
        }
        System.out.println("Connected to database.");

        String sql = "UPDATE taikhoan SET matkhau=? WHERE tentaikhoan=?";
        PreparedStatement st = c.prepareStatement(sql);

        // Gán các giá trị
        st.setString(1, t.getMatkhau());
        st.setString(2, t.getTaikhoan());
       

        // Kiểm tra dữ liệu đầu vào
        
        // Thực thi câu lệnh
        ketqua = st.executeUpdate();
        System.out.println("Rows affected: " + ketqua);

        JDBC.closeConnection(c);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ketqua;   
    }

    @Override
    public quanlytaikhoan selectById(quanlytaikhoan t) {
        quanlytaikhoan ketqua = null;
        try {
            Connection c = JDBC.getConnection();
            String sql = "SELECT * FROM taikhoan where tentaikhoan=?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, t.getTaikhoan());
           
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                 String tennguoidung = rs.getString("tennguoidung");
                  String tentaikhoan = rs.getString("tentaikhoan");
                String matkhau = rs.getString("matkhau");
               String email=rs.getString("email");
                String sdt = rs.getString("sdt");
               

              quanlytaikhoan ql=new quanlytaikhoan(tennguoidung, tentaikhoan, matkhau, email, sdt);
              ketqua=ql;
            }
            JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;   
    }
    
    public boolean kiemtrataikhoan(quanlytaikhoan t){
       boolean ketqua=false;
        try {
            Connection c=JDBC.getConnection();
            
            String sql="select * from taikhoan where tentaikhoan=?";
            PreparedStatement st=c.prepareStatement(sql);
            st.setString(1, t.getTaikhoan());
           
            
            ResultSet rs  = st.executeQuery();
            System.out.println(sql);
            while(rs.next()){
                ketqua=true;
            }
            
            JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
        
}
     public boolean kiemtraemail(String t){
       boolean ketqua=false;
        try {
            Connection c=JDBC.getConnection();
            
            String sql="select * from taikhoan where email=?";
            PreparedStatement st=c.prepareStatement(sql);
            st.setString(1, t);
           
            
            ResultSet rs  = st.executeQuery();
            System.out.println(sql);
            while(rs.next()){
                ketqua=true;
            }
            
            JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
        
}
    public boolean dangnhap(quanlytaikhoan t){
        boolean ketqua=false;
        try {
            Connection c=JDBC.getConnection();
            
            String sql="select * from taikhoan where tentaikhoan=? and matkhau=?";
            PreparedStatement st=c.prepareStatement(sql);
            st.setString(1, t.getTaikhoan());
            st.setString(2, t.getMatkhau());
            
            
            ResultSet rs  = st.executeQuery();
            System.out.println(sql);
            while(rs.next()){
                ketqua=true;
            }
            
            JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    public int updatePassword(String email,String matkhau){
        int ketqua=0;
        
        try {
            Connection c=JDBC.getConnection();
            
            String sql="update taikhoan set matkhau=? where email=?";
            PreparedStatement st=c.prepareStatement(sql);
            st.setString(1, matkhau );
            st.setString(2, email);
            
            
          ketqua= st.executeUpdate();
            System.out.println(sql);
            
            
            JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
}
