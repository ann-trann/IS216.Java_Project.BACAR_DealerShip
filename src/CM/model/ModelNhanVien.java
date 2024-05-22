package CM.model;

public class ModelNhanVien {
    private int MaNV;
    private String tenNV;
    private String SDT;
    private String luong;
    private String chucVu;
    private String ngayVaoLam;
    private String trangThai;
    private String email;
    private String taiKhoan;
    private String matKhau;
    private int maNQL;
    
    public ModelNhanVien(int MaNV, String tenNV, String SDT, String luong, String chucVu, String ngayVaoLam, String trangThai, String email, String taiKhoan, String matKhau, int maNQL) {
        this.MaNV = MaNV;
        this.tenNV = tenNV;
        this.SDT = SDT;
        this.luong = luong;
        this.chucVu = chucVu;
        this.ngayVaoLam = ngayVaoLam;
        this.trangThai = trangThai;
        this.email = email;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.maNQL = maNQL;
    }
    
    public ModelNhanVien(int MaNV, String tenNV, String SDT, String luong, String chucVu, String trangThai, String email, String taiKhoan, String matKhau, int maNQL) {
        this.MaNV = MaNV;
        this.tenNV = tenNV;
        this.SDT = SDT;
        this.luong = luong;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
        this.email = email;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.maNQL = maNQL;
    }
    
    public ModelNhanVien(int MaNV, String tenNV, String SDT, String luong, String chucVu, String email, String taiKhoan, String matKhau, int maNQL) {
        this.MaNV = MaNV;
        this.tenNV = tenNV;
        this.SDT = SDT;
        this.luong = luong;
        this.chucVu = chucVu;
        this.email = email;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.maNQL = maNQL;
    }

    public int getMaNQL() {
        return maNQL;
    }

    public void setMaNQL(int maNQL) {
        this.maNQL = maNQL;
    }

    public ModelNhanVien() {
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    
}
