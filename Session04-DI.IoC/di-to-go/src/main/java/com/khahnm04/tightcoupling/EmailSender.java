package com.khahnm04.tightcoupling;

public class EmailSender {

    /*
     * Tôi (Class này) rât giỏi, chuyên gửi email, tôi ko dính dáng gì đến WhatsApp, Tôi thỏa mãn nguyên lí S?/SRP trong SOLID
     * Tôi chỉ chứa hàm, nhiều hàm chuyên liên quan đến email - 1 chủ thể
     * Sau này nâng cấp code thì cũng chỉ xoay quanh 1 lí do/chủ thể sửa đổi
     */
    /* hàm nhận thông tin email từ người dùng khi tạo account, thông tin email nhận từ màn hình đăng ký, di qua Controller đến Service để xử lý!!
     * email của user đăng ký nằm trong Account entity (đơn giản), nằm trong AccountDto (bản cập nhật field từ Entity)
     */
    public void sendEmail(String recipient, String message) {
        // recipient: người nhận, message: nội dung mail
        // todo: logic xử lý gửi email: setup account để đóng vai người gửi (fromm - mình gửi, app gửi), format email cho pro

        // Thông báo thành công
        System.out.println("Mail was sent to: " + recipient + "successfully!!!");

    }

}
