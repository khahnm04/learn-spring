package com.khahnm04.loosecoupling.di.v3finalfantasy;

import com.khahnm04.loosecoupling.di.v2setter.Account;

public class UserService {

    //private SmsSender smsSender; // ko new chờ chích/tiêm vào
    //private EmailSender emailSender; // ko new chờ chích/tiêm vào
    private UserRepo userRepo; // ko new chờ chích/tiêm vào

    // Khai SmsSender, EmailSender đang gọi là khai báo cứng cái dependency
    // Ko tốt cho tương lai khi ta cần gửi qua WhatsApp
    // Ko nên phụ thuộc vào cái cụ thể như ở trên, ta nên phụ thuộc vào cái chung chung để sau này còn dễ bổ sung các hình thức gửi khác mà ko thèm sừa code của chính class này (Service)

    // noi chung chung la phu thuoc vao cai dam gui info nhưng ko nói đứa nào, Sms hay Email hay ...
    // NHƯNG CHẮC ĐC 1 ĐIỀU, objec noti CHAC CHẦN CÓ HÀM sendNot
    // Còn code như này thì từ từ tính
    private NotiService notiService; // ko new chờ chích/tiêm vào

    // Chích:
    public UserService(UserRepo userRepo, NotiService notiService) {
        this.userRepo = userRepo;
        this.notiService = notiService;
    }

    public UserService(NotiService notiService) {
        this.notiService = notiService;
    }

    // Chích/tiêm theo setter(), đổi lieu khac - object có quyền đổi trỏ
    public void setNotiService(NotiService notiService) {
        this.notiService = notiService;
    }

    public void registerAccount(Account acc) {
        // todo: logic code goi CRUD của repo
        // Gửi noti
        //notiService.sendNoti();
        //emailSender.sendEmail("khanhnguyen@gmail.com", "Please input the OTP...");
    }

    // mock, làm giả việc có thông tin gửi tới ai
    //2 THỨ NÀY SE ĐC TRÍCH RA TỪ ACCOUNT OBJECT LẤY TỪ FORM NHẬP, FORM ĐĂNG KÍ Ở WEB, CÓ ĐỦ Ô NHẬP GỒM FULLNAME, ADDRESS, PHONE, EMAIL ...
    public void registerAccount(String to, String message) {
        // todo: logic code goi CRUD của repo
        // Gửi noti (ko biết chính xác dịch vụ nào gửi: sms, mail, whatsapp)
        notiService.sendNoti(to, message);
    }

}
