package com.khahnm04.superapp.entity.bidirectional;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(80)", nullable = false)
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private double gpa;

    /*
     * SV thuộc về 1 Major tại 1 thời điểm => Chỉ cần 1 biến Major, ko phải là Liist như bên kia
     * Cả Major và Student đều có quyền khai báo JoinColumn nếu dùng uni-directional relationship
     * Giờ làm bi-directional, 2 thằng nhìn qua lại với nhau, thì ta trả quyền giữ JoinColumn về thằng N cho nó giống như góc nhìn table
     */
    @ManyToOne
    @JoinColumn(name = "MajorId")
    private Major major;
    public Major getMajor() {
        return major;
    }

    // Phải set chuyên ngành cho bạn SV này qua hàm set()
    public void setMajor(Major major) {
        this.major = major;
    }

    public Student() {}

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
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
        return String.format("|%2s|%-40s|%4d|%4.1f|", id, name, yob, gpa);
    }

}
