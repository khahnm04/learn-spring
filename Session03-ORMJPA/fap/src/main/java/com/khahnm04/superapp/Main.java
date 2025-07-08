package com.khahnm04.superapp;

import com.khahnm04.superapp.entity.Lecturer;
import com.khahnm04.superapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.khahnm04.superapp-PU");

    public static void main(String[] args) {
        //insertStudents(); // Tạo bảng chèn data qua OOP, code first
        //getAllStudents(); // select * from theo style OOP, code first
        //insertLecturers();
        getAllLecturers();
    }

    // Học thêm về JPQL: Java Persistence query language
    // Là phiên bản độ từ SQL nhưng dành cho thế giới OOP, Object
    // Hibernate cũng có phiên bản riêng của nó gọi là HQL
    // SQL: select * from Lecturer
    // jpql: from lecturer
    //       select lec from lecturer lec
    //                       với mỗi dòng/record lấy từ table lecturer
    //                       ta new nó trong ram, new lecturer() và gọi vùng new này là
    //                       lec, tức là lec = new lecturer()
    //                       và lặp lại cho toàn bộ record trong table lecturer
    // add kết quả đọc từ table vào kết quả cuối cùng dùng lệnh select lec
    // select lec tức là lấy từng object lec được new từ từng dòng trong table lecturer

    // WHERE
    // SQL: SELECT * FROM Lecturer WHERE Salary = 2000000 //tên cột trong table
    // JPQL: SELECT x FROM Lecturer x WHERE x.salary = 2000000 //tên field trong class
    //              x. là biến object nhen !!! , ko phải cột trong talbe !!!
    public static void getAllLecturers(){

        EntityManager em = emf.createEntityManager();
        // Luôn cần có người quản lý các Entity
        // Viết câu SQL theo style Object, gọi là JPQL, HQL khá giống SQL truyền thống nhưng làm việc, select, thao tác trên object, trên các Entity chứ ko quan tâm tên cột trong table như JDBC đã học

        List<Lecturer> result = em.createQuery("SELECT x FROM Lecturer x WHERE x.salary = 20000000", Lecturer.class).getResultList();
        // Lecturer là class, từ đó sinh ra object, class Lecturer đã đc map thành table Lecturer ở bên khai báo @Entity

        // In KQ:
        System.out.println("The list of Lecturer (" + result.size() + " records):");
        for (Lecturer x : result) {
            System.out.println(x); // toString()
        }

        // Biểu thức Lambda - Lambda Expression, dính dáng cực kì chặt chẽ với Stream API, cơ chế xử lý nhiều dữ liệu ở trong ram
        // lambda expression là hàm vô danh, hàm ẩn danh !!! hàm không có tên
        // dính đến khái niệm lập trình hàm - functional programming
        // hàm được xem là 1 data, và hàm là tham số để truyền vào hàm khác
        System.out.println("The list of students printed by lambda expression");
        result.forEach(x -> {
            System.out.println(x);
        });

//        // Làm điều nhảm với lambda
//        result.forEach(x -> {
//            //System.out.println(x);
//            System.out.println("The list of numbers from 1 to 100");
//            for (int i = 1; i <= 100; ++i) {
//                System.out.print(i + " ");
//            }
//        });

        em.close();
        emf.close(); // Sau getAll mà ko làm gì nữa thì close luôn connection

    }

    public static void insertLecturers() {

        Lecturer an = new Lecturer("AN NGUYEN", 1990, 20_000_000);
        Lecturer binh = new Lecturer("BINH LE", 1991, 20_000_001);

        // tôi cổ ông sếp quản lí các entity ra để tạo table, chèn data vào table lecturer - option xml create, hay update đều mlem! ! !!
        // đi làm thật, cấm option "create" trên máy khách hàng nếu ta fix bug, update app vì toang hết data khách hàng !!!!
        EntityManager em = emf.createEntityManager();

        /*
         - vì có thay đổi trên csdl (table, data) nên ta cần theo dõi chặt chẽ các câu lệnh
         -> dùng khái niệm transaction: do all or nothing (hoặc tất cả, hoặc không gì cả) - nguyên lý acid của transaction
         ví dụ: bạn chuyển tiền trả nợ thằng bạn 1 triệu đồng từ tpbank (mình) sang acb (thằng bạn)
         tpbank -1m và acb +1m => cả 2 phải xảy ra mới okie rớt 1 trong 2, rollback, hoặc tất cả, hoặc chưa gì cả !!!
         bên tpbank: khởi động ngay transaction theo dõi
         mình đã -1m, mãi chưa thấy bên kia noti okie -> nhà mình undo !!!
        */
        em.getTransaction().begin(); // Bắt đầu theo dõi sự thay đổi DB
        em.persist(an);
        em.persist(binh);
        em.getTransaction().commit(); // Khóa sổ, hoặc 2 object xuống, hoặc ko ai cả

        em.close();

    }

    // insert/ tạo mới sinh viên...
    public static void insertStudents() {

        // Gửi thông số cấu hình Server, nhà thầu JPA: Hibernate, nhà thầu JDBC cho JPA class lo để tạo kết nối tới CSDL cụ thể SQL Server
        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.khahnm04.superapp-PU");

        /*
        - Quản lý các class nào mà đã dc @Enitty
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
        // emf.close(); // ngắt kết nối csdl vì đã xong

    }

    // select * để lấy hết data...
    public static void getAllStudents() {

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
        // emf.close();

    }

}
