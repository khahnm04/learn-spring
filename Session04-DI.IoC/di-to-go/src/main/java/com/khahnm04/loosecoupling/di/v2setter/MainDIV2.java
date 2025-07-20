package com.khahnm04.loosecoupling.di.v2setter;

public class MainDIV2 {

    public static void main(String[] args) {

        //DEPENDENCY ĐÃ LỘ DIỆN RA NGOÀI QUA SETTER, NHÀ MÌNH CẦN BÁC THỢ Ở NƠI KHÁC ĐẾN GIÚP, CHÍCH/TIÊM DEPENDENCY VÀO QUA SETTER
        EmailSender emailSender = new EmailSender(); // ta có hàm gửi mail rồi
        // IoC

        // việc chính, là của class UserService
        UserService userService = new UserService(); //chưa mời bác thợ, vì ko dùng constructor, mà đi qua set()

        userService.setEmailSender(emailSender); // Tiêm dependency vào

        userService.registerAccount(new Account());

    }

}

// HÀM MAIN() HAY CLASS MAIN NAY LÀ NOI CHUA OBJ DEPENDENCY, VI NO CHỦ ĐỘNG NEW EMAIL-SENDER() LÀ DEPENDENCY ĐẤY
// NƠI CHỨA CÁC OBJECT DEPENDENCY (ĐC NEW) THÌ GỌI LÀ CONTAINER
// TA không tham lam kiểm soát hết việc tạo object dependency, mà chia bớt ra cho người khác tạo, rồi chích vào, chuyển quyền kiểm soát tạo object cho người khác.
// Mình tập trung dùng, gọi là IoC Inversion of Control
// IoC: Là lời khuyên, principle, nói thời về ý tưởng bớt kiểm soát lại mọi chuyện
// DI: Là cách làm cụ thể, implement
//IOC CONTAINER, CONTAINER: NƠI CHỨA OBJECT DEPENDENCY
//SPRING CHÍNH LÀ IOC CONTAINER, SẼ HỌC SỚM!!! THAY CHO MAIN, NHƯNG CHẮC CHẮN DỮ DẰN, KHỦNG HƠN!!!!!!!!!!!!!!
