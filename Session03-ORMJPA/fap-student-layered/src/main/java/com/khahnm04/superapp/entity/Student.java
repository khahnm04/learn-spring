package com.khahnm04.superapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student") // nếu muốn đặt tên table khác tên class
public class Student {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)")
    private String id; // Key tự tăng là Long id

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", length = 50,  nullable = false)
    // @Nationalized // hard-coded với hibernate đều ra nvarchar(50)
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private double gpa;

    // Constructor rỗng, full tham số, nếu key tự tăng thì ko dc đưa vào constructor
    // getter(), setter(), toString()
    // Có thể dùng Lombok để tránh Boiler-plate

    public Student() {
    }

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
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", gpa=" + gpa +
                '}';
    }

}
