package com.model;

import javax.swing.Icon;

public class ModelCar {

    public ModelCar(String tenXe, String trangThai, String Gia, Icon xeImg) {
        this.tenXe = tenXe;
        this.soLuong = trangThai;
        this.giaBan = Gia;
        this.xeImg = xeImg;
    }
    
    public ModelCar(String tenXe, String soLuong, String giaBan, String description, String giaNhap, int thoiGianBH, String NCC, Icon xeImg, String maXe, String loaiXe) {
        this.tenXe = tenXe;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.description = description;
        this.giaNhap = giaNhap;
        this.thoiGianBH = thoiGianBH;
        this.NCC = NCC;
        this.xeImg = xeImg;
        this.maXe = maXe;
        this.loaiXe = loaiXe;
    }
    

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public Icon getXeImg() {
        return xeImg;
    }

    public void setXeImg(Icon xeImg) {
        this.xeImg = xeImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getThoiGianBH() {
        return thoiGianBH;
    }

    public void setThoiGianBH(int thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    public String getNCC() {
        return NCC;
    }

    public void setNCC(String NCC) {
        this.NCC = NCC;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    
    private String tenXe;
    private String soLuong;
    private String giaBan;
    private String description;
    private String giaNhap;
    private int thoiGianBH;
    private String NCC;
    private Icon xeImg;
    private String maXe;
    private String loaiXe;
}
