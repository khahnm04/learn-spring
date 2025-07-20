package com.khahnm04.spring.ioc.v4di.setterorfield;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("minhKhanh") // như là new chủ động trong AppConfig class - dc quyền chủ động tên, tham số của constructor
public class ContractService {

    @Autowired // Spring chơi trò Reflection, tiêm vào field
    private PdfGenerator pdfGenerator; // ko new, chờ tiêm/chích vào

    // ko làm constructor thì sẽ có constructor rỗng

    // hàm setter() để tiêm/chích vào (giống setter bình thường như setName(), setYYob(),...)
    // tiêm chích vào -> có cần Autowired
    // Chơi setter bắt buộc phải có @Autowired vì nó là hàm thường, ko bị ép phải gọi ngay lúc tạo Object giống constructor, do đó khiến thằng dependency có thể bị null
    // người ta hay chọn: tiêm/chích qua constructor vì khởi tạo ngay lúc tạo Object, set() mang ý nghĩa chỉnh sửa sau này
    //@Autowired
    public void setPdfGenerator(PdfGenerator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    } // null problem may be

    public void processCntract() {
        // todo: logic xử lý contract
        pdfGenerator.generatorFile("21:48"); // có nguy cơ bị null do chưa set() mà ko đi qua constructor
    }

}
