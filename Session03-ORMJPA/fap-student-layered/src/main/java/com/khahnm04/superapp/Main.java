package com.khahnm04.superapp;

import com.khahnm04.superapp.entity.Student;
import com.khahnm04.superapp.service.StudentService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Flow: UI (here) -> SERVICE -> REPO -> JpaUtil (Entity-Manager và Factory) -> TABLE

        StudentService studentService = new StudentService();

        // 1. Tạo mới hồ sơ sinh viên
//        Student an = new Student("SE10", "AN NGUYỄN", 2005, 8.6);
//        studentService.createStudent(an);
//        studentService.createStudent(new Student("SE11", "BÌNH LÊ", 2005, 8.7));

        // 2. Show All
        System.out.println("The list student");
        studentService.getAllStudents().forEach(x -> System.out.println(x));

        // 3. Update 1 hồ sơ SV
//        Student an = new Student("SE10", "AN NGUYEN VAN", 2005, 9.2);
//        studentService.updateStudent(an);
//        System.out.println("The list students after updating");
//        studentService.getAllStudents().forEach(x -> System.out.println(x));

        // 4. Remove 1 hồ sơ SV
        studentService.deleteStudent("SE11");
        System.out.println("The list students after deleting");
        studentService.getAllStudents().forEach(x -> System.out.println(x));

    }

}