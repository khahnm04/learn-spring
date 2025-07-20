package com.khahnm04.loosecoupling.di.v2setter;

// Giỏi và chuyên gửi mail
public class EmailSender {

    public void sendEmail(String recipient, String message) {
        // recipient: người nhận, message: nội dung mail
        // todo: logic xử lý gửi email: setup account để đóng vai người gửi (fromm - mình gửi, app gửi), format email cho pro

        // Thông báo thành công
        System.out.println("(DI V2 - Setter): Mail was sent to: " + recipient + "successfully!!!");
        System.out.println("Email message: " + message);

    }

}
