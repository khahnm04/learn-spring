package com.khahnm04.spring.noioc;

public class ContractService {

    // Code chính và lo CRUD table contract qua Repo, sau đó generate pdf, nhờ PdfGenerator giúp, vậy PdfGenerator là dependency và tự new ở đây, hoặc phải dc truyền vào - chích/tiêm vào
    private PdfGenerator gen; // new là style tight coupling

    // Tiêm/chích dependency qua constructor
    public ContractService(PdfGenerator gen) {
        this.gen = gen;
    }

    public void processContract() {
        // todo: logic xử lý hợp đồng

        //generator pdf
        gen.generatorFile("20250615190000006789"); // hard-code
    }

    // Tiêm/chích qua setter()

}
