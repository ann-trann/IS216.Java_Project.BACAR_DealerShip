# Hệ thống quản mua bán xe ô tô - BACAR_DealerShip

## Giới thiệu đồ án

Xuất phát từ nhu cầu thực tế ngành mua bán xe ô tô đang phát triển mạnh mẽ, đòi hỏi các hệ thống quản lý hiện đại để đáp ứng nhu cầu ngày càng tăng của người tiêu dùng và nhà cung cấp. Hệ thống quản lý mua bán xe sẽ giúp quản lý thông tin về xe, nhân viên, khách hàng, lịch sửa chữa, phụ kiện và hóa đơn một cách hiệu quả và chính xác. Đề tài cho phép áp dụng những kiến thức và kỹ năng được học vào thực tiễn, từ lập trình, quản lý dự án, thiết kế hệ thống, đến kiểm thử và triển khai. Quá trình thực hiện đề tài giúp phát triển thêm nhiều kỹ năng mới như quản lý dự án, làm việc nhóm, và giải quyết vấn đề. Đề tài mang tính ứng dụng cao, đáp ứng nhu cầu cấp thiết của thị trường, và tạo điều kiện để áp dụng công nghệ thông tin vào thực tế, từ đó góp phần nâng cao hiệu quả quản lý và cải thiện chất lượng dịch vụ trong lĩnh vực mua bán xe ô tô. 

## Mục tiêu của đề tài
Phát triển một hệ thống phần mềm tích hợp để quản lý toàn bộ quy trình mua bán xe ô tô, bao gồm quản lý xe, hợp đồng, hóa đơn, nhân viên, kho phụ kiện, lịch sửa chữa và thông tin khách hàng. Hệ thống nhằm nâng cao hiệu quả quản lý, tự động hóa các quy trình nghiệp vụ và cung cấp một giao diện người dùng trực quan, dễ sử dụng. 

## Nhóm Thực Hiện : BACA

| MSSV | Họ tên   | Vai trò	  |
| :-------- | :------- |:-------|
| 22520112 | Nguyễn Thái Bảo	| Nhóm trưởng	|
| 22520031 | Trần Thúy An	| Thành viên	|
| 22520046 | Huỳnh Thị Ngọc Ánh	| Thành viên	|
| 22520163 | Đặng Trần Chương	| Thành viên	|

### Giảng viên: Tạ Việt Phương
 

## Các chức năng chính trong ứng dụng
----------------
> * Đăng nhập
> * Đăng ký tài khoản
> * Quản lý xe
> * Quản lý khách hàng
> * Quản lý hợp đồng mua xe
> * Quản lý phụ kiện
> * Quản lý lịch sửa chữa
> * Quản lý hóa đơn sửa chữa
> * Quản lý nhân viên

## Các ngôn ngữ, công nghệ sử dụng
> * Ngôn ngữ sử dụng: `Java`, `PL/SQL`
> * IDE sử dụng: `Netbeans`
> * Công cụ lập trình giao diện: `JavaSwing`
> * Cơ sở dữ liệu: `Oracle`
> * Công cụ quản lý phiên bản: `Git`
> * Công cụ quản lý mã nguồn `Github`
> * ­Công cụ vẽ sơ đồ phân tích và thiết kế dữ liệu: `StarUML`, `draw.io`.

## Yêu cầu cài đặt
> * Sử dụng `JDK 22`
> * Sử dụng `ojdbc8.jar`

## Hướng dẫn cài đặt chương trình
> * **Bước 1:** Clone project [Java_Project.BACAR_DealerShip](https://github.com/ann-trann/IS216.Java_Project.BACAR_DealerShip)
> * **Bước 2:** Vào Netbeans chọn Open project và mở project vừa clone về.
> * **Bước 3:** Thêm tất cả các thư viện cần thiết trong mục src/CM/library/.
> * **Bước 4:** Trong src/CM/database có file Database.sql. Tiến hành vào Oracle tạo user mới với Username là `MYDATABASE` và Password là `123`, sau đó chạy toàn bộ file Database.sql.
> * **Bước 5:** Tiến hành chạy run file src/CM/view/main_frame
/Frame_Login.java để chạy chương trình.
