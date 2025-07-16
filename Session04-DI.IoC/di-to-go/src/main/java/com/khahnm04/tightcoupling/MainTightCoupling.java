package com.khahnm04.tightcoupling;

public class MainTightCoupling {

    public static void main(String[] args) {

        // Class Main này đóng vai UI, controller để gọi, điều khiển những class ở tầng dưới: Service, Repository, JpaUtil
        // Sau này thay bằng Web page, GUI...
        UserService userService = new UserService(); // new Service có sẵn trong lòng 2 dependency: Repo và EmailSender
        userService.registerAccount(new Account());

    }

}
