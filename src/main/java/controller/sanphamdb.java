package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.sanpham;

public class sanphamdb implements dbInterface<sanpham> {

    @Override
    public ArrayList<sanpham> selectAll() {
        ArrayList<sanpham> ketqua = new ArrayList<>();
        try {
            Connection c = JDBC.getConnection();
            String sql = "SELECT * FROM sanpham";
            PreparedStatement st = c.prepareStatement(sql);

            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String maSp = rs.getString("masanpham");
                String tenSp = rs.getString("tensanpham");
                String loaiSp = rs.getString("loaisanpham");
                String nhaCungCap = rs.getString("nhasanxuat");
                int soluong = rs.getInt("soluong");
                int gianhap = rs.getInt("gianhap");
                int giaban = rs.getInt("giaban");

                sanpham spham = new sanpham(loaiSp, maSp, nhaCungCap, tenSp, soluong, gianhap, giaban);
                ketqua.add(spham);
            }
            JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public sanpham selectById(sanpham t) {
        sanpham ketqua = null;
        try {
            Connection c = JDBC.getConnection();
            String sql = "SELECT * FROM sanpham where masanpham=?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, t.getmasp());

            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                 String maSp = rs.getString("masanpham");
                String tenSp = rs.getString("tensanpham");
                String loaiSp = rs.getString("loaisanpham");
                String nhaCungCap = rs.getString("nhasanxuat");
                int soluong = rs.getInt("soluong");
                int gianhap = rs.getInt("gianhap");
                int giaban = rs.getInt("giaban");

                ketqua = new sanpham(loaiSp, maSp, nhaCungCap, tenSp, soluong, gianhap, giaban);
            }
            JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int insert(sanpham t) {
        int ketqua = 0;
        try {
            Connection c = JDBC.getConnection();

            String sql = "INSERT INTO sanpham(masanpham, loaisanpham,  tensanpham, nhasanxuat,soluong, gianhap, giaban) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, t.getmasp());
            st.setString(2, t.getloaisp());
            st.setString(3, t.gettensp());
            st.setString(4, t.getnhacungcap());
            st.setInt(5, t.getsoluong());
            st.setInt(6, t.getgianhap());
            st.setInt(7, t.getgiaban());

            ketqua = st.executeUpdate();
            System.out.println(sql);
            JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
public int update(sanpham t) {
    int ketqua = 0;
    try {
        Connection c = JDBC.getConnection();
        if (c == null) {
            System.out.println("Kết nối thất bại.");
            return ketqua;
        }
        System.out.println("Connected to database.");

        String sql = "UPDATE sanpham SET loaisanpham=?, nhasanxuat=?, tensanpham=?, soluong=?, gianhap=?, giaban=? WHERE masanpham=?";
        PreparedStatement st = c.prepareStatement(sql);

        // Gán các giá trị
        st.setString(1, t.getloaisp());
        st.setString(2, t.getnhacungcap());
        st.setString(3, t.gettensp());
        st.setInt(4, t.getsoluong());
        st.setInt(5, t.getgianhap());
        st.setInt(6, t.getgiaban());
        st.setString(7, t.getmasp()); // Đảm bảo `t.getmasp()` trả về đúng mã sản phẩm

        // Kiểm tra dữ liệu đầu vào
        System.out.println("SQL Query: " + sql);
        System.out.println("Loại SP: " + t.getloaisp());
        System.out.println("Nhà Cung Cấp: " + t.getnhacungcap());
        System.out.println("Tên SP: " + t.gettensp());
        System.out.println("Số Lượng: " + t.getsoluong());
        System.out.println("Giá Nhập: " + t.getgianhap());
        System.out.println("Giá Bán: " + t.getgiaban());
        System.out.println("Mã SP: " + t.getmasp());

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
    public int delete(sanpham t) {
        int ketqua = 0;
        try {
            Connection c = JDBC.getConnection();

            String sql = "DELETE FROM sanpham WHERE masanpham=?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, t.getmasp());

            System.out.println(sql);
            ketqua = st.executeUpdate();

            JDBC.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    // Các phương thức chưa hỗ trợ
    @Override
    public int insertAll(ArrayList<sanpham> arr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int deleteAll(ArrayList<sanpham> arr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
