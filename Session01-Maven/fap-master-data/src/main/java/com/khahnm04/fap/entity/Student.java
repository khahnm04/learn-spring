package com.khahnm04.fap.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
// @Getter + @Setter + @ToString = @Data
public class Student {

    private String id;
    private String name;
    private int yob; // year of birth, năm sinh
    private double gpa; // Điểm TB

    // Đoạn code BOILER PLATE nhàm chán: 2 CTOR, get/set, toString
    // Ta ko thàm làm theo cách truyền thống, nhưng vẫn phải làm theo cách nào đó
    // => Ta dùng thêm 1 thư viện trên mạng giúp ta generate đám này 1 cách tự động -> Lombok dependency
    // Lombok là hàng a e mang, ko phải chính hãng jdk
    // C# thì có hàng chính hãng -> gọi là kĩ thuật property có sẵn trong .net sdk
    // Ta đi tải thư viện lombok qua file pom.xml
    // Thư viện tự được add vào project, ta chỉ việc xài các class có trong thư viện tải về!!!
    // lên kho trong mvnrepository.com -> tìm thư viện, tìm hồ sơ, add vào pom.xml -> click ctrl - shift - o để tải và add


}
