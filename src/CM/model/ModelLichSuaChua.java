package CM.model;

public class ModelLichSuaChua {
    
    private int maLSC;
    private int maKH;
    private int maXe;
    private String ngay;
    private int ca;
    private int maNV;
    private String trangThai;

    public ModelLichSuaChua(int maLSC, int maKH, int maXe, String ngay, int ca, int maNV, String trangThai) {
        this.maLSC = maLSC;
        this.maKH = maKH;
        this.maXe = maXe;
        this.ngay = ngay;
        this.ca = ca;
        this.maNV = maNV;
        this.trangThai = trangThai;
    }
    
    public ModelLichSuaChua(int maKH, int maXe, String ngay, int ca, int maNV) {
        this.maKH = maKH;
        this.maXe = maXe;
        this.ngay = ngay;
        this.ca = ca;
        this.maNV = maNV;
    }

    public ModelLichSuaChua() {
        
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaLSC() {
        return maLSC;
    }

    public void setMaLSC(int maLSC) {
        this.maLSC = maLSC;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaXe() {
        return maXe;
    }

    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
    
    
}
