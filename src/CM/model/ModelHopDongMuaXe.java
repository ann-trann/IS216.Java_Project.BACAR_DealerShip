package CM.model;

public class ModelHopDongMuaXe {
    
    private int maHDMX;
    private int maKH;
    private int maXE;
    private String ngay;
    private String triGia;
    private int maNV;

    public ModelHopDongMuaXe(int maHDMX, int maKH, int maXE, String ngay, String triGia, int maNV) {
        this.maHDMX = maHDMX;
        this.maKH = maKH;
        this.maXE = maXE;
        this.ngay = ngay;
        this.triGia = triGia;
        this.maNV = maNV;
    }
    
    public ModelHopDongMuaXe(int maHDMX, int maKH, int maXE, int maNV) {
        this.maHDMX = maHDMX;
        this.maKH = maKH;
        this.maXE = maXE;
        this.maNV = maNV;
    }

    public int getMaHDMX() {
        return maHDMX;
    }

    public void setMaHDMX(int maHDMX) {
        this.maHDMX = maHDMX;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaXE() {
        return maXE;
    }

    public void setMaXE(int maXE) {
        this.maXE = maXE;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getTriGia() {
        return triGia;
    }

    public void setTriGia(String triGia) {
        this.triGia = triGia;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
    
    
}
