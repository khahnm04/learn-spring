package com.khahnm04.superapp.entity.unimany;

import jakarta.persistence.*;

//@Entity
//@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private double gpa;

    // private String majorId // Khoá ngoại đó => SAI
    // Nghĩ sai: nghĩ theo style Table/CSDL -> Sai, tu duy OOP
    // Nghĩ đúng, tư duy OOP các Object có mối quan hệ
    // Tôi Student tham chiếu đến thông tin Major - Object
    // Có cách để convert từ OOP thành Table/FK, Join column -> ORM Mapping
    // Cần 1 thằng giúp ánh xạ 2 thế giới để tương thích: JPA/Hibernate

    @ManyToOne
    @JoinColumn(name = "MajorId")
    private Major major; // làm sao biến này dc set value để nói rằng SV này thuộc major nào??? -> Câu hỏi giống bên major của unione
    // hàm setMajor() để đưa 1 chuyên ngành cho sv đăng kí vào

    public Student() {
    }

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
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

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", gpa=" + gpa +
                '}';
    }

}
