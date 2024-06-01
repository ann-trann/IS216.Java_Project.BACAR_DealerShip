ALTER SESSION SET CURRENT_SCHEMA= MYDATABASE;

BEGIN
    FOR t IN (SELECT table_name FROM user_tables) LOOP
        EXECUTE IMMEDIATE 'DROP TABLE ' || t.table_name || ' CASCADE CONSTRAINTS';
    END LOOP;
END;
/



/*

SELECT * FROM CHITIETHDSC;
SELECT * FROM HOADONSUACHUA;
SELECT * FROM LICHSUACHUA;
SELECT * FROM PHIEUBAOHANH;
SELECT * FROM HOPDONGMUAXE;
SELECT * FROM XE;
SELECT * FROM DONGXE;
SELECT * FROM PHUKIEN;
SELECT * FROM KHACHHANG;
SELECT * FROM NHANVIEN;

*/


/*

DROP TABLE CHITIETHDSC;
DROP TABLE HOADONSUACHUA;
DROP TABLE LICHSUACHUA;
DROP TABLE PHIEUBAOHANH;
DROP TABLE HOPDONGMUAXE;
DROP TABLE XE;
DROP TABLE DONGXE;
DROP TABLE PHUKIEN;
DROP TABLE KHACHHANG;
DROP TABLE NHANVIEN;

*/


-- Nhan vien

CREATE TABLE NhanVien (
  MaNV NUMBER,
  TenNV NVARCHAR2(20),
  SDT VARCHAR2(10) UNIQUE,
  Luong NUMBER(10),
  ChucVu NVARCHAR2(30),
  NgayVaolam DATE,
  TaiKhoan VARCHAR2(6) UNIQUE,
  MatKhau VARCHAR2(4),
  TrangThai NVARCHAR2(20),
  email NVARCHAR2(30),
  ma_nql NUMBER
);

ALTER TABLE NHANVIEN ADD CONSTRAINT pk_nv PRIMARY KEY (MaNV);
ALTER TABLE NHANVIEN ADD CONSTRAINT fk_nv_nql FOREIGN KEY (ma_nql) REFERENCES NhanVien(MaNV);

ALTER TABLE NHANVIEN ADD CONSTRAINT NV_CHUCVU_THUOC CHECK (LOWER(CHUCVU) IN ('quan ly', 'kho', 'ban hang', 'sua chua'));
ALTER TABLE NHANVIEN ADD CONSTRAINT NV_TRANGTHAI_THUOC CHECK (LOWER(TRANGTHAI) IN ('dang lam viec', 'da nghi'));


--------------------------------------------------------------------



-- Khach hang

CREATE TABLE KhachHang (
  MaKH NUMBER,
  TenKH NVARCHAR2(20),
  SDT VARCHAR2(10),
  LoaiKH VARCHAR2(10)
);

ALTER TABLE khachhang ADD CONSTRAINT pk_kh PRIMARY KEY (MaKH);


--------------------------------------------------------------------


-- Phu kien

CREATE TABLE PhuKien (
  MaPK NUMBER,
  TenPK NVARCHAR2(30),
  NgayNhap DATE,
  XuatXu NVARCHAR2(20),
  SoLuong NUMBER,
  GiaNhap NUMBER,
  GiaBan NUMBER
);

ALTER TABLE PhuKien ADD CONSTRAINT pk_pk PRIMARY KEY (MaPK);


--------------------------------------------------------------------

-- DongXe

CREATE TABLE DONGXE (
  MaDX Number,
  TenDongXe VARCHAR2(30),
  LoaiXe VARCHAR2(30),
  GiaNhap NUMBER,
  GiaBan NUMBER,
  SoLuong NUMBER,
  ThoiGianBaoHanh NUMBER
);

ALTER TABLE DONGXE ADD CONSTRAINT PK_DONGXE PRIMARY KEY (MaDX);



--------------------------------------------------------------------

-- Xe

CREATE TABLE Xe (
  MaXe NUMBER,
  MaDX NUMBER,
  TrangThai NVARCHAR2(30),
  MANV NUMBER
);

ALTER TABLE XE ADD CONSTRAINT pk_xe PRIMARY KEY (MaXe);
ALTER TABLE XE ADD CONSTRAINT FK_XE_DX FOREIGN KEY (MaDX) REFERENCES DONGXE(MADX); 
ALTER TABLE XE ADD CONSTRAINT fk_xe_nv FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV);

ALTER TABLE XE ADD CONSTRAINT xe_trangthai CHECK(LOWER(TrangThai) IN ('da ban', 'trong kho'));


--------------------------------------------------------------------

-- Hop dong mua xe

CREATE TABLE HopDongMuaXe (
  MaHDMX NUMBER,
  MaKH NUMBER,
  MaXe NUMBER,
  TenDongXe VARCHAR2(30),
  NgayTaoHopDong DATE,
  TriGia NUMBER(12, 0),
  MaPBH NUMBER UNIQUE,
  MaNV NUMBER
);

ALTER TABLE HOPDONGMUAXE ADD CONSTRAINT PK_hd PRIMARY KEY (MaHDMX);
ALTER TABLE HOPDONGMUAXE ADD CONSTRAINT fk_hd_kh FOREIGN KEY (MaKH) REFERENCES KHACHHANG(MaKH);
ALTER TABLE HOPDONGMUAXE ADD CONSTRAINT fk_hd_nv FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV);


--------------------------------------------------------------------


-- Phieu Bao Hanh

CREATE TABLE PhieuBaoHanh (
   MaPBH NUMBER,
   ThoiHanBaoHanh DATE
);

ALTER TABLE PhieuBaoHanh ADD CONSTRAINT PK_PBH PRIMARY KEY (MaPBH);
ALTER TABLE PhieuBaoHanh ADD CONSTRAINT fk_pbh_hd FOREIGN KEY (MaPBH) REFERENCES HopDongMuaXe(MaPBH);


--------------------------------------------------------------------

-- Sua Chua

CREATE TABLE LichSuaChua (
  MaLSC NUMBER,
  MaKH NUMBER,
  MaXe NUMBER,
  Ngay DATE,
  Ca NUMBER,
  MaNV NUMBER,
  TrangThai VARCHAR2(20)
);

ALTER TABLE LICHSUACHUA ADD CONSTRAINT pk_lsc PRIMARY KEY (MaLSC);

ALTER TABLE LICHSUACHUA ADD CONSTRAINT fk_lsc_kh FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH);
ALTER TABLE LICHSUACHUA ADD CONSTRAINT fk_lsc_nv FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV);

ALTER TABLE LICHSUACHUA ADD CONSTRAINT LSC_CA_THUOC CHECK(CA IN (1, 2));
ALTER TABLE LICHSUACHUA ADD CONSTRAINT LSC_TRANGTHAI_THUOC CHECK(TRANGTHAI IN ('Hoan thanh', 'Chua hoan thanh'));


--------------------------------------------------------------------


-- HoaDonSuaChua

CREATE TABLE HoaDonSuaChua (
  MaHD NUMBER,
  MaLSC NUMBER,
  MaPBH NUMBER,
  NgayTraXe DATE,
  ThanhTien NUMBER,
  MANV NUMBER
);



ALTER TABLE HoaDonSuaChua ADD CONSTRAINT PK_HDSC PRIMARY KEY (MaHD);

ALTER TABLE HoaDonSuaChua ADD CONSTRAINT FK_HDSC_PBH FOREIGN KEY (MaPBH) REFERENCES PhieubaoHanh(MaPBH);
ALTER TABLE HoaDonSuaChua ADD CONSTRAINT FK_HDSC_NV FOREIGN KEY (MaNV) REFERENCES NhanVien(MANV);


--------------------------------------------------------------------


-- ChiTietHoaDon

CREATE TABLE ChiTietHDSC (
  MaHD NUMBER,
  MaPK NUMBER,
  SoLuong NUMBER
);

ALTER TABLE ChiTietHDSC ADD CONSTRAINT PK_CTHD PRIMARY KEY (MaHD, MaPK);

ALTER TABLE ChiTietHDSC ADD CONSTRAINT FK_CTHD_SC FOREIGN KEY (MaHD) REFERENCES HoaDonSuaChua(MaHD);
ALTER TABLE ChiTietHDSC ADD CONSTRAINT FK_CTHD_PK FOREIGN KEY (MaPK) REFERENCES PhuKien(MaPK);


-------------------------------------------------------------------------


-- Tao trigger cho bang HOPDONGMUAXE, tu dong tao MAPBH dua tren MAHDMX va MAXE

CREATE OR REPLACE TRIGGER trg_set_MaPBH
BEFORE INSERT ON HOPDONGMUAXE
FOR EACH ROW
BEGIN
  :NEW.MAPBH := TO_CHAR(:NEW.MAHDMX) || TO_CHAR(:NEW.MAXE);
END;
/



-- Tao trigger cho bang HOPDONGMUAXE, tu dong nhap du lieu vao bang PHIEUBANHANG khi da co MAPBH va Han bao hanh.

