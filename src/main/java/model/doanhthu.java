/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class doanhthu {
    private String madoanhthu;
    private Date ngaydoanhthu;
    private double tongtien;
    private String ghichu;

    public doanhthu() {
    }

    public doanhthu(String madoanhthu, Date ngaydoanhthu, double tongtien, String ghichu) {
        this.madoanhthu = madoanhthu;
        this.ngaydoanhthu = ngaydoanhthu;
        this.tongtien = tongtien;
        this.ghichu = ghichu;
    }

    public String getMadoanhthu() {
        return madoanhthu;
    }

    public Date getNgaydoanhthu() {
        return ngaydoanhthu;
    }

    public double getTongtien() {
        return tongtien;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setMadoanhthu(String madoanhthu) {
        this.madoanhthu = madoanhthu;
    }

    public void setNgaydoanhthu(Date ngaydoanhthu) {
        this.ngaydoanhthu = ngaydoanhthu;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
    
    
}
