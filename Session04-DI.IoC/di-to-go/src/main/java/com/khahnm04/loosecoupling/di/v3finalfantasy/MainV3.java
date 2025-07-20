package com.khahnm04.loosecoupling.di.v3finalfantasy;

public class MainV3 {

    public static void main(String[] args) {

        //gui mail confirm khi dang ky
        EmailSender emailSender = new EmailSender();
        UserService userService = new UserService(emailSender); // tiem vao constructor
        userService.registerAccount("KhanhV3@gmail.com", "OTP via email...");

        // Tui muon gửi qua Sms
        SmsSender smsSender = new SmsSender();
        // Chích vào userService ở trên qua SET, ko new userService mới
        userService.setNotiService(smsSender);
        userService.registerAccount("0987654321", "Confirm OTP via SMS...");

        // Tui muon gửi qua WhatsApp
        WhatsAppSender whatsAppSender = new WhatsAppSender();
        // ko them sửa Service, chơi với tương lai
        // Closed for modification
        userService.setNotiService(whatsAppSender); // choi voi tuong lai, ko sua code userService, hard-code la toang, phai sua code nhieu noi
        userService.registerAccount("+1-225-555-1002", "OTP: 2204");

        // Tui muon gửi qua Telegram, Discord
        // Lẽ thường: code thêm class lẻ - concrete class và implement NotiService
        // Pro: Class on the go, take away, anonymous class
        // New luôn interface -> Ăn đòn, hoặc implements ngay code ngay lúc new interface
        NotiService telegram = new NotiService() {
            @Override
            public void sendNoti(String to, String message) {
                System.out.println("Anonymous Class, DI, OCP | To: " + to + " | Message: " + message);
            }
        };
        // Gửi confirm
        userService.setNotiService(telegram);
        userService.registerAccount("nguyenminhkhanh", "DI, INTERFACE mãi đỉnh!!!");

    }

}
