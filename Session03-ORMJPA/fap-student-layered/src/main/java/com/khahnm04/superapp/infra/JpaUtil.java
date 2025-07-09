package com.khahnm04.superapp.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    /*
     - Class này chịu trách nhiệm kết nối CSDL thông qua đối tượng Entity-Manager-Factory
     - Hao RAM, Performance tốn thời gian để tạo kênh kết nối với SQL SERVER/MYSQL -> Heavy class
     - Nó nên được khởi tạo sớm, 1 lần, 1 instance, 1 vùng RAM, 1 Object -> Singleton Pattern
     - Chưa kể nó đc tạo ra, có khi nó tạo mới table luôn (Option create), hoặc scan lại cấu trúc table có thay đổi gì ko để cập nhật (Option update trong file .xml)
     - Kĩ thuật viết code mà khiến cho class ko new đc lần thứ 2, ko dc new nhiều Object, lỡ may gọi nhiều lần cái clas này, cũng chỉ có 1 vùng new đc tạo ra
     - static + private constructor
     - 1 class ko có constructor -> JVM sẽ tạo 1 cái CTOR rỗng, nên vẫn new đc
     - Cấm tạo Object từ mọi constructor: class ko có CTOR, và CTOR rỗng thì mình phế luôn
     => Singleton Pattern: xuất hiện duy nhất 1 lần và 1 chỗ trong RAM
    */

    private static final EntityManagerFactory emf;
    // Duy trì kêt nối tới CSDL, đọc file persistence.xml để create/update table
    // heavy load nằm ở biến này!!!

    // 1 đoạn lệnh trôi nổi, ko thuộc về hàm nào nhưng là chũ static thì đoạn lệnh này sẽ dc chạy 1 lần đầu tiên và duy nhất khi class này đc chạm đến
    // static {} dành cho việc khởi động gì đó mà ko phải constructor
    // Chỉ được khởi tạo 1 lần duy nhất trong RAM - tồn tại trong RAM suốt vòng đời của chương trình.
    static {
        try {
            // Load thông tin server từ file persistence.xml
            emf = Persistence.createEntityManagerFactory("com.khahnm04.superapp-PU");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Cấm new class này
    // Biến emf Factory chỉ có 1 con đường dc khởi tạo, khởi tạo 1 lần duy nhất qua đoạn lệnh static{} ở trên
    // Kĩ thuật singleton đã xong - 1 Object heavy Entity-Manager-Factory trong ram
    private JpaUtil() {
    }

    // Có ông nhà xưởng EntityManagerFactory rồi, đi mời các ông EntityManager về để quản lý @Entity
    // Hàm này thì nhóm repository sẽ gọi đến để nhờ vả xuống table
    // Vì nó là static nên chấm xài luôn. vd: JpaUtil.getEntityManager();
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Đóng cửa nhà máy, ko cần chơi với CSDL nữa, ko duy trì kết nối nữa khi app shutdown
    public static void shutdown() {
        emf.close();
    }

}
