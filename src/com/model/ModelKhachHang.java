package com.model;

import java.util.List;

public class ModelKhachHang {
    private String maKH;
    private String nameKH;
    private String loaiKH;
    private List<ModelCar> xeDaMua;

    public ModelKhachHang(String maKH, String nameKH, String loaiKH, List<ModelCar> xeDaMua) {
        this.maKH = maKH;
        this.nameKH = nameKH;
        this.loaiKH = loaiKH;
        this.xeDaMua = xeDaMua;
    }

    public ModelKhachHang() {
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getNameKH() {
        return nameKH;
    }

    public void setNameKH(String nameKH) {
        this.nameKH = nameKH;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(String loaiKH) {
        this.loaiKH = loaiKH;
    }

    public List<ModelCar> getXeDaMua() {
        return xeDaMua;
    }

    public void setXeDaMua(List<ModelCar> xeDaMua) {
        this.xeDaMua = xeDaMua;
    }
    
}
