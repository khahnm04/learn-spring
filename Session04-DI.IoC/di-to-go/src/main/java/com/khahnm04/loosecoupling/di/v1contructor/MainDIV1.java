package com.khahnm04.loosecoupling.di.v1contructor;

public class MainDIV1 {

    public static void main(String[] args) {

        // Muốn có Service, cần có EmailSender truyền vào
        EmailSender emailSender = new EmailSender(); // dependency chủ động lộ mặt
        UserService userService = new UserService(emailSender); // Chích/tiêm Object bên ngoài vào trong Service

        userService.registerAccount(new Account());

        // main class chủ động tạo obj class b, dependency, đưa vào class chính thằng chứa, tạo các dependency được gọi là container -> container: là nơi chứa các dependency
        // chủ động tạo dependency, đưa vào trong service class chính a
        // thì kỹ thuật này code ở trên gọi là ioc, đảo ngược việc kiểm soát tạo object, service mất bớt quyền, trao quyền, đảo quyền kiểm soát dependency => inversion of control

        // spring, spring boot thay main, tạo, kiểm soát, tiêm chích dependency cho class chính
        // -> 2 thằng spring, spring boot dc gọi là IoC Container (tao là thằng chuyên quản lý các dependency)

    }

}
