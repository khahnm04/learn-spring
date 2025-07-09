package com.khahnm04.superapp.service;

import com.khahnm04.superapp.entity.Student;
import com.khahnm04.superapp.repository.StudentRepo;

import java.util.List;

public class StudentService {

    /*
     - Flow: UI -> SERVICE (here) -> REPO -> JpaUtil (Entity-Manager và Factory) -> TABLE
     - Class này đứng giữa, hứng info từ user/người dùng, tạo object, đẩy xuống cho repo lo giúp
     - Nó cũng nhờ REPO lấy Object từ Table, đẩy ngược lên UI cho User xem
     - Chắc chắn nó phải khai báo biến REPO để REPO giúp, chỉ cần 1 biến REPO dùng chung cho các hàm, do mình gọi bên trong REPO .save() .findAll()...
     - Class này phải chuẩn bị Object để đưa xuống REPO
     - Tên hàm class này đặt thường gần gũi với user hơn, do gần user gần hơn DB, mình là service cung cấp data cho user, nhận thầu data từ user
     - Tên hàm gợi ý: createStudent() getAllStudents() updateStudent() deleteStudent()
    */

    private StudentRepo studentRepo = new StudentRepo();

    public void createStudent(Student obj) {

        // Cần repo, dùng chung hay riêng đều đc
        // Todo: Check trùng key, email, validate,...
        // Todo: Bắt try-catch để thông báo...
        studentRepo.save(obj);

    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public void updateStudent(Student obj) {
        studentRepo.update(obj);
    }

    public void deleteStudent(String id) {
        studentRepo.delete(id);
    }

}
