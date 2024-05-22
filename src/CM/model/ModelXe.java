package CM.model;

import javax.swing.Icon;

public class ModelXe {

    public ModelXe(String tenXe, int soLuong, String Gia, Icon xeImg) {
        this.tenXe = tenXe;
        this.soLuong = soLuong;
        this.giaBan = Gia;
        this.xeImg = xeImg;
    }

    public ModelXe(int maXe, String tenXe, String loaiXe, String giaNhap, String giaBan, int soLuong, int thoiGianBH) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.loaiXe = loaiXe;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.thoiGianBH = thoiGianBH;
    }
    
    public ModelXe(String tenXe, String loaiXe, String giaNhap, String giaBan, int thoiGianBH, int maNV) {
        this.tenXe = tenXe;
        this.loaiXe = loaiXe;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.thoiGianBH = thoiGianBH;
        this.maNV = maNV;
    }

    public int getMaXe() {
        return maXe;
    }

    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public int getThoiGianBH() {
        return thoiGianBH;
    }

    public void setThoiGianBH(int thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Icon getXeImg() {
        return xeImg;
    }

    public void setXeImg(Icon xeImg) {
        this.xeImg = xeImg;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    private int maXe;
    private String tenXe;
    private String loaiXe;
    private int soLuong;
    private String giaNhap;
    private String giaBan;
    private int thoiGianBH;
    private int maNV;
    private String description;
    private Icon xeImg;
}
