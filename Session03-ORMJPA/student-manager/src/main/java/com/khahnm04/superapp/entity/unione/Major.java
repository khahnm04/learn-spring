package com.khahnm04.superapp.entity.unione;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "Major")
public class Major {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(2)") // thiếu columnDefinition -> VARCHAR(255)
    private String id; // Mã chuyên ngành

    @Column(name = "Name", columnDefinition = "NVARCHAR(100)", nullable = false) // Ko dùng @Nationalized nữa, để độc lập với hibernate, dễ dàng chuyển sang chơi với ORM Driver khác, vi dụ EclipseLink!!!
    private String name; // Tên chuyên ngành

    // Câu trong CSDL, câu trong đời thường: 1 Major có nhiều sinh viên
    // Muốn lưu nhiều info, List/ArrayList thẳng tiến, Object này tham chiều thông tin Object kia
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    /*
     - Nhờ câu @OneToMany(...), thì bảng/table Student xuất hiện và nó sẽ đòi FK/Join Column
     - cascade = CascadeType.ALL: Khi persist() Major → tự động lưu luôn tất cả Student bên trong nó (1 khi save Major, trong list này có bao nhiêu SV xuống hết một mạch luôn)
     - fetch = FetchType.LAZY: Khi find() Major → chưa load students, chỉ load khi getStudents() (đọc thông tin Major từ DB gồm id và name lên thì nó sẽ ko load danh sách SV)
     - fetch = FetchType.EAGER: Khi vừa new Major ở trong RAM đọc từ DB lên, nó đọc 10k SV bỏ vào trong List<Student> luôn
     => FetchType.EAGER sẽ ảnh hưởng đến hiệu năng
    */
    @JoinColumn(name = "MajorId") // Tự tạo bên Table Many Student 1 cột FK tên là MajorId
    private List<Student> students = new ArrayList<Student>();
    // Để có cụ thể SV nào, ta gọi students.add(new Student("SE1", "AN", ...))

    // Hàm add Student vào List, public
    public void addStudent(Student obj) {
        // if else logic kiểm soát info bên ngoài đi vào trong Object
        students.add(obj);
    }

    public Major() {
    }

    public Major(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
