package CM.model;

public class ModelCTHDSC {
    private int maHD;
    private int maPK;
    private int soLuong;

    public ModelCTHDSC(int maHD, int maPK, int soLuong) {
        this.maHD = maHD;
        this.maPK = maPK;
        this.soLuong = soLuong;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaPK() {
        return maPK;
    }

    public void setMaPK(int maPK) {
        this.maPK = maPK;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}
