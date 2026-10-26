AQUARA - ỨNG DỤNG ANDROID (MÃ NGUỒN)
====================================
1. Cài Android Studio (phiên bản mới), mở thư mục AQUARA và đợi Gradle đồng bộ.
2. Chép VIDEO CỦA BẠN (MP4, nên dùng H.264/AAC) vào:
   app/src/main/res/raw/gioi_thieu.mp4
   Tên file phải đúng chữ thường, không dấu, không khoảng trắng.
3. Nhấn Run để chạy trên điện thoại Android hoặc máy giả lập.
4. Xuất APK thử nghiệm: Build > Build Bundle(s) / APK(s) > Build APK(s).
5. Để đăng Google Play: Build > Generate Signed Bundle / APK > Android App Bundle (AAB).
   Bạn phải tự tạo và lưu an toàn khóa ký (keystore). Không chia sẻ khóa ký.
6. Google Play còn yêu cầu tài khoản nhà phát triển, biểu tượng app, ảnh chụp màn hình,
   trang chính sách quyền riêng tư công khai, khai báo Data safety, biểu mẫu nội dung,
   và các yêu cầu kiểm thử/đối tượng API hiện hành. Kiểm tra Play Console khi nộp.
7. Thay biểu tượng mặc định và nội dung chính sách cho đúng thực tế trước khi phát hành.
8. Mã ứng dụng hiện là vn.aquara.app; cần chọn package ID cuối cùng trước khi phát hành.
9. App không tự gọi điện: nút GỌI NGAY mở trình quay số với số 0911113759.
10. Không có file video trong gói này vì bạn chưa tải video MP4 lên cuộc trò chuyện.

CAP NHAT: Ten hien thi va logo app: TUOI TU DONG NGHE AN. Logo hinh giot nuoc va la mau xanh trong res/drawable/ic_launcher.xml.
