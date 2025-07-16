package com.khahnm04.tightcoupling;

// Class chính, lo xử lý data trong RAM
// GUI -> Controller -> Service -> Reposiory (JpaUtil) -> Table
public class UserService {

    // Có ít nhất 2 dependency mà Service cần
    // 1. UserRepository: giúp CRUD table Accounnt
    // 2. EmailSender: giúp gửi email/sms/whatsapp confirm

    private UserRepo userRepo = new UserRepo(); // dependency, tight-coupling
    private EmailSender emailSender = new EmailSender(); // dependency, tight-coupling (vì chủ động quản lý object dependency)

    // new Service, có 2 chú này dc new luôn!!!
    // hard code dependency, cứng dependency vào đây
    // full-controll, direct-control dependency: tự khai báo, tự new
    // vấn đề: sau này thay = sms, whatsapp thì phải sửa code ở class này

    // có nhiều hàm liên quan đến table User: getAllAccount(), findByEmail(), findByPhone(), updateAccount()
    // Nhận vào full info Account từ web form đăng ký, hoặc nhận vào DTO, chứa email, phonne,whatsapp_id bên trong trích ra
    public void registerAccount(Account acc) {

        // todo: gọi repo để xuống table - Xài dependency 1

        // todo: gửi mail confirm - Xài dependency 2
        emailSender.sendEmail("khanhnguyen@gmail.com", "Please input the OTP...");

    }

}

// Class A: class Service, xài class B,chủ động new luôn -> tight coupling
// Class B: class EmailSender - dependency của A
