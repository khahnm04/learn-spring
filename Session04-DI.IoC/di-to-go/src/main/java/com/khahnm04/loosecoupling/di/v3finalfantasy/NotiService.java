package com.khahnm04.loosecoupling.di.v3finalfantasy;

public interface NotiService {

    // hàm ko có code, chờ ae, member, class con thực thi và triển khai
    // hàm này chính là hợp đồng, contract mà ae phải tuân thủ
    public void sendNoti(String to, String message);

}

//INTERFACE LÀ 1 CLASS CHA, KO CÓ CODE TRONG CÁC HÀM (ABSTRACT METHOD), Sau này có code nhưng nó lạ lắm!
//VỀ LÍ THUYẾT, KO CÓ CODE THÌ KO NEW ĐC OBJECT VÌ NEW XONG, CHẤM GỌI HÀM, HÀM KO CÓ CODE, LẤY GÌ MÀ CHẠY
//VỀ THỰC TẾ, INTERFACE ĐC VÍ NHƯ CLB, HỘI NHÓM, GROUP, KHI NÓ TỤ TẬP ANH EM CÙNG CHÍ HƯỚNG, CÙNG THEO NỘI QUY, QUY TẮC MÀ CLB ĐƯA RA YÊU CẦU ANH EM MEMBER PHẢI TUÂN THỦ
//ANH EM TUÂN THỦ, LÀM THEO CACH CỦA MOI NGUOI, GOI LA IMPLEMENT - THI TRIEN, TRIEN KHAI
// Nó sẽ móc sang nguyên lí: Tính đa hình - Polymorphism, từ 1 ra nhiều
