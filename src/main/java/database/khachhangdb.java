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

/**
 *
 * @author admin
 */
public class khachhangdb implements dbInterface<khachhang>{

    @Override
    public ArrayList<khachhang> selectAll() {
        
        ArrayList<khachhang> ketqua=new ArrayList<khachhang>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection c=JDBC.getConnection();
            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM khachhang";
            
            PreparedStatement st=c.prepareStatement(sql);
            
            System.out.println(sql);
            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
              String maKhachHang=rs.getString("makh");
	      String tenkh =rs.getString("tenkh");
	      Date ngaySinh=rs.getDate("ngaysinh");
	      String gioiTinh=rs.getString("gioitinh");
	      String email=rs.getString("email");
	      String diaChi=rs.getString("diachi");
	      String soDienThoai=rs.getString("sodt");
	      String loaiKhachHang=rs.getString("loaikhachhang");
	      String ghiChu=rs.getString("ghichi");
              
             khachhang kh=new khachhang(maKhachHang, tenkh, ngaySinh, gioiTinh, email, diaChi, soDienThoai, loaiKhachHang, ghiChu);
              ketqua.add(kh);
            }
             JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public khachhang selectById(khachhang t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

    @Override
    public int insert(khachhang t) {
        int ketqua=0;
        try {
            Connection c=JDBC.getConnection();
            
            String sql="insert into khachhang(makh, tenkh, ngaySinh, gioiTinh, email, diaChi, sodt, loaiKhachHang, ghiChu) "
                    + "values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement st=c.prepareStatement(sql);
            st.setString(1, t.getMaKhachHang() );
            st.setString(2, t.getTenkh());
            st.setDate(3,  t.getNgaySinh());
            st.setString(4, t.getGioiTinh());
            st.setString(5, t.getEmail() );
            st.setString(6, t.getDiaChi());
            st.setString(7, t.getSoDienThoai());
            st.setString(8, t.getLoaiKhachHang());
            st.setString(9, t.getGhiChu());
            
            ketqua =st.executeUpdate();
            System.out.println(sql);
            JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int insertAll(ArrayList<khachhang> arr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(khachhang t) {
        int ketqua=0;
        try {
            Connection c=JDBC.getConnection();
            
            String sql="delete from khachhang where makh=?";
            PreparedStatement st=c.prepareStatement(sql);
            st.setString(1, t.getMaKhachHang() );
            System.out.println(sql);
            ketqua =st.executeUpdate();
            
            JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int deleteAll(ArrayList<khachhang> arr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(khachhang t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