CREATE OR REPLACE trigger trg_set_PhieuBaoHanh
AFTER INSERT ON HOPDONGMUAXE
FOR EACH row
DECLARE
    tgbh number;
BEGIN
    SELECT D.THOIGIANBAOHANH INTO tgbh
    FROM DONGXE D
        JOIN XE X ON D.MADX = X.MADX
    WHERE MAXE = :new.maxe;
  
    INSERT INTO PHIEUBAOHANH(MAPBH, THOIHANBAOHANH) VALUES (:NEW.mapbh, to_date(ADD_MONTHS(:NEW.NGAYTAOHOPDONG, tgbh), 'dd-mm-yyyy'));
END;
/



--Tao trigger cho bang HOPDONGMUAXE, truong TRIGIA luon bang GIABAN cua xe.

CREATE OR REPLACE TRIGGER TG_HDMX_TriGia
BEFORE INSERT OR UPDATE OF trigia ON HOPDONGMUAXE
FOR EACH ROW
DECLARE
  n_trigia NUMBER;
  v_tendongxe varchar2(30);
BEGIN
  SELECT D.GIABAN, d.tendongxe INTO N_TRIGIA, v_tendongxe
  FROM XE x
    JOIN DONGXE D ON D.MADX = X.MADX
  WHERE X.MAXE = :NEW.MAXE;

  :new.TRIGIA := N_TRIGIA;
  :new.TENDONGXE := v_tendongxe;
END;
/


--Tao trigger cho bang HOADONSUACHUA, khi insert CHITIETHDSC thi update THANHTIEN cua hoa don.

CREATE OR REPLACE TRIGGER TG_HDSC_Thanhtien
AFTER INSERT ON CHITIETHDSC
FOR EACH ROW
DECLARE
  v_giaban NUMBER;
  v_soluong NUMBER;
BEGIN
  SELECT p.GIABAN INTO v_giaban
  FROM PHUKIEN p
  WHERE p.MAPK = :NEW.MAPK;

  V_SOLUONG := :NEW.SOLUONG;

  UPDATE HOADONSUACHUA
  SET THANHTIEN = thanhtien + v_giaban * v_soluong
  WHERE MAHD = :NEW.MAHD;

END;
/



----------------------------------------------------------------------------------------------------------------------------------------------------------

-- Du lieu bang NhanVien

INSERT INTO NhanVien (MaNV, TenNV, SDT, Luong, ChucVu, NgayVaolam, TaiKhoan, MatKhau, TrangThai, email, ma_nql) VALUES (100, 'Nguyen Van A', '1234567890', 5000000, 'Quan ly', TO_DATE('2024-05-13', 'YYYY-MM-DD'), 'acc001', 'pass', 'Dang lam viec', 'example0@email.com', NULL);
INSERT INTO NhanVien (MaNV, TenNV, SDT, Luong, ChucVu, NgayVaolam, TaiKhoan, MatKhau, TrangThai, email, ma_nql) VALUES (101, 'Tran Thi B', '0987654321', 4500000, 'Ban hang', TO_DATE('2024-05-14', 'YYYY-MM-DD'), 'acc002', 'pass', 'Dang lam viec', 'example1@email.com', 100);
INSERT INTO NhanVien (MaNV, TenNV, SDT, Luong, ChucVu, NgayVaolam, TaiKhoan, MatKhau, TrangThai, email, ma_nql) VALUES (102, 'Le Van C', '0987654322', 4800000, 'Ban hang', TO_DATE('2024-05-15', 'YYYY-MM-DD'), 'acc003', 'pass', 'Dang lam viec', 'example2@email.com', 100);
INSERT INTO NhanVien (MaNV, TenNV, SDT, Luong, ChucVu, NgayVaolam, TaiKhoan, MatKhau, TrangThai, email, ma_nql) VALUES (103, 'Hoang Thi D', '0987654323', 4900000, 'Ban hang', TO_DATE('2024-05-16', 'YYYY-MM-DD'), 'acc004', 'pass', 'Dang lam viec', 'example3@email.com', 100);
INSERT INTO NhanVien (MaNV, TenNV, SDT, Luong, ChucVu, NgayVaolam, TaiKhoan, MatKhau, TrangThai, email, ma_nql) VALUES (104, 'Pham Van E', '0987654324', 5200000, 'Ban hang', TO_DATE('2024-05-17', 'YYYY-MM-DD'), 'acc005', 'pass', 'Dang lam viec', 'example4@email.com', 100);
INSERT INTO NhanVien (MaNV, TenNV, SDT, Luong, ChucVu, NgayVaolam, TaiKhoan, MatKhau, TrangThai, email, ma_nql) VALUES (105, 'Vo Thi F', '0987654325', 4700000, 'Ban hang', TO_DATE('2024-05-18', 'YYYY-MM-DD'), 'acc006', 'pass', 'Dang lam viec', 'example5@email.com', 100);
INSERT INTO NhanVien (MaNV, TenNV, SDT, Luong, ChucVu, NgayVaolam, TaiKhoan, MatKhau, TrangThai, email, ma_nql) VALUES (106, 'Dinh Van G', '0987654326', 5100000, 'Sua Chua', TO_DATE('2024-05-19', 'YYYY-MM-DD'), 'acc007', 'pass', 'Dang lam viec', 'example6@email.com', 100);
INSERT INTO NhanVien (MaNV, TenNV, SDT, Luong, ChucVu, NgayVaolam, TaiKhoan, MatKhau, TrangThai, email, ma_nql) VALUES (107, 'Bui Thi H', '0987654327', 4600000, 'Sua chua', TO_DATE('2024-05-20', 'YYYY-MM-DD'), 'acc008', 'pass', 'Dang lam viec', 'example7@email.com', 100);
INSERT INTO NhanVien (MaNV, TenNV, SDT, Luong, ChucVu, NgayVaolam, TaiKhoan, MatKhau, TrangThai, email, ma_nql) VALUES (108, 'Nguyen Van I', '0987654328', 5300000, 'Sua chua', TO_DATE('2024-05-21', 'YYYY-MM-DD'), 'acc009', 'pass', 'Dang lam viec', 'example8@email.com', 100);
INSERT INTO NhanVien (MaNV, TenNV, SDT, Luong, ChucVu, NgayVaolam, TaiKhoan, MatKhau, TrangThai, email, ma_nql) VALUES (109, 'Tran Van K', '0987654329', 4400000, 'Sua chua', TO_DATE('2024-05-22', 'YYYY-MM-DD'), 'acc010', 'pass', 'Dang lam viec', 'example9@email.com', 100);
INSERT INTO NhanVien (MaNV, TenNV, SDT, Luong, ChucVu, NgayVaolam, TaiKhoan, MatKhau, TrangThai, email, ma_nql) VALUES (110, 'Hoang Van L', '0987643249', 4700000, 'Sua chua', TO_DATE('2024-05-22', 'YYYY-MM-DD'), 'acc011', 'pass', 'Dang lam viec', 'example10@email.com', 100);
INSERT INTO NhanVien (MaNV, TenNV, SDT, Luong, ChucVu, NgayVaolam, TaiKhoan, MatKhau, TrangThai, email, ma_nql) VALUES (111, 'Tran Van K', '0987657549', 4400000, 'Kho', TO_DATE('2024-05-22', 'YYYY-MM-DD'), 'acc012', 'pass', 'Dang lam viec', 'example9@email.com', 100);
INSERT INTO NhanVien (MaNV, TenNV, SDT, Luong, ChucVu, NgayVaolam, TaiKhoan, MatKhau, TrangThai, email, ma_nql) VALUES (112, 'Hoang Van L', '0987263249', 4700000, 'Kho', TO_DATE('2024-05-22', 'YYYY-MM-DD'), 'acc013', 'pass', 'Dang lam viec', 'example10@email.com', 100);

-- DELETE FROM NHANVIEN
-- SELECT * FROM NHANVIEN

-- Du lieu bang KhachHang

INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (101, 'Nguyen Thi Lan', '0987654330', 'Thuong');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (102, 'Tran Van Minh', '0987654331', 'VIP');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (103, 'Pham Thi Hanh', '0987654332', 'Thuong');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (104, 'Le Van An', '0987654333', 'Thuong');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (105, 'Hoang Van Binh', '0987654334', 'VIP');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (106, 'Vu Thi Hoa', '0987654335', 'Thuong');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (107, 'Dinh Van Phuc', '0987654336', 'Thuong');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (108, 'Nguyen Van Toan', '0987654337', 'VIP');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (109, 'Tran Thi Mai', '0987654338', 'Thuong');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (110, 'Pham Van Khanh', '0987654339', 'VIP');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (111, 'Le Thi Kim', '0987654340', 'Thuong');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (112, 'Hoang Van Long', '0987654341', 'VIP');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (113, 'Vu Thi Thao', '0987654342', 'Thuong');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (114, 'Dinh Thi Nhung', '0987654343', 'Thuong');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (115, 'Nguyen Van Dung', '0987654344', 'VIP');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (116, 'Tran Van Thanh', '0987654345', 'Thuong');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (117, 'Pham Thi Quynh', '0987654346', 'VIP');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (118, 'Le Van Hung', '0987654347', 'Thuong');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (119, 'Hoang Thi Phuong', '0987654348', 'Thuong');
INSERT INTO KhachHang (MaKH, TenKH, SDT, LoaiKH) VALUES (120, 'Vu Van Tam', '0987654349', 'VIP');

