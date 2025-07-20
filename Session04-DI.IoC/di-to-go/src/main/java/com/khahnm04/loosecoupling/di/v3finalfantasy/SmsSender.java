package com.khahnm04.loosecoupling.di.v3finalfantasy;

// Tôi rất giỏi gửi Sms
public class SmsSender implements NotiService {

    // Thực thi cam kết hợp đồng với CLB
    @Override
    public void sendNoti(String to, String message) {
        sendSms(to, message);
    }

    public void sendSms(String phone, String message) {
        // 1. todo: logic xử lý gửi Sms
        // 2. Thông báo thành công khi gửi Sms
        System.out.println("(DI V3 - OCP): Sms was sent to: " + phone + " successfully!!!");
        System.out.println("Sms message: " + message);
    }

}

// Extension, code mới thêm, trc đó chưa có, có ngon, ko sửa Service mới ngon
