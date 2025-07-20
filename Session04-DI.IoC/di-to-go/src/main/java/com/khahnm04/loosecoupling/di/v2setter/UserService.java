package com.khahnm04.loosecoupling.di.v2setter;

// GUI -> Controller -> Service -> Repo (JPA/HHibernnate CRUD) -> Table
public class UserService {

    // Chuyên xử lí data về User/Account tronng RAM, sau đó gọi Repo để xuống Table
    // Ta cần trợ giúp từ ngoài 2 việc/ 2 Dependency: Repo, Sender gửi cofirm
    // Ta ko tự new, ko nuôi 2 thằng này, bên ngoài tiêm chích vào, gọi dịch vụ
    // C1: FIELD
    // C2: CONSTRUCTOR (ĐÃ LÀM)
    // C3: SETTER
    // C4: DÙNG FRAMEWORK

    private UserRepo userRepo; // ko new chờ tiêm vào
    private EmailSender emailSender; // ko new chờ tiêm vào

    // setter tự generate hoặc tự gõ code - y chang như yob, gpa đc sett vào

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void setEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }
    //CÁCH NÀY DỄ HIỂU LUÔN, NHƯNG GIÁ PHẢI TRẢ: NULL CHO DEPENDENCY NẾU KO GỌI SET()
    //NẾU QUA CONSTRUCTOR, BẠN KO ĐƯA VÀO CTOR, THÌ KO NEW ĐC, VÌ CTOR YÊU CẦU PHẢI ĐƯA THAM SỐ VÀO THÌ MỚI TRỌN VẸN VIỆC GỌI HÀM
    //THƯỜNG GIANG HỒ ƯU TIÊN DÙNG CONSTRUCTOR INJECTION, ĐỂ KO BỊ NULL CÁI DEPENDENCY! !!

    //về logic, chỗ này thay Account bang AccountDto - data tranfer object
    //một class/object có nguồn gốc từ Account entity, nhưng ít cột hơn
    public void registerAccount(Account acc) {
        //trong acc có info email ... minh tự gửi mail theo email này ...
        //TODO: logic code goi CRUD của repo

         //confirmed email
        emailSender.sendEmail("khanhnguyen@gmail.com", "Please input the OTP...");

    }

}
