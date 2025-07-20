package com.khahnm04.spring.ioc.v2bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Báo trùm cuối ApplicationContext vào đây tìm info để new các bean, quản lí chúng, tiêm chúng
//@ComponentScan("com.khahnm04.spring.ioc.v2bean") //ko quét luôn
public class AppConfig {

    // thì phải new bean ở đây
    //@Bean //object đc return từ hàm này, đi vào Container ngay
    //chủ động new là mình, chủ động đặt tên object, nhưng đưa obj cho Container
    //TÊN HÀM PHÁ CHUẨN VERB+OBJECT TRUYỀN THỐNG MÀ MANG Ý NGHIA TÊN BIẾN OBJECT, ĐỂ ĐC DÙNG NGẦM TRONG CONTAINER
    // Dùng tên hàm làm tên của biến Object
    @Bean("minhKhanh")
    public PdfGenerator pdfGenerator() {
        return new PdfGenerator(); //nếu bean/class gốc có constructor có tham số, DÙNG BEAN TỰ NEW, TỰ TRUYỀN ĐC THAM SỐ VÀO CONSTRUCTOR, SPRING SẾ THUA KHI KO BIẾT ĐƯA THAM SỐ THẾ NÀO
    }

//    @Bean
//    public DocumentGenerator pdfGenerator() {
//        return new PdfGenerator();
//    }
//
//    @Bean
//    public DocumentGenerator excelGenerator() {
//        return new ExcelGenerator();
//    }

}

// TODO: ĐIỀU GÌ XẢY RA NẾU TA CÓ 2 OBJECT CỦA CÙNG CLASS ???
// VÍ DỤ: PdfGenerator và ExcelGenerator đều là (implements) interface DocumentGenerator, xung đột 2 Object cùng kiểu cha (keyword: @Primary, @Qualifier) khi có nhiều bean cùng kiểu

/*
* @Bean là một đối tượng được quản lý bởi Spring IoC Container.
* Khi bạn đánh dấu một phương thức bằng @Bean, nghĩa là Spring sẽ gọi phương thức đó, lấy kết quả trả về (một object), rồi đăng ký object đó thành 1 bean trong container.
* @Bean giúp Spring quản lý object này như một singleton bean trong container.
* */
