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
public class hoadon {
    private String mahoadon;
    private String makhachhang;
    private double tongtien;
    private Date ngaytao;

    public hoadon() {
    }

    public hoadon(String mahoadon, String makhachhang, double tongtien, Date ngaytao) {
        this.mahoadon = mahoadon;
        this.makhachhang = makhachhang;
        this.tongtien = tongtien;
        this.ngaytao = ngaytao;
    }

    public String getMahoadon() {
        return mahoadon;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public double getTongtien() {
        return tongtien;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }
    
}
