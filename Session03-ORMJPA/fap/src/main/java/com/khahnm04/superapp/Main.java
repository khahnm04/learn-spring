package com.khahnm04.superapp;

import com.khahnm04.superapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        insertStudent(); // Tạo bảng chèn data qua OOP, code first
        getAllStudent(); // select * from theo style OOP, code first
    }

    // insert/ tạo mới sinh viên...
    public static void insertStudent() {

        // Gửi thông số cấu hình Server, nhà thầu JPA: Hibernate, nhà thầu JDBC cho JPA class lo để tạo kết nối tới CSDL cụ thể SQL Server
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.khahnm04.superapp-PU");

        /*
        - Tạo ra 1 object dùng để quản lý các entity class ~ map ngang sang table. Class student chịu sự quản lý của em/EntityManager
        - em/EntityManager sẽ lo CRUD trên 1 table nào đó qua mấy hàm huyền thoại: persis() find() merge() remove()
        - Toàn chơi object, đắng sau là table bị ảnh hưởng, tự sinh sql ngầm và cho mình thấy câu SQL khi mình chấm các hàm ở trên .persis() .find() .merge() .remove()
        */
        EntityManager em = emf.createEntityManager();

        // Chuẩn bị data Student - Object - OOP
        Student an = new Student ("SE1", "AN NGUYỄN", 2004, 8.6);
        Student binh = new Student("SE2", "BÌNH LÊ",2004, 8.7);
        Student cuong = new Student ("SE3", "CƯỜNG VÕ", 2004, 8.8);

        // Gọi sếp EntityManager giúp CRUD
        em.getTransaction().begin(); // Bắt buộc phải có Transaction ví có sự thay đổi trong DB
        em.persist(an); // Create table diễn ra ngầm, gọi là code first, code ra table, code ra data
        em.persist(binh); // insert into Student values
        em.persist(cuong);
        em.getTransaction().commit(); // Hoặc cả 3 insert thành công, hoặc chưa bạn nào dc insert
        // Select ko cần vì ko thay đổi trạng thái table

        em.close(); // sa thải ông sếp vì đã xong
        emf.close(); // ngắt kết nối csdl vì đã xong

    }

    // select * để lấy hết data...
    public static void getAllStudent() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.khahnm04.superapp-PU");
        EntityManager em = emf.createEntityManager();

        // Query này cú pháp giống sql, nhưng theo style OOP, có object và dấu chấm, gọi là JPQL, HQL
        // Hậu trường là select * from Student truyền thống - sẽ in xem nếu khai báo cấu hình trong file .xml
        List<Student> result = em.createQuery("FROM Student", Student.class).getResultList();
        System.out.println("The list of students (3 record)");

        for (Student x : result) {
            System.out.println(x); // Gọi thầm toString() của student
        }
        // Dùng biểu thức lambda để in cũng dc

        em.close();
        emf.close();

    }

}
