package CM.model;

public class ModelPhieuBaoHanh {
    
    private String maPBH;
    private String ngay;

    public ModelPhieuBaoHanh(String maPBH, String ngay) {
        this.maPBH = maPBH;
        this.ngay = ngay;
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
    
    
}
