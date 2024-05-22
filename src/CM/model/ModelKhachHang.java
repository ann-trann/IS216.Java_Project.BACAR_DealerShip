package CM.model;

import java.util.List;

public class ModelKhachHang {
    
    private int maKH;
    private String tenKH;
    private String soDT;
    private String loaiKH;

    public ModelKhachHang(int maKH, String tenKH, String soDT, String loaiKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.soDT = soDT;
        this.loaiKH = loaiKH;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(String loaiKH) {
        this.loaiKH = loaiKH;
    }
    
}
