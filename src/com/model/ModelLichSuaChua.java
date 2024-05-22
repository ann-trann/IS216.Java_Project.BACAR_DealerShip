package com.model;

public class ModelLichSuaChua {
    private String ngaySua;
    private String ca;
    private String maLCS;
    private String trangThai;

    public ModelLichSuaChua(String ngaySua, String ca, String maLCS, String trangThai) {
        this.ngaySua = ngaySua;
        this.ca = ca;
        this.maLCS = maLCS;
        this.trangThai = trangThai;
    }

    public ModelLichSuaChua() {
    }

    public String getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(String ngaySua) {
        this.ngaySua = ngaySua;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getMaLCS() {
        return maLCS;
    }

    public void setMaLCS(String maLCS) {
        this.maLCS = maLCS;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
