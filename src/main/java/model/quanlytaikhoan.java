/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class quanlytaikhoan {
    private String tennguoidung;
    private String taikhoan;
    private String matkhau;
    private String email;
    private String sdt;

    public quanlytaikhoan() {
    }

    public quanlytaikhoan(String tennguoidung, String taikhoan, String matkhau, String email, String sdt) {
        this.tennguoidung = tennguoidung;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.email = email;
        this.sdt = sdt;
    }

    public String getTennguoidung() {
        return tennguoidung;
    }

    public void setTennguoidung(String tennguoidung) {
        this.tennguoidung = tennguoidung;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}
