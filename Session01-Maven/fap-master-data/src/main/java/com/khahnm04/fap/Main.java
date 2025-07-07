package com.khahnm04.fap;

//import com.khahnm04.fap.entity.Student;
//import com.khahnm04.fap.entity.Subject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.khahnm04.fap.entity.*; // Khỏi khai báo lẻ

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        // Tạo mới môn học
        Subject swt = new Subject ("SWT301", "SOFTWARE TESTING", 3, 45) ;
        Subject hsf = new Subject ("HSF302", "HIBERNATE & SPRING FRAMEWORK", 3, 45);

        // Show info 2 môn
        System.out.println("SWT INFO: " + swt.toString());
        System.out.println("HSF INFO: " + hsf);

        // Tạo mới hồ sơ sinh viên
        Student an = new Student("SE1", "AN NGUYỄN", 2004, 8.6);
        Student binh = new Student("SE2", "BÌNH LÊ", 2004, 8.7);

        // Show info 2 bạn SV
        System.out.println("AN: " + an.toString());
        System.out.println("BINH: " + binh);

        // Chơi với json, từ object -> json và ngược lại
        // Cần tạo Object quản lý json từ thư viện jackson
        // object -> json, BE -> FE, tao (server) móc từ database lên cho mày chuỗi json nè
        ObjectMapper mapper = new ObjectMapper();
        String anJson = mapper.writeValueAsString(an);
        System.out.println("Lần đâu tiên chuyển json -> object: " +  anJson);

        // json -> object, FE -> BE, tao có form nhập, user submit info, tao gửi mày be json, mày lo thành object đi, để xuống db
        // String cuongJson = "{\"id\":\"SE2\",\"name\":\"CƯỜNG NGUYỄN\",\"yob\":2004,\"gpa\":8.8}";
        String cuongJson = """
                {"id":"SE2","name":"CƯỜNG NGUYỄN","yob":2004,"gpa":8.8}""";
        //jdk 15, Raw String: có sao lưu vậy, có kí tự đặc biệt, giữ nguyên
        // Student cuong = new Student(...); // ai chơi kì vậy
        Student cuong = mapper.readValue(cuongJson, Student.class); // Đưa chuỗi convert thành object thuộc class nào???
        System.out.println("CUONG JSON: " + cuong.toString());


    }
}

/*
json: javascript object notation
kĩ thuật biểu diễn thông tin của 1 object theo cú pháp ngôn ngữ javascript
c#, java: object có dạng như sau
new subject("swt301", "software testing", 3, 45);
new student("se1", "an nguyen", 2004, 8.6);
code trên là 1 môn học cụ thể, 1 bạn sv cụ thể, nhưng nhìn text không dễ hiểu, không tự mô tả - self explanation
khó hiểu con số 3, 45, 8.6 nghĩa là gì, đoán thôi

javascript thì more self explanation, nhìn em, hiểu em liền
{"code": "SWT301", "name": "SOFTWARE TESTING", "credits":3, "hours":45}
{"id": "SE1", "name": "AN NGUYEN", "yob":2004, "gpa":8.6}

=> Trở thành chuẩn chuyển thông tin, nhiêu đây là tự hiểu, ko cần giải thích thêm.
Đặc biệt ưa thích trong web api
trong mô hình làm web app 2 cực fe và be
front-end --- json --- back-end
Axios (reactJS)

trong code thì toàn object
ra ngoài trên mạng, http thì là json
cần 1 thư viện để giúp convert qua lại json --- object
jackson, gson xuất hiện
*/
