package CM.model;

public class ModelHoaDonSuaChua {
    
    private int maHD;
    private int maLSC;
    private String maPBH;
    private String ngay;
    private String thanhTien;
    private int maNV;

    public ModelHoaDonSuaChua(int maHD, int maLSC, String maPBH, String ngay, String thanhTien, int maNV) {
        this.maHD = maHD;
        this.maLSC = maLSC;
        this.maPBH = maPBH;
        this.thanhTien = thanhTien;
        this.ngay = ngay;
        this.maNV = maNV;
    }
    
    public ModelHoaDonSuaChua(int maHD, int maLSC, String maPBH, String thanhTien, int maNV) {
        this.maHD = maHD;
        this.maLSC = maLSC;
        this.maPBH = maPBH;
        this.thanhTien = thanhTien;
        this.maNV = maNV;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaLSC() {
        return maLSC;
    }

    public void setMaLSC(int maLSC) {
        this.maLSC = maLSC;
    }

    public String getMaPBH() {
        return maPBH;
    }

    public void setMaPBH(String maPBH) {
        this.maPBH = maPBH;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(String thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
    
    
}
