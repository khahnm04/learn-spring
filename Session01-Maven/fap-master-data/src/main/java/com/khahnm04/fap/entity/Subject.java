package com.khahnm04.fap.entity;

// Class này dùng để lưu thông tin các môn học
public class Subject {

    private String code; // Mã môn học
    private String name; // Tên môn học
    private int credit; // Số tín chỉ
    private double hours; // Số giờ học

    // Khi chơi vơ table, tức là:
    // - class sẽ map thành cấu trc table
    // - new Subject("SWT301", "SOFTWARE TESTING", 3, 45);
    // Tương ứng với từng dòng trong table ~ INSERT INTO
    // CLASS Subject ~ TABLE Subject (đến từ ERD)
    // NEW Subject(...) ~ INSERT INTO Subject VALUES...

    // Bắt buộc class phải có những thứ sau khi chơi với CSDL
    // - contructor rỗng (empty contructor - CTOR) (Ko tham số, ko câu lệnh)
    // - CTOR full tham số (đổ toàn bộ info vào trong object)
    // - getter() setter()
    // - toString()

    // Phải chuột generate... -> chọn mục tương ứng
    // Toàn bộ đoạn code này rất quan trọng ví giúp ta tạo ra Object 1 cách linh họạt (tạo - new, chỉnh sửa - set, hỏi info - get, show info - tostring)
    // Nhưng nhàm chán, ko thèm tư duy gì thêm
    // Đoạn code nhàm chán, nhưng vẫn phải làm, ko thể thiếu -> gọi là 2 boiler plate !!!

    public Subject() {
    }

    public Subject(String code, String name, int credit, double hours) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.hours = hours;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", hours=" + hours +
                '}';
    }

}