-- DELETE FROM KHACHHANG
-- SELECT * FROM khachhang


-- Du lieu bang PhuKien

INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (101, 'Bo op trang tri noi that', TO_DATE('2024-05-12', 'YYYY-MM-DD'), 'Trung Quoc', 15, 2000000, 2500000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (102, 'Man hinh DVD cho ghe sau', TO_DATE('2024-05-11', 'YYYY-MM-DD'), 'Han Quoc', 8, 3500000, 4000000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (103, 'Bo tui cuu ho', TO_DATE('2024-05-10', 'YYYY-MM-DD'), 'Viet Nam', 20, 500000, 700000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (104, 'Bo guong chieu hau camera', TO_DATE('2024-05-09', 'YYYY-MM-DD'), 'Trung Quoc', 10, 1500000, 1800000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (105, 'O khoa cap xe', TO_DATE('2024-05-08', 'YYYY-MM-DD'), 'Han Quoc', 12, 300000, 400000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (106, 'Camera hanh trinh', TO_DATE('2024-05-07', 'YYYY-MM-DD'), 'Viet Nam', 18, 800000, 1000000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (107, 'Tham lot san', TO_DATE('2024-05-06', 'YYYY-MM-DD'), 'Trung Quoc', 25, 500000, 600000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (108, 'Day dai an toan', TO_DATE('2024-05-05', 'YYYY-MM-DD'), 'Han Quoc', 30, 200000, 250000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (109, 'Op bao ve can sau', TO_DATE('2024-05-04', 'YYYY-MM-DD'), 'Viet Nam', 15, 600000, 700000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (110, 'Day buoc hanh ly', TO_DATE('2024-05-03', 'YYYY-MM-DD'), 'Trung Quoc', 20, 100000, 150000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (111, 'Den pha', TO_DATE('2024-05-02', 'YYYY-MM-DD'), 'Han Quoc', 25, 700000, 800000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (112, 'Ho tro tan nhiet', TO_DATE('2024-05-01', 'YYYY-MM-DD'), 'Viet Nam', 20, 450000, 550000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (113, 'Quat tan nhiet', TO_DATE('2024-04-30', 'YYYY-MM-DD'), 'Trung Quoc', 18, 300000, 350000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (114, 'Guong', TO_DATE('2024-04-29', 'YYYY-MM-DD'), 'Han Quoc', 30, 500000, 600000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (115, 'Den hau', TO_DATE('2024-04-28', 'YYYY-MM-DD'), 'Viet Nam', 15, 400000, 450000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (116, 'Op can', TO_DATE('2024-04-27', 'YYYY-MM-DD'), 'Trung Quoc', 22, 600000, 700000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (117, 'Cam bien', TO_DATE('2024-04-26', 'YYYY-MM-DD'), 'Han Quoc', 12, 200000, 250000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (118, 'Coi', TO_DATE('2024-04-25', 'YYYY-MM-DD'), 'Viet Nam', 20, 100000, 120000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (119, 'Can gat mua', TO_DATE('2024-04-24', 'YYYY-MM-DD'), 'Trung Quoc', 25, 150000, 180000);
INSERT INTO PhuKien (MaPK, TenPK, NgayNhap, XuatXu, SoLuong, GiaNhap, GiaBan) VALUES (120, 'Giam xoc', TO_DATE('2024-04-23', 'YYYY-MM-DD'), 'Han Quoc', 30, 1000000, 1200000);


-- Du lieu bang NhaCungCap

/*
INSERT INTO NhaCungCap (MaNcc, TenNcc) VALUES (101, 'NCC Auto Parts');
INSERT INTO NhaCungCap (MaNcc, TenNcc) VALUES (102, 'Global Auto Supplies');
INSERT INTO NhaCungCap (MaNcc, TenNcc) VALUES (103, 'Premium Car Accessories');
INSERT INTO NhaCungCap (MaNcc, TenNcc) VALUES (104, 'Luxury Car Parts');
INSERT INTO NhaCungCap (MaNcc, TenNcc) VALUES (105, 'High-End Vehicle Components');
*/

-- Du lieu bang DongXe

INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (101, 'BMW Z1', 'Roadster', 5000000000, 6000000000, 24, 4);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (102, 'BMW Z3', 'Roadster', 3000000000, 3500000000, 24, 5);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (103, 'BMW Z4', 'Roadster', 3000000000, 3500000000, 24, 5);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (104, 'BMW Z8', 'Roadster', 5000000000, 6000000000, 24, 3);

INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (105, 'BMW i3', 'Electric', 7500000000, 9000000000, 24, 2);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (106, 'BMW i4', 'Electric', 6500000000, 6900000000, 24, 4);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (107, 'BMW iX', 'Electric', 7500000000, 9000000000, 24, 5);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (108, 'BMW iX3', 'Electric', 3000000000, 3500000000, 24, 4);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (109, 'BMW iNEXT', 'Electric', 7500000000, 9000000000, 24, 3);

INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (110, 'BMW 3 Series', 'Sedan', 4500000000, 5000000000, 24, 5);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (111, 'BMW 5 Series', 'Sedan', 3000000000, 4000000000, 24, 4);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (112, 'BMW 7 Series', 'Sedan', 7500000000, 9000000000, 24, 4);

INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (113, 'BMW 2 Series Convertible', 'Convertible', 5000000000, 5500000000, 24, 5);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (114, 'BMW 4 Series Convertible', 'Convertible', 4500000000, 5000000000, 24, 3);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (115, 'BMW 8 Series Convertible', 'Convertible', 6500000000, 7000000000, 24, 5);

INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (116, 'BMW X4', 'Sport activity coupe', 4000000000, 4500000000, 24, 4);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (117, 'BMW X6', 'Sport activity coupe', 5500000000, 6000000000, 24, 5);

INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (118, 'BMW X1', 'Sport activity vehicle', 3500000000, 4000000000, 24, 3);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (119, 'BMW X3', 'Sport activity vehicle', 6000000000, 6500000000, 24, 5);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (120, 'BMW X5', 'Sport activity vehicle', 7500000000, 9000000000, 24, 4);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (121, 'BMW X7', 'Sport activity vehicle', 3000000000, 4000000000, 24, 5);

INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (122, 'BMW 2 Series Gran Coupe', 'Gran coupe', 5500000000, 6000000000, 24, 5);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (123, 'BMW 4 Series Gran Coupe', 'Gran coupe', 5000000000, 5500000000, 24, 4);
INSERT INTO DongXe (MaDX, TenDongXe, LoaiXe, GiaNhap, GiaBan, ThoiGianBaoHanh, SoLuong) VALUES (124, 'BMW 8 Series Gran Coupe', 'Gran coupe', 7500000000, 9000000000, 24, 3);



-- Du lieu bang Xe

-- Roadster
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (101, 101, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (102, 101, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (103, 101, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (104, 101, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (105, 101, 'Da ban', 111);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (106, 102, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (107, 102, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (108, 102, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (109, 102, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (110, 102, 'Trong kho', 111);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (111, 103, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (112, 103, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (113, 103, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (114, 103, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (115, 103, 'Trong kho', 111);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (116, 104, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (117, 104, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (118, 104, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (119, 104, 'Da ban', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (120, 104, 'Da ban', 111);


-- Electric
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (121, 105, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (122, 105, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (123, 105, 'Da ban', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (124, 105, 'Da ban', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (125, 105, 'Da ban', 111);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (126, 106, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (127, 106, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (128, 106, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (129, 106, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (130, 106, 'Da ban', 111);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (131, 107, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (132, 107, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (133, 107, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (134, 107, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (135, 107, 'Trong kho', 111);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (136, 108, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (137, 108, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (138, 108, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (139, 108, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (140, 108, 'Da ban', 111);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (141, 109, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (142, 109, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (143, 109, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (144, 109, 'Da ban', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (145, 109, 'Da ban', 111);


-- Sedan

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (146, 110, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (147, 110, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (148, 110, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (149, 110, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (150, 110, 'Trong kho', 111);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (151, 111, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (152, 111, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (153, 111, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (154, 111, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (155, 111, 'Da ban', 111);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (156, 112, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (157, 112, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (158, 112, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (159, 112, 'Trong kho', 111);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (160, 112, 'Da ban', 111);


-- Convertible

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (161, 113, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (162, 113, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (163, 113, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (164, 113, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (165, 113, 'Trong kho', 112);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (166, 114, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (167, 114, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (168, 114, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (169, 114, 'Da ban', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (170, 114, 'Da ban', 112);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (171, 115, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (172, 115, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (173, 115, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (174, 115, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (175, 115, 'Trong kho', 112);


-- Sport activity coupe
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (176, 116, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (177, 116, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (178, 116, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (179, 116, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (180, 116, 'Da ban', 112);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (181, 117, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (182, 117, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (183, 117, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (184, 117, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (185, 117, 'Trong kho', 112);

-- Sport activity vehicle

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (186, 118, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (187, 118, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (188, 118, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (189, 118, 'Da ban', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (190, 118, 'Da ban', 112);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (191, 119, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (192, 119, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (193, 119, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (194, 119, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (195, 119, 'Trong kho', 112);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (196, 120, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (197, 120, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (198, 120, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (199, 120, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (200, 120, 'Da ban', 112);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (201, 121, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (202, 121, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (203, 121, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (204, 121, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (205, 121, 'Trong kho', 112);


-- Gran coupe

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (206, 122, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (207, 122, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (208, 122, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (209, 122, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (210, 122, 'Trong kho', 112);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (211, 123, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (212, 123, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (213, 123, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (214, 123, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (215, 123, 'Da ban', 112);

INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (216, 124, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (217, 124, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (218, 124, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (219, 124, 'Trong kho', 112);
INSERT INTO Xe (MaXe, MaDX, TrangThai, MaNV) VALUES (220, 124, 'Da ban', 112);


-- Du lieu bang HOPDONGMUAXE

INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (101, 101, 105, TO_DATE('2024-01-05', 'YYYY-MM-DD'), null, null, 103);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (102, 102, 119, TO_DATE('2024-01-12', 'YYYY-MM-DD'), null, null, 101);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (103, 103, 120, TO_DATE('2024-01-13', 'YYYY-MM-DD'), null, null, 104);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (104, 104, 123, TO_DATE('2024-01-21', 'YYYY-MM-DD'), null, null, 102);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (105, 105, 124, TO_DATE('2024-01-24', 'YYYY-MM-DD'), null, null, 101);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (106, 106, 125, TO_DATE('2024-01-26', 'YYYY-MM-DD'), null, null, 104);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (107, 107, 130, TO_DATE('2024-02-02', 'YYYY-MM-DD'), null, null, 101);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (108, 108, 140, TO_DATE('2024-02-04', 'YYYY-MM-DD'), null, null, 102);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (109, 109, 144, TO_DATE('2024-02-07', 'YYYY-MM-DD'), null, null, 104);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (110, 110, 145, TO_DATE('2024-02-10', 'YYYY-MM-DD'), null, null, 103);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (111, 111, 155, TO_DATE('2024-02-13', 'YYYY-MM-DD'), null, null, 101);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (112, 112, 160, TO_DATE('2024-02-16', 'YYYY-MM-DD'), null, null, 103);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (113, 113, 169, TO_DATE('2024-02-17', 'YYYY-MM-DD'), null, null, 101);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (114, 114, 170, TO_DATE('2024-03-19', 'YYYY-MM-DD'), null, null, 102);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (115, 115, 180, TO_DATE('2024-03-22', 'YYYY-MM-DD'), null, null, 103);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (116, 116, 189, TO_DATE('2024-03-25', 'YYYY-MM-DD'), null, null, 101);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (117, 117, 190, TO_DATE('2024-03-28', 'YYYY-MM-DD'), null, null, 102);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (118, 118, 200, TO_DATE('2024-04-08', 'YYYY-MM-DD'), null, null, 104);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (119, 119, 215, TO_DATE('2024-04-12', 'YYYY-MM-DD'), null, null, 103);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (120, 120, 219, TO_DATE('2024-04-14', 'YYYY-MM-DD'), null, null, 102);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (121, 101, 220, TO_DATE('2024-04-16', 'YYYY-MM-DD'), null, null, 104);
INSERT INTO HopDongMuaXe (MaHDMX, MaKH, MaXe, NgayTaoHopDong, TriGia, MaPBH, MaNV) VALUES (122, 113, 212, TO_DATE('2024-04-25', 'YYYY-MM-DD'), null, null, 104);



-- Du lieu bang PhieuBaoHanh

/*
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (101, TO_DATE('2025-07-03', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (102, TO_DATE('2026-07-03', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (103, TO_DATE('2025-07-16', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (104, TO_DATE('2026-07-16', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (105, TO_DATE('2025-08-11', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (106, TO_DATE('2026-08-11', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (107, TO_DATE('2025-08-26', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (108, TO_DATE('2026-08-26', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (109, TO_DATE('2025-10-12', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (110, TO_DATE('2026-10-12', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (111, TO_DATE('2025-10-19', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (112, TO_DATE('2026-10-19', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (113, TO_DATE('2025-11-04', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (114, TO_DATE('2025-12-25', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (115, TO_DATE('2026-01-12', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (116, TO_DATE('2026-02-16', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (117, TO_DATE('2026-02-19', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (118, TO_DATE('2026-03-04', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (119, TO_DATE('2026-03-19', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (120, TO_DATE('2026-05-01', 'YYYY-MM-DD'));
INSERT INTO PhieuBaoHanh (MaPBH, THOIHANBAOHANH) VALUES (121, TO_DATE('2026-05-05', 'YYYY-MM-DD'));
*/


-- SELECT * FROM PhieuBaoHanh
-- DELETE FROM PhieuBaoHanh


-- Du lieu bang LichSuaChua

INSERT INTO LichSuaChua (MaLSC, MaKH, MaXe, Ngay, Ca, MaNV, TrangThai) VALUES (101, 101, 105, TO_DATE('2024-05-03', 'YYYY-MM-DD'), 1, 106, 'Hoan thanh');
INSERT INTO LichSuaChua (MaLSC, MaKH, MaXe, Ngay, Ca, MaNV, TrangThai) VALUES (102, 101, 119, TO_DATE('2024-05-07', 'YYYY-MM-DD'), 2, 107, 'Hoan thanh');
INSERT INTO LichSuaChua (MaLSC, MaKH, MaXe, Ngay, Ca, MaNV, TrangThai) VALUES (103, 109, 124, TO_DATE('2024-05-09', 'YYYY-MM-DD'), 1, 108, 'Hoan thanh');
INSERT INTO LichSuaChua (MaLSC, MaKH, MaXe, Ngay, Ca, MaNV, TrangThai) VALUES (104, 103, 145, TO_DATE('2024-05-10', 'YYYY-MM-DD'), 2, 109, 'Hoan thanh');
INSERT INTO LichSuaChua (MaLSC, MaKH, MaXe, Ngay, Ca, MaNV, TrangThai) VALUES (105, 105, 180, TO_DATE('2024-05-12', 'YYYY-MM-DD'), 1, 110, 'Hoan thanh');
INSERT INTO LichSuaChua (MaLSC, MaKH, MaXe, Ngay, Ca, MaNV, TrangThai) VALUES (106, 108, 130, TO_DATE('2024-05-13', 'YYYY-MM-DD'), 2, 106, 'Hoan thanh');
INSERT INTO LichSuaChua (MaLSC, MaKH, MaXe, Ngay, Ca, MaNV, TrangThai) VALUES (107, 112, 219, TO_DATE('2024-05-15', 'YYYY-MM-DD'), 1, 108, 'Hoan thanh');
INSERT INTO LichSuaChua (MaLSC, MaKH, MaXe, Ngay, Ca, MaNV, TrangThai) VALUES (108, 116, 220, TO_DATE('2024-05-15', 'YYYY-MM-DD'), 2, 109, 'Hoan thanh');
INSERT INTO LichSuaChua (MaLSC, MaKH, MaXe, Ngay, Ca, MaNV, TrangThai) VALUES (109, 107, 169, TO_DATE('2024-05-16', 'YYYY-MM-DD'), 1, 110, 'Hoan thanh');
INSERT INTO LichSuaChua (MaLSC, MaKH, MaXe, Ngay, Ca, MaNV, TrangThai) VALUES (110, 118, 119, TO_DATE('2024-05-19', 'YYYY-MM-DD'), 2, 106, 'Hoan thanh');
INSERT INTO LichSuaChua (MaLSC, MaKH, MaXe, Ngay, Ca, MaNV, TrangThai) VALUES (111, 104, 219, TO_DATE('2024-05-21', 'YYYY-MM-DD'), 1, 108, 'Chua hoan thanh');
INSERT INTO LichSuaChua (MaLSC, MaKH, MaXe, Ngay, Ca, MaNV, TrangThai) VALUES (112, 106, 220, TO_DATE('2024-05-25', 'YYYY-MM-DD'), 2, 109, 'Chua hoan thanh');
INSERT INTO LichSuaChua (MaLSC, MaKH, MaXe, Ngay, Ca, MaNV, TrangThai) VALUES (113, 117, 169, TO_DATE('2024-05-26', 'YYYY-MM-DD'), 1, 110, 'Chua hoan thanh');
INSERT INTO LichSuaChua (MaLSC, MaKH, MaXe, Ngay, Ca, MaNV, TrangThai) VALUES (114, 119, 119, TO_DATE('2024-05-29', 'YYYY-MM-DD'), 2, 106, 'Chua hoan thanh');


-- SELECT * FROM LichSuaChua



-- Du lieu bang HoaDonSuaChua

INSERT INTO HoaDonSuaChua (MaHD, MaLSC, MaPBH, NgayTraXe, ThanhTien, MaNV) VALUES (101, 101, null, TO_DATE('2024-05-04', 'YYYY-MM-DD'), 0, 106);
INSERT INTO HoaDonSuaChua (MaHD, MaLSC, MaPBH, NgayTraXe, ThanhTien, MaNV) VALUES (102, 102, null, TO_DATE('2024-05-08', 'YYYY-MM-DD'), 0, 107);
INSERT INTO HoaDonSuaChua (MaHD, MaLSC, MaPBH, NgayTraXe, ThanhTien, MaNV) VALUES (103, 103, null, TO_DATE('2024-05-10', 'YYYY-MM-DD'), 0, 108);
INSERT INTO HoaDonSuaChua (MaHD, MaLSC, MaPBH, NgayTraXe, ThanhTien, MaNV) VALUES (104, 104, null, TO_DATE('2024-05-11', 'YYYY-MM-DD'), 0, 109);
INSERT INTO HoaDonSuaChua (MaHD, MaLSC, MaPBH, NgayTraXe, ThanhTien, MaNV) VALUES (105, 105, null, TO_DATE('2024-05-13', 'YYYY-MM-DD'), 0, 110);
INSERT INTO HoaDonSuaChua (MaHD, MaLSC, MaPBH, NgayTraXe, ThanhTien, MaNV) VALUES (106, 106, null, TO_DATE('2024-05-14', 'YYYY-MM-DD'), 0, 106);
INSERT INTO HoaDonSuaChua (MaHD, MaLSC, MaPBH, NgayTraXe, ThanhTien, MaNV) VALUES (107, 105, null, TO_DATE('2024-05-15', 'YYYY-MM-DD'), 0, 110);
INSERT INTO HoaDonSuaChua (MaHD, MaLSC, MaPBH, NgayTraXe, ThanhTien, MaNV) VALUES (108, 106, null, TO_DATE('2024-05-16', 'YYYY-MM-DD'), 0, 106);
INSERT INTO HoaDonSuaChua (MaHD, MaLSC, MaPBH, NgayTraXe, ThanhTien, MaNV) VALUES (109, 105, null, TO_DATE('2024-05-17', 'YYYY-MM-DD'), 0, 110);
INSERT INTO HoaDonSuaChua (MaHD, MaLSC, MaPBH, NgayTraXe, ThanhTien, MaNV) VALUES (110, 106, null, TO_DATE('2024-05-20', 'YYYY-MM-DD'), 0, 106);

-- SELECT * FROM HOADONSUACHUA



-- Du lieu bang ChiTietHDSC

INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (101, 101, 1);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (101, 105, 3);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (101, 107, 4);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (102, 102, 2);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (102, 103, 4);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (103, 104, 1);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (103, 106, 2);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (103, 109, 3);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (104, 102, 4);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (105, 108, 3);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (105, 110, 2);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (106, 103, 3);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (106, 105, 1);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (107, 108, 2);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (107, 113, 1);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (108, 118, 3);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (109, 108, 2);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (110, 120, 1);
INSERT INTO ChiTietHDSC (MaHD, MaPK, SoLuong) VALUES (110, 104, 2);


------------------------------------------------------------------------------------------------------------------------

/*

SELECT * FROM CHITIETHDSC;
SELECT * FROM HOADONSUACHUA;
SELECT * FROM LICHSUACHUA;
SELECT * FROM PHIEUBAOHANH;
SELECT * FROM HOPDONGMUAXE;
SELECT * FROM XE;
SELECT * FROM DONGXE;
SELECT * FROM PHUKIEN;
SELECT * FROM KHACHHANG;
SELECT * FROM NHANVIEN;

*/

------------------------------------------------------------------------------------------------------------------------

/*

DELETE FROM CHITIETHDSC;
DELETE FROM HOADONSUACHUA;
DELETE FROM LICHSUACHUA;
DELETE FROM PHIEUBAOHANH;
DELETE FROM HOPDONGMUAXE;
DELETE FROM XE;
DELETE FROM DONGXE;
DELETE FROM PHUKIEN;
DELETE FROM KHACHHANG;
DELETE FROM NHANVIEN;

*/

------------------------------------------------------------------------------------------------------------------------



-- Tao trigger cho bang nhan vien, khi them nhan vien vao thi cung la NGAYVAOLAM cua nhan vien do.

CREATE OR REPLACE TRIGGER TG_NV_SET_NVL
BEFORE INSERT ON NHANVIEN
FOR EACH ROW
BEGIN
    :new.TRANGTHAI := 'Dang lam viec';
    :NEW.NGAYVAOLAM := SYSDATE; 
END;
/


-- Tao trigger cho bang nhan vien, khi mot nhan vien nghi lam thi xoa TAIKHOAN va MATKHAU cua nhan vien do

CREATE OR REPLACE TRIGGER TG_NV_SET_TRANGTHAI
BEFORE UPDATE OF TRANGTHAI ON NHANVIEN
FOR EACH ROW
BEGIN
    IF (:NEW.TRANGTHAI = 'Da nghi') THEN
        :NEW.TAIKHOAN := NULL;
        :NEW.MATKHAU := NULL;
    END IF;
END;
/

-- Tao trigger cho bang DONGXE, so luong DONGXE phai bang so xe hien tai dang co trong kho, neu la tao dong xe moi thi so luong ban dau phai bang 0.

CREATE OR REPLACE TRIGGER TG_DX_SL
BEFORE INSERT ON DONGXE
FOR EACH ROW
BEGIN
    :NEW.SOLUONG := 0;
END;
/


-- Tao trigger cho bang XE, khi them 1 xe thi trang thai ban dau cua no phai la trong kho

CREATE OR REPLACE TRIGGER TG_XE_INS_TRANGTHAI
BEFORE INSERT ON XE
FOR EACH ROW
BEGIN
    :NEW.TRANGTHAI := 'Trong kho';
END;
/


-- Tao trigger cho bang XE, nhan vien them xe vao phai la nhan vien ban hang hoac la quan ly

CREATE OR REPLACE TRIGGER TG_XE_INS_MANV
BEFORE INSERT ON XE
FOR EACH ROW 
DECLARE 
    V_CHUCVU NHANVIEN.CHUCVU%TYPE;
    V_TRANGTHAI NHANVIEN.TRANGTHAI%TYPE;
BEGIN
    SELECT TRANGTHAI, CHUCVU INTO V_TRANGTHAI, V_CHUCVU
    FROM NHANVIEN
    WHERE MANV = :NEW.MANV;
    
    IF (V_TRANGTHAI = 'Da nghi' OR (V_CHUCVU NOT IN('Kho', 'Quan ly'))) THEN
        RAISE_APPLICATION_ERROR(-20111, 'LOI NHAN VIEN');
    END IF;
END;
/


-- Tao trigger cho bang XE, khi them 1 xe thi cap nhat so luong cua bang DONGXE len 1.

CREATE OR REPLACE TRIGGER TG_XE_INS_XE
AFTER INSERT ON XE
FOR EACH ROW
BEGIN
    UPDATE DONGXE
    SET SOLUONG = SOLUONG + 1
    WHERE MADX = :NEW.MADX;
END;
/


-- Tao trigger cho bang XE, khi doi trang thai 1 xe thanh 'Da ban' thi giam so luong o bang DONGXE xuong 1

CREATE OR REPLACE TRIGGER TG_XE_UPD_TRANGTHAI_XE
AFTER UPDATE OF TRANGTHAI ON XE
FOR EACH ROW
BEGIN
    IF (:NEW.TRANGTHAI = 'Da ban') THEN
        UPDATE DONGXE
        SET SOLUONG = SOLUONG - 1
        WHERE MADX = :NEW.MADX;
    END IF;
END;  
/


-- Tao trigger cho bang HOPDONGMUAXE, khi tao 1 hop dong mua xe voi 1 xe trong kho thi chuyen trang thai xe do thanh 'Da ban' va set ngay tao hop dong la ngay hom do

CREATE OR REPLACE TRIGGER TG_HDMX_INS_XE_TRANGTHAI
BEFORE INSERT ON HOPDONGMUAXE
FOR EACH ROW
DECLARE 
    V_TENDONGXE HOPDONGMUAXE.TENDONGXE%TYPE;
BEGIN
    UPDATE XE
    SET TRANGTHAI = 'Da ban'
    WHERE MAXE = :NEW.MAXE;
    
    SELECT TENDONGXE INTO V_TENDONGXE
    FROM DONGXE D 
        JOIN XE X ON D.MADX = X.MADX
    WHERE X.MAXE = :NEW.MAXE;    
    
    :NEW.TENDONGXE := V_TENDONGXE;
    :NEW.NgayTaoHopDong := SYSDATE;
END;
/

-- Tao trigger cho bang HOPDONGMUAXE, nhan vien tao phai la nhan vien ban hang hoac quan ly

CREATE OR REPLACE TRIGGER TG_HDMX_INS_NV_MANV
BEFORE INSERT OR UPDATE OF MANV ON HOPDONGMUAXE
FOR EACH ROW 
DECLARE 
    V_CHUCVU NHANVIEN.CHUCVU%TYPE;
    V_TRANGTHAI NHANVIEN.TRANGTHAI%TYPE;
BEGIN
    SELECT TRANGTHAI, CHUCVU INTO V_TRANGTHAI, V_CHUCVU
    FROM NHANVIEN
    WHERE MANV = :NEW.MANV;
    
    IF (V_TRANGTHAI = 'Da nghi' OR (V_CHUCVU <> 'Ban hang' AND V_CHUCVU <> 'Quan ly')) THEN
        RAISE_APPLICATION_ERROR(-20111, 'LOI NHAN VIEN');
    END IF;
END;
/

-- Tao trigger cho bang HOPDONGMUAXE, neu nguoi mua do mua hon 10ty thi trang thai se la VIP

CREATE OR REPLACE TRIGGER TG_HDMX_INS_LOAIKH_KH
FOR INSERT OR UPDATE OF TRIGIA ON HOPDONGMUAXE
COMPOUND TRIGGER
    N_TONGTIENMUAXE NUMBER;
    N_TONGTIENSUACHUA NUMBER;
    N_MAKH NUMBER;

    BEFORE EACH ROW IS 
    BEGIN
        N_MAKH := :NEW.MAKH;
    END BEFORE EACH ROW;
    
    AFTER STATEMENT IS
    BEGIN
        SELECT SUM(TRIGIA) INTO N_TONGTIENMUAXE
        FROM HOPDONGMUAXE
        WHERE MAKH = N_MAKH;
        IF (N_TONGTIENMUAXE IS NULL) THEN N_TONGTIENMUAXE := 0;
        END IF;
        
        SELECT SUM(THANHTIEN) INTO N_TONGTIENSUACHUA
        FROM HOADONSUACHUA H
            JOIN LICHSUACHUA L ON L.MALSC = H.MALSC
        WHERE MAKH = N_MAKH;
        IF (N_TONGTIENSUACHUA IS NULL) THEN N_TONGTIENSUACHUA := 0;
        END IF;
        
        IF (N_TONGTIENMUAXE + N_TONGTIENSUACHUA >= 10000000000) THEN 
            UPDATE KHACHHANG 
            SET LOAIKH = 'VIP'
            WHERE MAKH = N_MAKH;
        ELSE     
            UPDATE KHACHHANG 
            SET LOAIKH = 'Thuong'
            WHERE MAKH = N_MAKH;
        END IF;
    END AFTER STATEMENT;
END;
/


-- Tao trigger cho bang HOADONSUACHUA, khi tao 1 hoa don moi thi kiem tra nguoi do da bo hon 10ty chua, neu roi set LoaiKH la VIP


CREATE OR REPLACE TRIGGER TG_HDSC_INS_LOAIKH_KH
FOR INSERT OR UPDATE OF THANHTIEN ON HOADONSUACHUA
COMPOUND TRIGGER
    N_TONGTIENMUAXE NUMBER;
    N_TONGTIENSUACHUA NUMBER;
    N_MAKH NUMBER;

    BEFORE EACH ROW IS 
    BEGIN
        SELECT MAKH INTO N_MAKH
        FROM LICHSUACHUA L
        WHERE L.MALSC = :NEW.MALSC;
    END BEFORE EACH ROW;
    
    AFTER STATEMENT IS
    BEGIN
        SELECT SUM(TRIGIA) INTO N_TONGTIENMUAXE
        FROM HOPDONGMUAXE
        WHERE MAKH = N_MAKH;
        IF (N_TONGTIENMUAXE IS NULL) THEN N_TONGTIENMUAXE := 0;
        END IF;
        
        SELECT SUM(THANHTIEN) INTO N_TONGTIENSUACHUA
        FROM HOADONSUACHUA H
            JOIN LICHSUACHUA L ON L.MALSC = H.MALSC
        WHERE MAKH = N_MAKH;
        IF (N_TONGTIENSUACHUA IS NULL) THEN N_TONGTIENSUACHUA := 0;
        END IF;
        
        IF (N_TONGTIENMUAXE + N_TONGTIENSUACHUA >= 10000000000) THEN 
            UPDATE KHACHHANG 
            SET LOAIKH = 'VIP'
            WHERE MAKH = N_MAKH;
        ELSE
            UPDATE khachhang
            SET loaikh = 'Thuong'
            WHERE makh = N_MAKH;
        END IF;
    END AFTER STATEMENT;
END;
/


-- Tao trigger cho bang HOADONSUACHUA, khi tao 1 hop dong thi set ngay tao hoa don la ngay hom do, va gia tri ban dau la 0, cap nhat trang thai cho lichsuachua la da hoan thanh


CREATE OR REPLACE TRIGGER TG_HDSC_INS_NGAYTX
BEFORE INSERT ON HOADONSUACHUA
FOR EACH ROW
BEGIN
    :NEW.NGAYTRAXE := SYSDATE;
    :NEW.THANHTIEN := 0;
    UPDATE LICHSUACHUA
    SET TRANGTHAI = 'Hoan thanh'
    WHERE MALSC = :NEW.MALSC;
END;
/


-- Tao trigger cho bang HOADONSUACHUA, thanh tien phai bang so luong * gia phu kien, neu co bao hanh thi tien bang 0. Neu tao moi mot HOADONSUACHUA thi thanh tien ban dau phai bang 0.

CREATE OR REPLACE TRIGGER TG_HDSC_INS_THANHTIEN
BEFORE INSERT OR UPDATE OF THANHTIEN ON HOADONSUACHUA
FOR EACH ROW
DECLARE 
    N_THANHTIEN NUMBER;
BEGIN
  IF UPDATING THEN
      IF (:NEW.MAPBH IS NOT NULL) THEN 
        :NEW.THANHTIEN := 0;
      END IF;
  END IF;
  IF INSERTING THEN
    :NEW.THANHTIEN := 0;
  END IF;
END;
/


-- Tao trigger cho bang HOADONSUACHUA, nguoi lap hoa don phai la nguoi dang lam viec, va nhan vien do phai la nhan vien sua chua hoac la quan ly.

CREATE OR REPLACE TRIGGER TG_HDSC_INS_MANV
BEFORE INSERT OR UPDATE OF MANV ON HOADONSUACHUA
FOR EACH ROW
DECLARE 
    V_CHUCVU NHANVIEN.CHUCVU%TYPE;
    V_TRANGTHAI NHANVIEN.TRANGTHAI%TYPE;
BEGIN
    SELECT TRANGTHAI, CHUCVU INTO V_TRANGTHAI, V_CHUCVU
    FROM NHANVIEN
    WHERE MANV = :NEW.MANV;
    
    IF (V_TRANGTHAI = 'Da nghi' OR (LOWER(V_CHUCVU) <> 'sua chua' AND V_CHUCVU <> 'Quan ly')) THEN
        RAISE_APPLICATION_ERROR(-20111, 'LOI NHAN VIEN');
    END IF;
END;
/


-- Tao trigger cho bang CHITIETHDSC, khi nhap so luong phu kien thi phai nho hon so luong PHUKIEN trong kho, neu du thi cap nhat so luong trong kho

CREATE OR REPLACE TRIGGER TG_CTHDSC_SL
BEFORE INSERT OR UPDATE OF SOLUONG ON CHITIETHDSC
FOR EACH ROW
DECLARE
  N_SOLUONG NUMBER;
BEGIN
  SELECT SOLUONG INTO N_SOLUONG FROM PHUKIEN WHERE MAPK = :NEW.MAPK;
  IF N_SOLUONG < :NEW.SOLUONG THEN
    RAISE_APPLICATION_ERROR(-20111, 'So luong phu kien kh?ng du');
  END IF;

  UPDATE PHUKIEN
  SET SOLUONG = N_SOLUONG - :NEW.SOLUONG
  WHERE MAPK = :NEW.MAPK;
END;
/


-- Tao trigger cho bang CHITIETHDSC, khi them, xoa, sua 1 phu kien thi cap nhat lai so tien cua hoa don
CREATE OR REPLACE TRIGGER TG_CTHDSC_INS
BEFORE INSERT ON CHITIETHDSC
FOR EACH ROW
DECLARE 
    N_GIABAN NUMBER;
BEGIN
    SELECT GIABAN INTO N_GIABAN
    FROM PHUKIEN 
    WHERE MAPK = :NEW.MAPK;
    
    UPDATE HOADONSUACHUA
    SET THANHTIEN = THANHTIEN + :NEW.SOLUONG * N_GIABAN
    WHERE MAHD = :NEW.MAHD;
END;
/

CREATE OR REPLACE TRIGGER TG_CTHDSC_UPD
BEFORE UPDATE ON CHITIETHDSC
FOR EACH ROW
DECLARE 
    N_GIABANCU NUMBER;
    N_GIABANMOI NUMBER;
BEGIN
    SELECT GIABAN INTO N_GIABANCU
    FROM PHUKIEN
    WHERE MAPK = :OLD.MAPK;
    
    SELECT GIABAN INTO N_GIABANMOI
    FROM PHUKIEN
    WHERE MAPK = :NEW.MAPK;
    
    UPDATE HOADONSUACHUA
    SET THANHTIEN = THANHTIEN + (:NEW.SOLUONG * N_GIABANMOI - :OLD.SOLUONG * N_GIABANCU)
    WHERE MAHD = :NEW.MAHD;
END;
/

CREATE OR REPLACE TRIGGER TG_CTHDSC_DEL
BEFORE DELETE ON CHITIETHDSC
FOR EACH ROW
DECLARE 
    N_GIABAN NUMBER;
BEGIN
    SELECT GIABAN INTO N_GIABAN
    FROM PHUKIEN
    WHERE MAPK = :OLD.MAPK;
    
    UPDATE HOADONSUACHUA
    SET THANHTIEN = THANHTIEN - (:OLD.SOLUONG * N_GIABAN)
    WHERE MAHD = :OLD.MAHD;
END;
/
-- Tao trigger cho bang LICHSUACHUA, khi tao moi 1 lich thi nhan vien tao phai la nhan vien sua chua hoac la quan ly.

CREATE OR REPLACE TRIGGER TG_LSC_INS
BEFORE INSERT OR UPDATE OF MANV ON LICHSUACHUA
FOR EACH ROW
DECLARE 
    V_CHUCVU NHANVIEN.CHUCVU%TYPE;
    V_TRANGTHAI NHANVIEN.TRANGTHAI%TYPE;
BEGIN
    SELECT TRANGTHAI, CHUCVU INTO V_TRANGTHAI, V_CHUCVU
    FROM NHANVIEN
    WHERE MANV = :NEW.MANV;
    
    IF (V_TRANGTHAI = 'Da nghi' OR (LOWER(V_CHUCVU) <> 'sua chua' AND V_CHUCVU <> 'Quan ly')) THEN
        RAISE_APPLICATION_ERROR(-20111, 'LOI NHAN VIEN');
    END IF;
END;
/


-- Tao trigger cho bang LICHSUACHUA, moi ngay chi co 2 lich Ca 1 va 2 lich Ca 2

CREATE OR REPLACE TRIGGER TG_LSC_INS_CA
FOR INSERT OR UPDATE OF CA ON LICHSUACHUA
COMPOUND TRIGGER
    N_SOCA NUMBER;
    D_NGAY DATE;
    N_CA NUMBER;
    
    BEFORE EACH ROW IS 
    BEGIN
        D_NGAY := :NEW.NGAY;
        N_CA := :NEW.CA;
    END BEFORE EACH ROW;
    
    AFTER STATEMENT IS 
    BEGIN
        SELECT COUNT(*) INTO N_SOCA
        FROM LICHSUACHUA
        WHERE NGAY = D_NGAY AND CA = N_CA;
        
        IF (N_SOCA > 2) THEN
            RAISE_APPLICATION_ERROR(-20111, 'Ca nay da het luot sua');
        END IF;
    END AFTER STATEMENT;
END;
/        


-- Tao trigger khi mot lich moi duoc them thi lich do co trang thai chua hoan thanh

CREATE OR REPLACE TRIGGER TG_LSC_TRANGTHAI
BEFORE INSERT ON LICHSUACHUA
FOR EACH ROW
BEGIN
    :NEW.TRANGTHAI := 'Chua hoan thanh';
END;
/


-- Tao trigger cho bang KHACHHANG, khong duoc doi loai khach hang thanh loai VIP khi chua du so tien, nguoc lai.

CREATE OR REPLACE TRIGGER TG_KH_CHECK_LOAIKH
BEFORE UPDATE OF LOAIKH ON KHACHHANG
FOR EACH ROW
DECLARE 
    TONGTIENSC NUMBER(12, 0) := 0;
    TONGTIENMX NUMBER(12, 0) := 0;
BEGIN
    SELECT SUM(TRIGIA) INTO TONGTIENMX
    FROM HOPDONGMUAXE 
    WHERE MAKH = :NEW.MAKH;
    
    SELECT SUM(THANHTIEN) INTO TONGTIENSC
    FROM HOADONSUACHUA H
        JOIN LICHSUACHUA L ON L.MALSC = H.MALSC
    WHERE MAKH = :NEW.MAKH;
    
    IF (TONGTIENMX + TONGTIENSC < 10000000000) THEN
        RAISE_APPLICATION_ERROR(-20111, 'So tien chua du');
    END IF;
END;
/


-------------------------------------------------------------


-- Tao Function lay ma nhan vien tiep theo

CREATE OR REPLACE FUNCTION FC_MANV_TIEP
RETURN NUMBER
IS 
    N_MANV NUMBER := 0;
BEGIN
    SELECT MAX(MANV) + 1 INTO N_MANV
    FROM NHANVIEN ;
    
    RETURN N_MANV;
END;
/


-- Tao Function lay ma khach hang tiep theo

CREATE OR REPLACE FUNCTION FC_MAKH_TIEP
RETURN NUMBER
IS 
    N_MAKH NUMBER := 0;
BEGIN
    SELECT MAX(MAKH) + 1 INTO N_MAKH
    FROM KHACHHANG ;
    
    RETURN N_MAKH;
END;
/


-- Tao Function lay ma phu kien tiep theo.

CREATE OR REPLACE FUNCTION FC_MAPK_TIEP
RETURN NUMBER
IS 
    N_MAPK NUMBER := 0;
BEGIN
    SELECT MAX(MAPK) + 1 INTO N_MAPK
    FROM PHUKIEN ;
    
    RETURN N_MAPK;
END;
/


-- Tao Function lay ma hop dong mua xe tiep theo

CREATE OR REPLACE FUNCTION FC_MAHDMX_TIEP
RETURN NUMBER
IS 
    N_MAHDMX NUMBER := 0;
BEGIN
    SELECT MAX(MAHDMX) + 1 INTO N_MAHDMX
    FROM HOPDONGMUAXE ;
    
    RETURN N_MAHDMX;
END;
/


-- Tao Function lay ma xe tiep theo

CREATE OR REPLACE FUNCTION FC_MAXE_TIEP
RETURN NUMBER
IS 
    N_MAXE NUMBER := 0;
BEGIN
    SELECT MAX(MAXE) + 1 INTO N_MAXE
    FROM XE ;
    
    RETURN N_MAXE;
END;
/


-- Tao Function lay ma dong xe tiep theo

CREATE OR REPLACE FUNCTION FC_MADX_TIEP
RETURN NUMBER
IS 
    N_MADX NUMBER := 0;
BEGIN
    SELECT MAX(MADX) + 1 INTO N_MADX
    FROM DONGXE ;
    
    RETURN N_MADX;
END;
/


-- Tao Function lay ma lich sua chua tiep theo.

CREATE OR REPLACE FUNCTION FC_MALSC_TIEP
RETURN NUMBER
IS 
    N_MALSC NUMBER := 0;
BEGIN
    SELECT MAX(MALSC) + 1 INTO N_MALSC
    FROM LICHSUACHUA ;
    
    RETURN N_MALSC;
END;
/


-- Tao Function lay ma hoa don sua chua tiep theo

CREATE OR REPLACE FUNCTION FC_MAHDSC_TIEP
RETURN NUMBER
IS 
    N_MAHD NUMBER := 0;
BEGIN
    SELECT MAX(MAHD) + 1 INTO N_MAHD
    FROM HOADONSUACHUA ;
    
    RETURN N_MAHD;
END;
/


-- Tao Function tinh doanh thu trong 1 thang nhat dinh

CREATE OR REPLACE FUNCTION FC_DOANHTHU_THEOTHANG(
    THANG INT)
RETURN NUMBER
IS
    N_DOANHTHUBX NUMBER := 0;
    N_DOANHTHUSC NUMBER := 0;
BEGIN
    SELECT SUM(TRIGIA) INTO N_DOANHTHUBX
    FROM HOPDONGMUAXE
    WHERE EXTRACT(MONTH FROM NGAYTAOHOPDONG) = THANG;
    IF N_DOANHTHUBX IS NULL THEN N_DOANHTHUBX := 0;
    END IF;
    
    SELECT SUM(THANHTIEN) INTO N_DOANHTHUSC
    FROM HOADONSUACHUA
    WHERE EXTRACT(MONTH FROM NGAYTRAXE) = THANG;
    IF N_DOANHTHUSC IS NULL THEN N_DOANHTHUSC := 0;
    END IF;
    
    RETURN N_DOANHTHUSC + N_DOANHTHUBX;
END;
/

-- Tao Function tinh doanh thu theo 1 nam nhat dinh

CREATE OR REPLACE FUNCTION FC_DOANHTHU_THEONAM(
    NAM NUMBER)
RETURN NUMBER
IS
    N_DOANHTHUBX NUMBER := 0;
    N_DOANHTHUSC NUMBER := 0;
BEGIN
    SELECT SUM(TRIGIA) INTO N_DOANHTHUBX
    FROM HOPDONGMUAXE
    WHERE EXTRACT(YEAR FROM NGAYTAOHOPDONG) = NAM;
    IF N_DOANHTHUBX IS NULL THEN N_DOANHTHUBX := 0;
    END IF;
    
    SELECT SUM(THANHTIEN) INTO N_DOANHTHUSC
    FROM HOADONSUACHUA
    WHERE EXTRACT(YEAR FROM NGAYTRAXE) = NAM;
    IF N_DOANHTHUSC IS NULL THEN N_DOANHTHUBX := 0;
    END IF;
    RETURN N_DOANHTHUSC + N_DOANHTHUBX;
END;
/


-- Tao Function tinh so tien luong phai tra cho nhan vien trong vong 1 thang

CREATE OR REPLACE FUNCTION FC_TONGTIENLUONG_NHANVIEN
RETURN NUMBER
IS
    N_TONGTIENLUONG NUMBER;
BEGIN
    SELECT SUM(LUONG) INTO N_TONGTIENLUONG
    FROM NHANVIEN;
    
    RETURN N_TONGTIENLUONG;
END;
/


-- Tao Function tinh chi phi san pham bo ra trong 1 thang

CREATE OR REPLACE FUNCTION FC_CHIPHI_MOTTHANG (THANG INT)
RETURN NUMBER
IS
    N_CHIPHIXE NUMBER;
    N_CHIPHIPHUKIEN NUMBER;
BEGIN
    SELECT SUM(GIANHAP) INTO N_CHIPHIXE
    FROM HOPDONGMUAXE H
        JOIN XE X ON H.MAXE = X.MAXE
        JOIN DONGXE D ON D.MADX = X.MADX
    WHERE EXTRACT(MONTH FROM NGAYTAOHOPDONG) = THANG;
    
    SELECT SUM(C.SOLUONG * P.GIANHAP) INTO N_CHIPHIPHUKIEN
    FROM HOADONSUACHUA H
        JOIN CHITIETHDSC C ON C.MAHD = H.MAHD
        JOIN PHUKIEN P ON C.MAPK = P.MAPK
    WHERE EXTRACT(MONTH FROM NGAYTRAXE) = THANG;
    
    RETURN N_CHIPHIXE + N_CHIPHIPHUKIEN;
END;
/

-- Tao Function kiem tra ngay hien tai co da het han bao hanh xe chua
CREATE OR REPLACE FUNCTION FC_KIEMTRA_THOIHAN (MABH VARCHAR2)
RETURN NUMBER
IS 
    NGAYBH PHIEUBAOHANH.THOIHANBAOHANH%TYPE;
    t NUMBER := 0;
BEGIN 
    SELECT THOIHANBAOHANH INTO NGAYBH FROM PHIEUBAOHANH p WHERE p.MAPBH = MABH;
    
    IF TO_DATE(NGAYBH, 'dd-MM-yyyy HH24:MI:SS') > TO_DATE(SYSDATE, 'dd-MM-yyyy HH24:MI:SS') THEN 
        t := 1;
    END IF;
    RETURN t;
END;
/

-- Tao Function tinh chi phi san pham bo ra theo nam

CREATE OR REPLACE FUNCTION FC_CHIPHI_MOTNAM (NAM NUMBER)
RETURN NUMBER
IS
    N_CHIPHIXE NUMBER;
    N_CHIPHIPHUKIEN NUMBER;
BEGIN
    SELECT SUM(GIANHAP) INTO N_CHIPHIXE
    FROM HOPDONGMUAXE H
        JOIN XE X ON H.MAXE = X.MAXE
        JOIN DONGXE D ON D.MADX = X.MADX
    WHERE EXTRACT(YEAR FROM NGAYTAOHOPDONG) = NAM;
    IF (N_CHIPHIXE IS NULL) THEN N_CHIPHIXE := 0;
    END IF;
    
    SELECT SUM(C.SOLUONG * P.GIANHAP) INTO N_CHIPHIPHUKIEN
    FROM HOADONSUACHUA H
        JOIN CHITIETHDSC C ON C.MAHD = H.MAHD
        JOIN PHUKIEN P ON C.MAPK = P.MAPK
    WHERE EXTRACT(YEAR FROM NGAYTRAXE) = NAM;
     IF (N_CHIPHIPHUKIEN IS NULL) THEN N_CHIPHIXE := 0;
    END IF;
    
    RETURN N_CHIPHIXE + N_CHIPHIPHUKIEN;
END;
/

-- Tao Function lay ngày hien tai

CREATE OR REPLACE FUNCTION GET_CURRENTDATE
RETURN VARCHAR2
IS
    CURRENTDATE VARCHAR2(10);
BEGIN
    CURRENTDATE := TO_CHAR(SYSDATE, 'dd-mm-yyyy');
    RETURN CURRENTDATE;
END;
/

-- Tao Function so sanh 2 ngay voi nhau

CREATE OR REPLACE FUNCTION COMPAIR_2DATE(
    D1 DATE,
    D2 DATE) RETURN NUMBER
IS
BEGIN
    IF (TO_DATE(D1, 'dd-mm-yyyy') <= TO_DATE(D2, 'dd-mm-yyyy')) THEN
        RETURN 1;
    END IF;
    RETURN 0;
END;
/

-- Tao Fuction

------------------------------------------------------------------------------------------

-- Tao Procedure them khach hang

CREATE OR REPLACE PROCEDURE KH_THEMKH(
    V_TENKH KHACHHANG.TENKH%TYPE,
    V_SDT KHACHHANG.SDT%TYPE)
IS 
    N_MAKH NUMBER;
BEGIN
    N_MAKH := FC_MAKH_TIEP();
    INSERT INTO KHACHHANG(MAKH, TENKH, SDT) VALUES (N_MAKH, V_TENKH, V_SDT);
END;
/


-- Tao Procedure sua thong khach hang

CREATE OR REPLACE PROCEDURE KH_SUAKH(
    N_MAKH KHACHHANG.MAKH%TYPE,
    V_TENKH KHACHHANG.TENKH%TYPE,
    V_SDT KHACHHANG.SDT%TYPE)
IS BEGIN
    UPDATE KHACHHANG
    SET TENKH = V_TENKH, SDT = V_SDT
    WHERE MAKH = N_MAKH;
END;
/


-- Tao Procedure them nhan vien

CREATE OR REPLACE PROCEDURE NV_THEMNV (
    TenNV NHANVIEN.TENNV%TYPE,
    SDT NHANVIEN.SDT%TYPE,
    Luong NHANVIEN.LUONG%TYPE,
    ChucVu NHANVIEN.CHUCVU%TYPE,
    TaiKhoan NHANVIEN.TAIKHOAN%TYPE,
    MatKhau NHANVIEN.MATKHAU%TYPE,
    email NHANVIEN.EMAIL%TYPE,
    ma_nql NHANVIEN.MA_NQL%TYPE)
IS
    N_MANV NUMBER;
BEGIN
    N_MANV := FC_MANV_TIEP();
    INSERT INTO NHANVIEN (MANV, TENNV, SDT, LUONG, CHUCVU, TAIKHOAN, MATKHAU, EMAIL, MA_NQL)
    VALUES (N_MANV, TENNV, SDT, LUONG, CHUCVU, TAIKHOAN, MATKHAU, EMAIL, MA_NQL);
END;
/
    


/*
DROP PROCEDURE KH_SUAKH;
DROP PROCEDURE KH_THEMKH;
DROP PROCEDURE NV_THEMNV;
*/


/*
DROP FUNCTION FC_CHIPHI_MOTNAM;
DROP FUNCTION FC_DOANHTHU_THEOTHANG;
DROP FUNCTION FC_MADX_TIEP;
DROP FUNCTION FC_MAHDMX_TIEP;
DROP FUNCTION FC_MAHDSC_TIEP;
DROP FUNCTION FC_MAKH_TIEP;
DROP FUNCTION FC_MALSC_TIEP;
DROP FUNCTION FC_MANV_TIEP;
DROP FUNCTION FC_MAPK_TIEP;
DROP FUNCTION FC_MAXE_TIEP;
DROP FUNCTION FC_TONGTIENLUONG_NHANVIEN;
*/


