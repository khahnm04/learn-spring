package com.khahnm04.spring.noioc;

public class MainNoIoC {

    // nơi tạo ra object, tạo ra dependency, tiêm chích vào trong object chính
    // IoC container - Inversion of Control container
    // em kiểm soát những đứa phụ thuộc, em chích tiêm chúng vào cho anh
    // IOC HANDMADE TỰ TRỒNG, CHUA PHẢI HÀNG XIN ĐẾN TỪ SPRING
    public static void main(String[] args) {
        PdfGenerator pdfGenerator = new PdfGenerator();
        // ContractService contractService = new ContractService(new PdfGenerator());
        ContractService contractService = new ContractService(pdfGenerator); // tiêm vào
        contractService.processContract();
    }

}
