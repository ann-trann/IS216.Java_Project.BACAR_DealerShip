package com.model;

public class ModelPhuKien {
    
    private String maPK;
    private String ngayNhap;
    private String tenPK;
    private String xuatSu;
    private int soLuong;
    private String giaBan;
    private String giaNhap;

    public ModelPhuKien(String maPK, String ngayNhap, String tenPK, String xuatSu, int soLuong, String donGia, String giaNhap) {
        this.maPK = maPK;
        this.ngayNhap = ngayNhap;
        this.tenPK = tenPK;
        this.xuatSu = xuatSu;
        this.soLuong = soLuong;
        this.giaBan = donGia;
        this.giaNhap = giaNhap;
    }

    public String getMaPK() {
        return maPK;
    }

    public void setMaPK(String maPK) {
        this.maPK = maPK;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getTenPK() {
        return tenPK;
    }

    public void setTenPK(String tenPK) {
        this.tenPK = tenPK;
    }

    public String getXuatSu() {
        return xuatSu;
    }

    public void setXuatSu(String xuatSu) {
        this.xuatSu = xuatSu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public String getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        this.giaNhap = giaNhap;
    }
    
}
