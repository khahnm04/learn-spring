package com.khahnm04.loosecoupling.di.v3finalfantasy;

// Mở cho thêm mới - Open for extension, mới hoàn toàn
public class WhatsAppSender implements NotiService {

    @Override
    public void sendNoti(String to, String message) {
        System.out.println("(DI V3 - OCP): Instance WhatsApp message was sent to: " + to + " successfully!!!");
        System.out.println("Message contents: " + message);
    }

}
