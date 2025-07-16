package com.khahnm04.superapp.entity.bidirectional;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Major")
public class Major {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(2)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(80)", nullable = false)
    private String name;

    /*
     * 1 chuyên ngành có nhiều student, tức là major phải chứa 1 arraylist student
     * mappedBy giúp kết nối ngược với bạn Student, để biết cái major bạn ấy đang giữ có major.id khớp với id đang đứng hay ko
     * Major nối với Student qua đặc tính Major major bn Student => Object quan hệ với nhau, đúng chuẩn OOP: chỉ Object mà thôi
     * Tôi chứa danh sách của anh, nhưng tôi ko sở hữu JoinColumn, vì JoinColumn tôi để dành cho anh (bên many) rồi => Tôi ko biết móc sang anh kiêu nào
    */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "major")
    private List<Student> stuList =  new ArrayList<>();

    /*
     * stuList.add(đua 1 SV vào Major)
     * stuList.remove(1 SV đổi chuyên ngành)
     * viết code ở đâu với 2 lệnh này??? nguyên lí s trong s.o.l.i.d (srp - single responsibility principle)
     * thêm xóa SV khỏi chuyên ngành, là việc của major, thì phải major, vì chuyên ngành có nhiều SV, việc SV vào ra là việc của major
     => 2 hàm xóa, nhập SV thuộc class này
     */
    public void addStudent(Student obj){
        /*
         * stuList.add(obj); -> 1 SV đã tham gia vào chuyên ngành này
         * Nhưng chưa nói đc SV obj đang có thực sự trỏ về, lưu info chuyên ngành hay ko, info major của SV chưa đc set giá trị
         * Ta cần 2 câu: major có sinh viên gia nhập -> done qua lênh stuList.add(obj);
         * Student thuộc về Major này (this) -> done: obj.setMajor(this);
         * SV obj trỏ thằng vào major đang đứng nè nè this có đủ info id, name của
         */
        stuList.add(obj);
        obj.setMajor(this);
    }

    public void removeStudent(Student obj){
        stuList.remove(obj); // 1 SV đã đổi ngành (sang ngành nào chưa biết, nhưng ko còn trong List này)
        obj.setMajor(null); // Tạm thời SV ko còn vào ngành trước đó -> giờ là null (chưa trỏ chuyên nào)
    }

    /*
     * DB: Có câu query trong DB: chuyên ngành SE có bao nhiêu Student (SELECT * FROM Student WHERE Major = 'SE')
     * OOP: Major này đang có danh sách SV List Student, mình return là xong!!!
    */
    public List<Student> getStudentList(){
        return stuList;
    }

    public Major() {}

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
        return String.format("|%2s|%-40s|", id, name);
    }

}
