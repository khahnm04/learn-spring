package com.khahnm04.superapp.entity.bidirectional;

import com.khahnm04.superapp.Infra.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MainBiOneMany {

    public static void main(String[] args) {
        //createMajorStudent();
        getAll();
    }

    /*
    * Lấy danh sách SV, DS chuyên ngành
    * EM EntityManager có 2 hàm:
    * .find(tên class, key) -> trả về duy nhất 1 dòng theo key
    * .createQuery(câu jpql) -> trả về 1 list, list (1 dòng hay nhiều dòng tuỳ câu where)
    * vì oop 2 chiều, nên khi lấy được 1 major se, không cần where gì nữa, vào thằng list của se là lấy full student của se, ta lấy qua object major mà lại có list student, vì major có nhiều sv
    * thay vì chơi trực tiếp table student
    */
    public static void getAll() {

        EntityManager em = JpaUtil.getEntityManager();
        Major se = em.find(Major.class, "SE"); // Có chuyên ngành và List Student SE
        System.out.println("SE major info: " + se);

        List<Student> stuList = se.getStudentList(); // Ko LAZY nữa
        System.out.println("The SE students");
        stuList.forEach(x -> System.out.println(x));

    }

    public static void createMajorStudent() {

        Major se = new Major("SE", "SOFTWARE Engineering | Kỹ thuật phần mềm");
        Major gd = new Major("GD", "Graphics Design | Mỹ thuật số");

        Student an = new Student("SE1000", "AN NGUYỄN", 2005, 8.6);
        Student binh = new Student("SE1601", "BÌNH LÊ", 2005, 8.7);
        Student cuong = new Student("GD1000", "CƯỜNG VÕ", 2005, 8.6);
        Student dung = new Student("GD1001", "DUNG PHẠM", 2005, 8.7);

        // Kết nối chuyên ngành, style Object
        se.addStudent(an);
        se.addStudent(binh);
        gd.addStudent(cuong);
        gd.addStudent(dung);

        // Mời giám đốc EntityManager về quản lý đám @Entity
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(se); // Đổ domino (cascade)
        em.persist(gd); // Đổ domino (cascade)
        em.getTransaction().commit();
        em.close();

    }

}
