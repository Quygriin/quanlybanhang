package model;

public class sanpham {
    private String loaisp;
    private String masp;
    private String nhacungcap;
    private String tensp;
    private int soluong;
    private int gianhap;
    private int giaban;

    // Constructor mặc định
    public sanpham() {
    }

    // Constructor chính
    public sanpham(String loaisp, String masp, String nhacungcap, String tensp, int soluong, int gianhap, int giaban) {
       this.loaisp = loaisp;
       this.masp = masp;
       this.nhacungcap = nhacungcap;
       this.tensp = tensp;
       this.soluong = soluong;
       this.gianhap = gianhap;
       this.giaban = giaban;
    }

    // Getter methods
    public String getloaisp() {
        return loaisp;
    }

    public String getmasp() {
        return masp;
    }

    public String getnhacungcap() {
        return nhacungcap;
    }

    public String gettensp() {
        return tensp;
    }

    public int getsoluong() {
        return soluong;
    }

    public int getgianhap() {
        return gianhap;
    }

    public int getgiaban() {
        return giaban;
    }

    // Setter methods
    public void setloaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public void setmasp(String masp) {
        this.masp = masp;
    }

    public void setnhacungcap(String nhacungcap) {
        this.nhacungcap = nhacungcap;
    }

    public void settensp(String tensp) {
        this.tensp = tensp;
    }

    public void setsoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setgianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public void setgiaban(int giaban) {
        this.giaban = giaban;
    }
}
