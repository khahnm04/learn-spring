package com.khahnm04.heath.core;

public class BmiCalculator {

    // hàm static tính số khối cơ thể dựa trên chiều cao và cân nặng
    // bmi = cân nặng (kg) / chiều cao (m) bình phương
    //bmi < 18.5 ốm; bmi 18.5 ... 24.9 -> chuẩn form, > 25 béo, béo phì ...
    public double getBmi(double weight, double height) {
        return weight / (height * height);
    }

}
