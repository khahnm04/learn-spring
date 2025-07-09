package com.khahnm04.superapp.repository;

import com.khahnm04.superapp.entity.Student;
import com.khahnm04.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentRepo {

    /*
     - Class này chứa các hàm CRUD trực tiếp table Student - Repo: nhà kho dữ liệu
     - Muốn CRUD table thì phải nhờ ông EntityMânger dc cung cấp từ JpaUtil Singleton
     - Flow: UI -> SERVICE -> REPO (here) -> JpaUtil (Entity-Manager và Factory) -> TABLE
     - Các hàm CRUD ở đây thường đặt tên ngắn gọn, hướng hành động giống như lệnh SQL chuẩn (Insert, Update, Delete)
     - Tên hàm gợi ý: save(), update(), delete(), remove(), find(), findAll(), findById()
     - Tùy hàm, nhưng nếu có thay đổi trong table (Insert, Update, Delete) thì hàm sẽ nhận vào Object (Insert, Update), hoặc Key (Delete) Delete đưa Object vẫn dc vì vào trong Object, get field Key để xóa
     - Nhớ dùng TRANSACTION khi thay đổi data trong table (Insert, Update, Delete), Select thì ko cần vì ko thay đổi data
    */

    // Hàm Insert xuống Table
    public void save(Student obj){

        // Gọi EM (Entity Manager) nhờ giúp, kèm transaction - có thay đổi data
        EntityManager em = JpaUtil.getEntityManager(); // đoạn lệnh trong static {} chạy duy nhất 1 lần, khởi động heavy connection
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();

        // try catch khi save bị lỗi - từ từ

        em.close(); // Giám đốc đã xong việc

    }

    // Hàm lấy tất cả sinh viên - JPQL SELECT s FROM Student s
    public List<Student> findAll(){

        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("FROM Student", Student.class).getResultList();

    }

    // Sửa thông tin sinh viên - Cập nhật
    public void update(Student obj) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(obj); // merge() nghĩa là tích hợp object đưa vào vào trong EM
                       // EM nó sẽ đổ ngang, copy ngang obj vào TRONG obj ứng với dòng trong tabl
                       // nếu bạn cố tình đưa object mà key ko tồn tại trong table, sẽ insert mới
                       // merge() = insert() + update()
        em.getTransaction().commit();
    }

    public void delete(Student obj) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }

    // Overload
    public void delete(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        Student x = em.find(Student.class, id); // Tìm SV có id = id đưa vào, gọi là x và remove x, remove obj giống như trên
        em.remove(x);
        // em.remove(em.find(Student.class, id)); // Viết gộp

        em.getTransaction().commit();
    }


}
