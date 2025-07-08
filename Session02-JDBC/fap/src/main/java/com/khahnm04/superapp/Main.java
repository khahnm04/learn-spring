package com.khahnm04.superapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {

        // Ta sẽ xài các class đc cung cấp sẵn bởi jdk có trong thư viện jdbc
        // jdbc này sẽ tự động móc với sql server jdbc driver (của microsoft giúp điều kiển sql server hậu trường)
        // Tương tự mysql, ta cũng cần thêm driver
        Connection conn = null;
        try {

            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=db_giaolang;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String pass = "sa12345";

            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // jdbc hiện nay tự động đi tìm sql server driver, hoặc mysql driver thông qua dấu hiệu trong url ở trên
            conn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Connect to DB successfully");
            // Kết nối thành công với server thì bắt đầu móc lối với table thông qua câu lệnh sql

            // Tạo class PreparedStatement dùng quản lý câu lệnh sql (where, tham số)
            PreparedStatement stm = conn.prepareStatement("select * from Subject");
            ResultSet rs = stm.executeQuery(); // Thực thi câu sql và trả về ResultSet (giống ArrayList), chứa nhiều dòng, mỗi dòng/record, mỗi dòng là info của môn học (code | name | desc | credits | studyHours)
            // Chơi với jdbc thì phải nhớ tên cột !!! -> Mang hướng db first, db oriented
            // Vòng lặp lấy các dòng, mỗi dòng phải chủ động nhớ tên cột table, lấy tên cột
            // => Đó là nhược điểm của jdbc thuần
            while (rs.next()) {
                String code = rs.getString("code"); // tên cột là gì, data type của tên cột là gì, phải nhớ thì mới lấy được
                String name = rs.getString("name");
                int credits = rs.getInt("Credits");
                int hours = rs.getInt("StudyHours");
                // in theo kiểu ghép
                // System.out.println(code + " | "  + name + " | " + credits + " | " + hours);
                // in gióng lề
                System. out.printf("|%10s |%-40s|%2d|%4d|\n", code, name, credits, hours);
            }

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}