package com.khahnm04.superapp.entity.unimany;

import com.khahnm04.superapp.Infra.JpaUtil;
import jakarta.persistence.EntityManager;

public class MainUniMany {

    public static void main(String[] args) {
        createMajorStudent();
    }

    public static void createMajorStudent() {

        Major se = new Major("SE", "SOFTWARE ENGINEERING");

        Student an = new Student("SE100", "AN NGGUYỄN", 2004, 8.6);
        Student binh = new Student("SE101", "BINH LÊ", 2004, 8.7);

        an.setMajor(se);
        binh.setMajor(se); // 2 SV đi vào, nếu ko thì 2 bên độc lập nhau (2 SV ko thuộc về Major)

        /*
         * Xuống DB, phải nhờ JpaUtil, cần có nhà xưởng Factory (kết nối SQL Server), Mướn ông giám đốc giám sát các Entity EntityManager, chuyển xử lý @Entity
         * Thêm xóa sửa DB thì phải nhớ có Transaction
         */
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(se); // lưu Major trước
        em.persist(an); // lưu Student sau, ko cascade = CascadeType.ALL (ko đổ đô-mi-no dc)
        em.persist(binh); // domino (cascade): 1 -> N, chỉ áp dụng cho khi đứng từ bên 1 nhìn sang bên nhiều
        em.getTransaction().commit(); // chính thức save thật, ổn định xuống DB
        em.close();

    }

}
