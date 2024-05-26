package CM.controller.service;

import CM.controller.connection.DatabaseConnection;
import CM.model.ModelCTHDSC;
import CM.model.ModelHoaDonSuaChua;
import CM.model.ModelHopDongMuaXe;
import CM.model.ModelKhachHang;
import CM.model.ModelLichSuaChua;
import CM.model.ModelNhanVien;
import CM.model.ModelPhieuBaoHanh;
import CM.model.ModelPhuKien;
import CM.model.ModelXe;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;

public class Service {
    
    private final Connection con;

    //Connect tới DataBase       
    public Service() throws SQLException {
        con = DatabaseConnection.getInstance().getConnection();
    }
    
    //Lấy toàn bộ danh sách dòng xe
    public ArrayList<ModelXe> getListXe() throws SQLException{
        ArrayList<ModelXe> list = new ArrayList<ModelXe>();
        String sql = "SELECT MADX, TENDONGXE, LOAIXE, GIANHAP, GIABAN, SOLUONG, THOIGIANBAOHANH FROM DONGXE";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            int maXe = r.getInt(1);
            String tenXe = r.getString(2);
            String loaiXe = r.getString(3);
            String giaNhap = r.getString(4);
            String giaBan = r.getString(5);
            int soLuong = r.getInt(6);
            int tgbh = r.getInt(7);
            
            ModelXe data = new ModelXe(maXe, tenXe, loaiXe, giaNhap, giaBan, soLuong, tgbh);
            list.add(data);
        }
        p.close();
        r.close();
        return list;
    }
    
    // Lấy maXe tiếp theo
    public int getMaXe_Next() throws SQLException{
        int id_next = 0;
        String sql = "SELECT MAX(maXe) FROM Xe";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            id_next = r.getInt(1);
        }
        p.close();
        r.close();
        return id_next + 1;
    }
    
    // Lấy maDX tiếp theo
    public int getMaDX_Next() throws SQLException{
        int id_next = 0;
        String sql = "SELECT MAX(maDX) FROM DONGXE";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            id_next = r.getInt(1);
        }
        p.close();
        r.close();
        return id_next + 1;
    }
    
    // Thêm 1 xe vào kho
    public void insertXe(ModelXe data) throws SQLException{
        String sql;
        PreparedStatement p;
        if (data.getMaXe() == 0){
            int maDX = this.getMaDX_Next();
            data.setMaXe(maDX);
            sql = "Insert into DongXe(maDX, tendongxe, loaixe, gianhap, giaban, thoigianbaohanh) values (?, ?, ?, ?, ?, ?)";
            p = con.prepareStatement(sql);
            p.setInt(1, maDX);
            p.setString(2, data.getTenXe());
            p.setString(3, data.getLoaiXe());
            p.setLong(4, Long.valueOf(data.getGiaNhap()));
            p.setLong(5, Long.valueOf(data.getGiaBan()));
            p.setInt(6, data.getThoiGianBH());
            p.execute();
        }
        System.out.println(data.getMaX() + " " + data.getMaXe() +  " " + data.getMaNV());
        sql = "Insert into Xe(MaXe, MaDX, MaNV) VALUES (?, ?, ?)";
        p = con.prepareStatement(sql);
        p.setInt(1, data.getMaX());
        p.setInt(2, data.getMaXe());
        p.setInt(3, data.getMaNV());
        p.execute();
        p.close();
    }
    
    // Lấy maXe nhỏ nhất của 1 MaDX đang có trong kho
    public int getMaXe_Min(int MaDX) throws SQLException{
        int id_min = 0;
        String sql = "SELECT MIN(MaXe) FROM XE X JOIN DONGXE D ON X.MADX = D.MADX"
                + " WHERE X.TRANGTHAI = 'Trong kho' AND X.MADX = ?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, MaDX);
        ResultSet r = p.executeQuery();
        while (r.next()){
            id_min = r.getInt(1);
        }
        p.close();
        r.close();
        return id_min;
    }
    
    // Cập nhật thông tin xe nhất định
    public void updateDongXe(ModelXe data) throws SQLException{
        String sql = "UPDATE DONGXE SET TENDONGXE = ?, LOAIXE = ?, GIANHAP = ?, GIABAN = ?, THOIGIANBAOHANH = ?"
                + "WHERE MADX = ?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, data.getTenXe());
        p.setString(2, data.getLoaiXe());
        p.setLong(3, Long.valueOf(data.getGiaNhap()));
        p.setLong(4, Long.valueOf(data.getGiaBan()));
        p.setInt(5, data.getThoiGianBH());
        p.setInt(6, data.getMaXe());
        
        p.execute();
        p.close();        
    }
    
    // Bán xe, chuyển đổi từ trong kho thành đã bán
    public void SellXe(int maDX) throws SQLException{
        int maXe = this.getMaXe_Min(maDX);
        String sql = "UPDATE XE SET TRANGTHAI = 'Da ban' WHERE MAXE = ?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, maXe);
        p.execute();
        p.close();
    }
    
    // Lấy danh sách xe còn trong kho
    public ArrayList<ModelXe> getListXeTrongKho() throws SQLException{
        ArrayList<ModelXe> list = new ArrayList<ModelXe>();
        String sql = "SELECT MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, SoLuong, ThoiGianBaoHanh"
                + " FROM DONGXE "
                + " WHERE SoLuong > 0";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            int MaDX = r.getInt(1);
            String tenXe = r.getString(2);
            String loaiXe = r.getString(3);
            String giaNhap = String.valueOf(r.getLong(4));
            String giaBan = String.valueOf(r.getLong(5));
            int soLuong = r.getInt(6);
            int tgbh = r.getInt(6);
            ModelXe data = new ModelXe(MaDX, tenXe, loaiXe, giaNhap, giaBan, soLuong, tgbh);
            list.add(data);
        }
        p.close();
        r.close();
        return list;
    }
    
    // Lấy toàn bộ danh sách PhuKien
    public ArrayList<ModelPhuKien> getListPhuKien() throws SQLException{
        ArrayList<ModelPhuKien> list = new ArrayList<ModelPhuKien>();
        String sql = "Select MaPK, TenPK, XuatXu, SoLuong, GiaNhap, GiaBan FROM PHUKIEN";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            int maPK = r.getInt(1);
            String tenPK = r.getString(2);
            String xuatXu = r.getString(3);
            int soLuong = r.getInt(4);
            String giaNhap = String.valueOf(r.getLong(5));
            String giaBan = String.valueOf(r.getLong(6));
            
            ModelPhuKien data = new ModelPhuKien(maPK, tenPK, xuatXu, soLuong, giaNhap, giaBan);
            list.add(data);
        }
        p.close();
        r.close();
        return list;
    }
    
    // Lấy mã phụ kiện tiếp theo
    public int getMaPK_Next() throws SQLException{
        int id_next = 0;
        String sql = "SELECT MAX(MaPK) FROM PHUKIEN";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            id_next = r.getInt(1);
        }
        p.close();
        r.close();
        return id_next + 1;
    }
    
    // Thêm phụ kiện
    public void insertPhuKien(ModelPhuKien data) throws SQLException{
        
        String sql = "INSERT INTO PHUKIEN(MaPK, TenPK, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, this.getMaPK_Next());
        p.setString(2, data.getTenPK());
        p.setString(3, data.getXuatXu());
        p.setInt(4, data.getSoLuong());
        p.setLong(5, Long.valueOf(data.getGiaNhap()));
        p.setLong(6, Long.valueOf(data.getGiaBan()));
        p.execute();
    }
    
    // Lấy phụ kiện từ MaPK
    public ModelPhuKien getPhuKien(int MaPK) throws SQLException{
        ModelPhuKien data = null;
        String sql = "SELECT MAPK, TenPK, XuatXu, SoLuong, GiaNhap, GiaBan FROM PHUKIEN"
                + "WHERE MaPK = ?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, MaPK);
        ResultSet r = p.executeQuery();
        while (r.next()){
            String tenPK = r.getString(1);
            String xuatXu = r.getString(2);
            int soLuong = r.getInt(3);
            String giaNhap = String.valueOf(r.getLong(4));
            String giaBan = String.valueOf(r.getLong(5));
            
            data = new ModelPhuKien(MaPK, tenPK, xuatXu, soLuong, giaNhap, giaBan);
        }
        p.close();
        r.close();
        return data;
    }
    
    // Sửa phụ kiện
    public void updatePhuKien(ModelPhuKien data) throws SQLException{
        String sql = "Update PhuKien SET TenPK = ?, XuatXu = ?, SoLuong = ?, GiaNhap = ?, GiaBan = ?"
                + "WHERE MaPK = ?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, data.getTenPK());
        p.setString(2, data.getXuatXu());
        p.setInt(3, data.getSoLuong());
        p.setLong(4, Long.valueOf(data.getGiaNhap()));
        p.setLong(5, Long.valueOf(data.getGiaBan()));
        p.setInt(6, data.getMaPK());
        p.execute();
        p.close();
    }
    
    // Lấy toàn bộ lịch sửa chữa
    public ArrayList<ModelLichSuaChua> getListLSC() throws SQLException{
        ArrayList<ModelLichSuaChua> list = new ArrayList<ModelLichSuaChua>();
        String sql = "SELECT MaLSC, MaKH, MaXe, TO_CHAR(Ngay, 'dd-mm-yyyy'), Ca, MaNV, trangThai FROM LICHSUACHUA ORDER BY TRANGTHAI ASC, Ngay DESC";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            int maLSC = r.getInt(1);
            int maKH = r.getInt(2);
            int maXe = r.getInt(3);
            String ngay = r.getString(4);
            int ca = r.getInt(5);
            int maNV =r.getInt(6);
            String trangThai = r.getString(7);
            
            ModelLichSuaChua data = new ModelLichSuaChua(maLSC, maKH, maXe, ngay, ca, maNV, trangThai);
            list.add(data);
        }
        p.close();
        r.close();
        return list;
    }
    
    // Lấy MaLSC tiếp theo
    public int getMaLSC_next() throws SQLException{
        int id_next = 0;
        String sql = "SELECT MIN(MaLSC) + 1 FROM LICHSUACHUA "
                + "WHERE MaLSC + 1 NOT IN (SELECT MALSC FROM LICHSUACHUA)";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            id_next = r.getInt(1);
        }
        return id_next;
    }
    
    // Thêm lịch sửa chữa
    public void insertLSC(ModelLichSuaChua data) throws SQLException{
        String sql = "INSERT INTO LICHSUACHUA(MALSC, MaKH, MaXe, Ngay, Ca, MaNV) VALUES(?, ?, ?, TO_DATE(?, 'dd-mm-yyyy'), ?, ?)";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, data.getMaLSC());
        p.setInt(2, data.getMaKH());
        p.setInt(3, data.getMaXe());
        p.setString(4, data.getNgay());
        p.setInt(5, data.getCa());
        p.setInt(6, data.getMaNV());
        p.execute();
        p.close();
    }
    
    //Tìm kiếm ca đó đã được đặt bao nhiêu lần
    public boolean checkLSC(String ca, String ngay) throws SQLException{
        int cnt = 0;
        String sql = "SELECT COUNT(*) FROM LICHSUACHUA "
                + "WHERE Ca = ? AND NGAY = TO_DATE(?, 'dd-mm-yyyy')";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, Integer.parseInt(ca));
        p.setString(2, ngay);
        ResultSet r = p.executeQuery();
        
        while (r.next()){
            cnt = r.getInt(1);
        }
        r.close();
        p.close();
        System.out.println(cnt);
        return (cnt >= 2);
    }
    
    // Sửa lịch sửa chữa
    public void updateLSC(ModelLichSuaChua data) throws SQLException{
        String sql = "UPDATE LICHSUACHUA SET MaKH = ?, MaXe = ?, Ngay = TO_DATE(?, 'dd-mm-yyyy'), Ca = ?, MaNV = ? "
                + "WHERE MALSC = ?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, data.getMaKH());
        p.setInt(2, data.getMaXe());
        p.setString(3, data.getNgay());
        p.setInt(4, data.getCa());
        p.setInt(5, data.getMaNV());
        p.setInt(6, data.getMaLSC());
        p.execute();
        p.close();
    }        
    
    // Xóa lịch sửa chữa
    public void deleteLSC(ModelLichSuaChua data) throws SQLException{
        String sql = "DELETE FROM LICHSUACHUA WHERE MALSC = ?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, data.getMaLSC());
        p.execute();
        p.close();
    }
    
    // Lấy lịch sửa chữa từ mã lịch sửa chữa
    public ModelLichSuaChua getLSCFromID(int MaLSC) throws SQLException{
        ModelLichSuaChua data = null;
        String sql = "SELECT MaLSC, MaKH, MaXe, Ngay, Ca, MaNV, trangThai FROM LICHSUACHUA";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            int maLSC = r.getInt(1);
            int maKH = r.getInt(2);
            int maXe = r.getInt(3);
            String ngay = r.getString(4);
            int ca = r.getInt(5);
            int maNV =r.getInt(6);
            String trangThai = r.getString(7);
            
            data = new ModelLichSuaChua(maLSC, maKH, maXe, ngay, ca, maNV, trangThai);
        }
        p.close();
        r.close();
        return data;
    }
    
    public ArrayList<ModelHoaDonSuaChua> listHDSC() throws SQLException{
        ArrayList<ModelHoaDonSuaChua> list = new ArrayList<ModelHoaDonSuaChua>();
        String sql = "SELECT MAHD, MALSC, MAPBH, TO_CHAR(NGAYTRAXE, 'dd-mm-yyyy'), THANHTIEN, MANV FROM HOADONSUACHUA";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            int maHD = r.getInt(1);
            int maLSC = r.getInt(2);
            String maPBH = r.getString(3);
            String ngay = r.getString(4);
            String thanhTien = String.valueOf(r.getLong(5));
            int maNV  = r.getInt(6);
            
            ModelHoaDonSuaChua data = new ModelHoaDonSuaChua(maHD, maLSC, maPBH, ngay, thanhTien, maNV);
            list.add(data);
        }
        p.close();
        r.close();
        return list;
    }
    
    // Lấy maHDSC tiếp theo
    public int getMaHDSC_next() throws SQLException{
        int id_next = 0;
        String sql = "SELECT MAX(MAHD) FROM HOADONSUACHUA";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            id_next = r.getInt(1);
        }
        p.close();
        r.close();
        return id_next + 1;
    }
    
    public boolean checkHDSC_AToB(String dateStart, String dateEnd) throws SQLException {
        boolean check = false; // Default to false and set to true if a record is found
        String sql = "SELECT MAHD, MALSC, NGAYTRAXE, THANHTIEN, MANV FROM HOADONSUACHUA "
                   + "WHERE NGAYTRAXE <= TO_DATE(?, 'dd-mm-yyyy') AND NGAYTRAXE >= TO_DATE(?, 'dd-mm-yyyy')";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, dateEnd);
        p.setString(2, dateStart);
        ResultSet r = p.executeQuery();
        if (r.next()){ // Check if there is at least one result
            check = true;
        }
        p.close();
        r.close();
        return check;
    }
    
    public ArrayList<ModelHoaDonSuaChua> listHDSC_AToB(String dateStart, String dateEnd) throws SQLException {
        ArrayList<ModelHoaDonSuaChua> list = new ArrayList<ModelHoaDonSuaChua>();
        String sql = "SELECT MAHD, MALSC, maPBH, TO_CHAR(NGAYTRAXE, 'dd-mm-yyyy'), THANHTIEN, MANV FROM HOADONSUACHUA "
                   + "WHERE NGAYTRAXE <= TO_DATE(?, 'dd-mm-yyyy') AND NGAYTRAXE >= TO_DATE(?, 'dd-mm-yyyy')";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, dateEnd);
        p.setString(2, dateStart);
        ResultSet r = p.executeQuery();
        while (r.next()){
            int maHD = r.getInt(1);
            int maLSC = r.getInt(2);
            String maPBH = r.getString(3);
            String ngay = r.getString(4);
            String thanhTien = String.valueOf(r.getLong(5));
            int maNV  = r.getInt(6);

            ModelHoaDonSuaChua data = new ModelHoaDonSuaChua(maHD, maLSC, maPBH, ngay, thanhTien, maNV);
            list.add(data);
        }
        p.close();
        r.close();
        return list;
    }


    
    // Tạo 1 HOADONSUACHUA
    public void insertHDSC(ModelHoaDonSuaChua data) throws SQLException{
        String sql;
        PreparedStatement p;
        if (data.getMaPBH() == null){
            sql = "INSERT INTO HOADONSUACHUA(MAHD, MALSC, MANV) VALUES (?, ?,  ?)";
            p = con.prepareStatement(sql);
            p.setInt(1, data.getMaHD());
            p.setInt(2, data.getMaLSC());
            p.setInt(3, data.getMaNV());
        } else {
            sql = "INSERT INTO HOADONSUACHUA(MAHD, MALSC, MAPBH, MANV) VALUES (?, ?, ?,  ?)";
            p = con.prepareStatement(sql);
            p.setInt(1, data.getMaHD());
            p.setInt(2, data.getMaLSC());
            p.setString(3, data.getMaPBH());
            p.setInt(4, data.getMaNV());
        }
        p.execute();
        p.close();
    }
    
    // Thêm CTHDSC vào HDSC
    public void insertHDSC(int MaHD, int MaPK, int SoLuong) throws SQLException{
        String sql = "INSERT INTO ChiTietHDSC(MaHD, MaPK, SoLuong) VALUES (?, ?, ?)";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, MaHD);
        p.setInt(2, MaPK);
        p.setInt(3, SoLuong);
        p.execute();
        p.close();
    }
    
    //Sửa CTHDSC 
    public void updateHDSC(int MaHD, int MaPK, int SoLuong) throws SQLException{
        String sql = "UPDATE ChiTietHDSC SET MaPK = ?, SoLuong = ? WHERE MaHD = ?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, MaPK);
        p.setInt(2, SoLuong);
        p.setInt(3, MaHD);
        p.execute();
        p.close();
    }
    
    // Xóa CTHDSC
    public void deleteHDSC(int MaHD, int MaPK) throws SQLException{
        String sql = "DELETE FROM CHiTietHDSC WHERE MaPK = ? AND MaHD = ?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, MaPK);
        p.setInt(2, MaHD);
        p.execute();
        p.close();
    }
    
    // Lấy toàn bộ CTHDSC với mỗi MaHD
    public ArrayList<ModelCTHDSC> getListCTHDSC(int MaHD) throws SQLException{
        ArrayList<ModelCTHDSC> list = new ArrayList<ModelCTHDSC>();
        String sql = "Select MaPK, SoLuong FROM ChiTIetHDSC WHERE MaHD = ?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, MaHD);
        ResultSet r = p.executeQuery();
        while (r.next()){
            int MaPK = r.getInt(1);
            int SoLuong = r.getInt(2);
            
            ModelCTHDSC data = new ModelCTHDSC(MaHD, MaPK, SoLuong);
            list.add(data);
        }
        p.close();
        r.close();
        return list;    
    }
    
    // Lấy Mã Hợp đồng bán xe tiếp theo
    public int getMaHDBX_next() throws SQLException{
        int id_next = 0;
        String sql = "Select MAx(MaHDMX) FROM HOPDONGMUAXE";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while(r.next()){
            id_next = r.getInt(1);
        }
        p.close();
        r.close();
        return id_next + 1;
    }
    
    // Tạo hợp đồng
    public void insertHDBX(ModelHopDongMuaXe data) throws SQLException{
        String sql = "INSERT INTO HOPDONGMUAXE(MaHDMX, MaKH, MaXe, MaNV) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, data.getMaHDMX());
        System.out.println("\n" +data.getMaHDMX() + " " + data.getMaKH() + " " + data.getMaXE() + " " + data.getMaNV());
        p.setInt(2, data.getMaKH());
        p.setInt(3, data.getMaXE());
        p.setInt(4, data.getMaNV());
        p.execute();
        p.close();
    }
    
    //Lấy tên khách hàng thông qua mã KH
    public String getKH(int maKH) throws SQLException{
        String tenKH = "";
        String sql = "Select tenKH from KhachHang WHERE MaKH = ?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, maKH);
        ResultSet r = p.executeQuery();
        while (r.next()){
            tenKH = r.getString(1);
        }
        p.close();
        r.close();
        return tenKH;
    }
    
    //Lấy SDT khách hàng thông qua mã
    public String getKH_SDT(int maKH) throws SQLException{
        String SDT = "";
        String sql = "Select SDT from KhachHang WHERE MaKH = ?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, maKH);
        ResultSet r = p.executeQuery();
        while (r.next()){
            SDT = r.getString(1);
        }
        p.close();
        r.close();
        return SDT;
    }
    
    // Lấy danh sách các nhân viên
    public ArrayList<ModelNhanVien> getListNV() throws SQLException{
        ArrayList<ModelNhanVien> list = new ArrayList<ModelNhanVien>();
        String sql = "Select MaNV, TenNV, SDT, Luong, ChucVu, TO_CHAR(NgayVaoLam,'dd-mm-yyyy'), TrangThai, Email, TaiKhoan, MatKhau, Ma_NQL "
                + "FROM NHANVIEN";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            int maNV = r.getInt(1);
            String tenNV = r.getString(2);
            String SDT = r.getString(3);
            String luong = String.valueOf(r.getLong(4));
            String chucVu = r.getString(5);
            String ngayvl = r.getString(6);
            String trangThai = r.getString(7);
            String email = r.getString(8);
            String taiKhoan = r.getString(9);
            String matKhau = r.getString(10);
            int manql = r.getInt(11);
            
            ModelNhanVien data = new ModelNhanVien(maNV, tenNV, SDT, luong, chucVu, ngayvl, trangThai, email, taiKhoan, matKhau, manql);
            list.add(data);
        }
        p.close();
        r.close();
        return list;
    }
    
    // Lấy danh sách khách hàng
    public ArrayList<ModelKhachHang> getListKH() throws SQLException{
        ArrayList<ModelKhachHang> list = new ArrayList<ModelKhachHang>();
        String sql = "SELECT MAKH, TenKH, SDT, LoaiKH FROM KHACHHANG ORDER BY MAKH";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            int maKh = r.getInt(1);
            String tenKH = r.getString(2);
            String SDT = r.getString(3);
            String loaiKH = r.getString(4);
            ModelKhachHang data = new ModelKhachHang(maKh, tenKH, SDT, loaiKH);
            list.add(data);
        }
        p.close();
        r.close();
        return list;
    }
    
    //Lấy mã khách hàng tiếp theo
    public int getMaKH_next() throws SQLException {
        int id_next = 0;
        String sql = "SELECT MAX(MaKH) FROM KHACHHANG";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            id_next = r.getInt(1);
        }
        p.close();
        r.close();
        return id_next + 1;
    }
    
    //Thêm khách hàng vào DB
    public void insertKH(ModelKhachHang data) throws SQLException{
        String sql = "INSERT INTO KHACHHANG(MAKH, TENKH, SDT) VALUES (?, ?, ?)";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, data.getMaKH());
        p.setString(2, data.getTenKH());
        p.setString(3, data.getSoDT());
        p.execute();
        p.close();
    }
    
    // Lấy mã nhân viên tiếp theo
    public int getMaNV_next() throws SQLException{
        int id_next = 0;
        String sql = "SELECT MAX(MANV) FROM NHANVIEN";
        
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            id_next = r.getInt(1);
        }
        r.close();
        p.close();
        return id_next + 1;
    }
    
    // Thêm một nhân viên
    public void insertNV(ModelNhanVien data) throws SQLException{
        String sql = "insert into nhanvien(manv, tennv, sdt, luong, chucvu, taikhoan, matkhau, email, ma_nql) values (?, ?, ?, ?, ?, ?, ?, ?,?)";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, data.getMaNV());
        p.setString(2, data.getTenNV());
        p.setString(3, data.getSDT());
        p.setLong(4, Long.parseLong(data.getLuong()));
        p.setString(5, data.getChucVu());
        p.setString(6, data.getTaiKhoan());
        p.setString(7, data.getMatKhau());
        p.setString(8, data.getEmail());
        p.setInt(9, data.getMaNQL());
        p.execute();
    }
    
    // Cập nhật 1 nhân viên
    public void updateNV(ModelNhanVien data) throws SQLException{
        String sql = "Update nhanvien set tennv = ?, sdt = ?, luong = ?, chucvu = ?, taikhoan = ?, matkhau = ?, email = ?, ma_nql = ?, trangthai = ?"
                + " WHERE manv = ?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(10, data.getMaNV());
        p.setString(1, data.getTenNV());
        p.setString(2, data.getSDT());
        p.setLong(3, Long.parseLong(data.getLuong()));
        p.setString(4, data.getChucVu());
        p.setString(5, data.getTaiKhoan());
        p.setString(6, data.getMatKhau());
        p.setString(7, data.getEmail());
        p.setInt(8, data.getMaNQL());
        p.setString(9, data.getTrangThai());
        p.execute();
        p.close();
    }
    
    public ArrayList<ModelPhieuBaoHanh> getListPBH() throws SQLException{
        ArrayList<ModelPhieuBaoHanh> list = new ArrayList<ModelPhieuBaoHanh>();
        String sql = "SELECT MAPBH, TO_CHAR(THOIHANBAOHANH, 'ddMMyyyy') FROM PHIEUBAOHANH";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            String maPBH = r.getString(1);
            String ngay = r.getString(2);
            ModelPhieuBaoHanh data = new ModelPhieuBaoHanh(maPBH, ngay);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }
    
    public boolean checkPBHDate(ModelPhieuBaoHanh data) throws SQLException {
        String sql = "{? = call FC_KIEMTRA_THOIHAN(?)}"; 
        CallableStatement c = con.prepareCall(sql);
        c.registerOutParameter(1, Types.NUMERIC);
        c.setString(2, data.getMaPBH());
        c.execute();
        int kq = c.getInt(1);
        System.out.println(kq);
        return kq == 1;
            
        
    }
    
    //Kiểm tra 1 phiếu bảo hành có đúng với xe đó không
    public boolean checkPBHXE(ModelPhieuBaoHanh data, int maXe) throws SQLException {
        String sql = "SELECT MaXe, MaPBH FROM HOPDONGMUAXE";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            if (data.getMaPBH().equals(r.getString(2)) && r.getInt(1) == maXe){
                p.close();
                r.close();
                return true;
            }
        }
        p.close();
        r.close();
        return false;
    }
    
    // THêm vào chi tiết hóa đơn sửa chữa
    public void insertCTHDSC(ModelCTHDSC data) throws SQLException{
        String sql = "Insert into CHITIETHDSC(MaHD, MaPK, SOLuong) VALUES (?, ?, ?)";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, data.getMaHD());
        p.setInt(2, data.getMaPK());
        p.setInt(3, data.getSoLuong());
        p.execute();
        p.close();
    }
    
    // Lấy ngày hiện tại
    public String getCurrentDate() throws SQLException{
        String sql = "{? = call GET_CURRENTDATE()}";
        CallableStatement c = con.prepareCall(sql);
        c.registerOutParameter(1, Types.VARCHAR);
        c.execute();
        String date = c.getString(1);
        c.close();
        return date;
    }
    
    // So sanh 2 ngày
    public boolean compair2date(String str1, String str2) throws SQLException{
        String sql = "{? = call COMPAIR_2DATE(TO_DATE(?, 'dd-mm-yyyy'), TO_DATE(?, 'dd-mm-yyyy'))}";
        CallableStatement c = con.prepareCall(sql);
        c.registerOutParameter(1, Types.NUMERIC);
        c.setString(2, str1);
        c.setString(3, str2);
        c.execute();
        int kq = c.getInt(1);
        return kq == 1;
    }
    
    // Tính doanh thu 1 tháng nhất định
    public long getDoanhThu(int month) throws SQLException{
        String sql = "{? = call FC_DOANHTHU_THEOTHANG(?)}";
        CallableStatement c = con.prepareCall(sql);
        c.registerOutParameter(1, Types.INTEGER);
        c.setInt(2, month);
        c.execute();
        long dt = c.getLong(1);
        c.close();
        return dt;
    }
    
    // Tính chi phí 1 tháng nhất định
    public long getChiPhi(int month) throws SQLException{
        String sql = "{? = call FC_CHIPHI_MOTTHANG(?)}";
        CallableStatement c = con.prepareCall(sql);
        c.registerOutParameter(1, Types.NUMERIC);
        c.setInt(2, month);
        c.execute();
        long dt = c.getLong(1);
        sql = "{? = call FC_TONGTIENLUONG_NHANVIEN()}";
        c = con.prepareCall(sql);
        c.registerOutParameter(1, Types.NUMERIC);
        c.execute();
        dt += c.getLong(1);
        c.close();
        return dt;
    }
    
    // Lấy tất cả Mã xe có trong kho (#MaDX)
    public ArrayList<Integer> getListMaXe() throws SQLException{
        ArrayList<Integer> list = new ArrayList<Integer>();
        String sql = "SELECT MAXE FROM XE";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            list.add(r.getInt(1));
        }
        return list;
    }
    
    // Lấy tất cả Hợp đồng mua xe có trong db
    public ArrayList<ModelHopDongMuaXe> getListHDMX() throws SQLException{
        ArrayList<ModelHopDongMuaXe> list = new ArrayList<ModelHopDongMuaXe>();
        String sql = "SELECT MAHDMX, MAKH, TENDONGXE, TO_CHAR(NGAYTAOHOPDONG, 'dd-mm-yyyy'), TRIGIA, MANV FROM HOPDONGMUAXE";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()){
            int MaHD = r.getInt(1);
            int MaKH = r.getInt(2);
            String tenXe = r.getString(3);
            String ngay = r.getString(4);
            String gia = r.getString(5);
            int MaNV = r.getInt(6);
            ModelHopDongMuaXe data = new ModelHopDongMuaXe(MaHD, MaKH, tenXe, ngay, gia, MaNV);
            list.add(data);
        }
        return list;
    }
}
