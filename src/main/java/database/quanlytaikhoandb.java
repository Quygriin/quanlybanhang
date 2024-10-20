/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.khachhang;
import model.quanlytaikhoan;

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
            
            String sql="insert into taikhoan(tennguoidung,taikhoan,matkhau,email,sdt) values (?,?,?,?,?) ";
                  
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public quanlytaikhoan selectById(quanlytaikhoan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean kiemtrataikhoan(quanlytaikhoan t){
       boolean ketqua=false;
        try {
            Connection c=JDBC.getConnection();
            
            String sql="select * from taikhoan where taikhoan=?";
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
    public boolean dangnhap(quanlytaikhoan t){
        boolean ketqua=false;
        try {
            Connection c=JDBC.getConnection();
            
            String sql="select * from taikhoan where taikhoan=? and matkhau=?";
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
}
