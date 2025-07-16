package com.khahnm04.loosecoupling.di.v1contructor;

public class EmailSender {

    // Tao EmailSender rất giỏi gửi email
    // SRP thoả!!!
    public void sendEmail(String recipient, String message) {
        // recipient: người nhận, message: nội dung mail
        // todo: logic xử lý gửi email: setup account để đóng vai người gửi (fromm - mình gửi, app gửi), format email cho pro

        // Thông báo thành công
        System.out.println("(DI): Mail was sent to: " + recipient + "successfully!!!");

    }

}
