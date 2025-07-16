package com.khahnm04.loosecoupling.di.v1contructor;

public class UserService {

    // SRP: Tớ giỏi vụ CRUD table Account trong RAM
    // Tớ cần 2 dependency, mỗi đứa lo 1 việc
    // UserRepo và EmailSender
    private UserRepo userRepo; // có new hay ko, có là tight coupling, nếu ko, lỏng ra -> DI @Autowired nghĩa là DI, nghĩa là ko full control
    //private EmailSender emailSender = new EmailSender(); // code cũ full control, ko DI
    //@Autowired - ai đó khác new và tiêm chích vào cho mình (mình là Service)
    //Spring/SpringBoot làm giúp việc new, chích/tiêm
    private EmailSender emailSender; // Ko new thì phải dc đưa vào

    // có nhiều cách đưa obj từ ngoài vào trong 1 class
    // 1. trực tiếp qua field, biến emailsender thành public - nguy hiểm vi phạm encapsulation. vẫn muốn qua field mà private - dùng kỹ thuật nâng cao reflection !!!
    // field injection (dùng reflection, ioc framework)

    // 2. truyền vào qua constructor !!! mlem nhất
    // tạo object chính mình qua constructor và nhận thêm đồ qua tham số constructor
    // object dependency đi qua, đưa qua constructor

    // 3. setter - truyền qua hàm set() nhưng nếu lười ko gọi set() thì dependency bị null

    //4. dùng framework/thư viện bên ngoài tự kiểm soát việc tạo obj dependency và tiêm chích vào: spring/springboot, ko vi phạm nguyên lý vì nó chơi reflection ngầm

    // chích/tiêm 2 thằng dependency từ ngoài vào trong mình service qua constructor
    // y chang truyền yob, gpa -> 2 thằng này primitive, value thuần
    public UserService(UserRepo userRepo, EmailSender emailSender) {
        this.userRepo = userRepo;
        this.emailSender = emailSender;
    }

    public UserService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void registerAccount(Account acc) {

        // todo: dùng Repo xuống table

        // todo: gửi mail
        emailSender.sendEmail("khanhnguyen@gmail.com", "Please input the OTP...");

    }

}
