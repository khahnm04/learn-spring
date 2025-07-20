package com.khahnm04.loosecoupling.di.v3finalfantasy;

// Tôi rất giỏi gửi email, 1 chuyện mà thôi => nguyên lý SRP - Single Responsibility
// Đơn trách nhiệm, 1 class chỉ tập trung vào 1 chủ thể: Email
// Ôm thêm Sms, WhatsApp => Vi phạm SRP

// Toi gia nhap hoi Noti, toi phai theo quy tac cua hoi, hop dong cam ket tuan thu quy tac viet code cho ham abstract sendNoti()
// => Toi la thanh vien cua NotiService => toi dung dc o class UserService vi UserService chi choi dc voi NotiService
public class EmailSender implements NotiService {

    @Override
    public void sendNoti(String to, String message) {
        sendEmail(to, message);
    }

    public void sendEmail(String recipient, String message) {
        // 1. todo: logic xử lý gửi email
        // 2. Thông báo thành công khi gửi mail
        System.out.println("(DI V3 - OCP): Mail was sent to: " + recipient + " successfully!!!");
        System.out.println("Email message: " + message);
    }

}
