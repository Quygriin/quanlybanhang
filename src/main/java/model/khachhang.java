/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

public class khachhang {
	    private String maKhachHang;
	    private String tenkh;
	    private Date ngaySinh;
	    private String gioiTinh;
	    private String email;
	    private String diaChi;
	    private String soDienThoai;
	    private String loaiKhachHang;
	    private String ghiChu;
		public khachhang() {
			
		}
		public khachhang(String maKhachHang, String tenkh, Date ngaySinh, String gioiTinh, String email, String diaChi,
				String soDienThoai, String loaiKhachHang, String ghiChu) {
			super();
			this.maKhachHang = maKhachHang;
			this.tenkh = tenkh;
			this.ngaySinh = ngaySinh;
			this.gioiTinh = gioiTinh;
			this.email = email;
			this.diaChi = diaChi;
			this.soDienThoai = soDienThoai;
			this.loaiKhachHang = loaiKhachHang;
			this.ghiChu = ghiChu;
		}
		public String getMaKhachHang() {
			return maKhachHang;
		}
		public void setMaKhachHang(String maKhachHang) {
			this.maKhachHang = maKhachHang;
		}
		public String getTenkh() {
			return tenkh;
		}
		public void setTenkh(String hoTen) {
			this.tenkh = hoTen;
		}
		public Date getNgaySinh() {
			return ngaySinh;
		}
		public void setNgaySinh(Date ngaySinh) {
			this.ngaySinh = ngaySinh;
		}
		public String getGioiTinh() {
			return gioiTinh;
		}
		public void setGioiTinh(String gioiTinh) {
			this.gioiTinh = gioiTinh;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getDiaChi() {
			return diaChi;
		}
		public void setDiaChi(String diaChi) {
			this.diaChi = diaChi;
		}
		public String getSoDienThoai() {
			return soDienThoai;
		}
		public void setSoDienThoai(String soDienThoai) {
			this.soDienThoai = soDienThoai;
		}
		public String getLoaiKhachHang() {
			return loaiKhachHang;
		}
		public void setLoaiKhachHang(String loaiKhachHang) {
			this.loaiKhachHang = loaiKhachHang;
		}
		public String getGhiChu() {
			return ghiChu;
		}
		public void setGhiChu(String ghiChu) {
			this.ghiChu = ghiChu;
		}
	
	    
}