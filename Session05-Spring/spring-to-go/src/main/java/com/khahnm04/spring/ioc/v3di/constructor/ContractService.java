package com.khahnm04.spring.ioc.v3di.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class ContractService {

    // Tui xử lý hợp đồng là việc chính, thêm generator PDF, Excel
    // Cần 2 dependence: Repo, Generator (Excel, Document Gen)
    private PdfGenerator pdfGenerator; // ko new, chờ tiêm tự động

    public ContractService() {} // Constructor rỗng, default, explicit CTOR

    // Tiêm/chích vào, new ở đâu ko cần biết - new từ IoC container
    @Autowired // Tiêm/chích vào 1 cái bean khác qua Constructor
    public ContractService(PdfGenerator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }

    // => Nếu class có nhiều Constructor,bắt buộc phải có @Autowired ở chỗ tiêm/chích vào, để dùng Constructor có tham số ở chỗ tiêm vào

    // Xài dependency dc chích vào
    public void processContract() {
        // todo: Xử lý logic hợp đồng, repo xuống DB

        // gen file
        pdfGenerator.generatorFile("20250615000006789_hehehe");
    }

}
