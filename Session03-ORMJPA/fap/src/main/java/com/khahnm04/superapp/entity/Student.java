package com.khahnm04.superapp.entity;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

// Class này sẽ dc khai báo để ánh xạ/biến đổi tương đương, map thành table tương ứng
@Entity
@Table(name = "Student") // nếu ko có khai báo này, thì mặc định lấy tên class thành tên table
public class Student {

    @Id
    @Column(name = "Id") // nếu ko có khai báo này thì mặc định lấy tên field là tên cột
    private String id; // camelCase, id tự nhập (id tự tăng tính sau)

    @Column(name = "Name",  nullable = false, length = 50)
    @Nationalized // Thiếu khai báo này thì spring sẽ biến thành varchar -> ko lưu dc tiếng việt có dấu. Để String là nvarchar thì cần thêm khai báo @Nationalized
    // Nếu ko, tiếng việt sẽ ra dấu ? thay thế cho dấu '\?/
    private String name;

    @Column(name = "Yob",  nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private double gpa;

    // Bắt buộc phải có constructor rỗng, constructor full tham số
    // getter()/setter()/toString()
    // Boiler-plate, Lombok
    // Thêm dependency lombok sau...

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
