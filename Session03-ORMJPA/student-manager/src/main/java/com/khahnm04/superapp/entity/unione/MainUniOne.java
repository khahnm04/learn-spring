package com.khahnm04.superapp.entity.unione;

import com.khahnm04.superapp.Infra.JpaUtil;
import jakarta.persistence.EntityManager;

public class MainUniOne {

    // Nhờ và JpaUtil, có hàm đọc file persistence.xml để kết nối đúng CSDL, đúng Driver và giúp tạo ra ông quản lí Entity Entity-Manager
    public static void main(String[] args) {
        createMajorStudents();
    }

    public static void createMajorStudents() {

        // Ta tạo chuyên ngành SE và 2 SV của chuyên ngành này
        Major seMajor = new Major("SE", "SOFTWARE ENGINEERING | KĨ THUẬT PHẦN MỀM");

        Student s1 = new Student("SE100", "AN NGUYN", 2006, 8.6) ;
        Student s2 = new Student("SE101", "BÌNH LÊ",  2006, 8.7);

        // seMajor cần phải add 2 Student s1 s2 vào cái List => Làm sao add???
        seMajor.addStudent(s1);
        seMajor.addStudent(s2);

        /*
         * OOP đã xong về relationship
         * xuống table, đồ domino - cascade 1 major, n student xuống luôn theo (one đi xuống, many đi theo)
         * Nhờ JpaUtil chuẩn bị nhà xưởng Factory, mời giám đốc về quản lý Entity EntityManager
         */
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        em.persist(seMajor); // Major đi xuống, 2 Student theo sau

        em.getTransaction().commit();
        em.close();

    }

}
