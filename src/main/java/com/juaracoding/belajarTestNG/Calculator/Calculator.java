package com.juaracoding.belajarTestNG.Calculator;

public class Calculator {
    // Method ini berfungsi untuk penambahan
    public static int add(int a, int b) {
        return a + b;
    }

    // Method ini berfungsi untuk pengurangan
    public static int substract(int a, int b) {
        return a - b;
    }

    // Method ini berfungsi untuk perkalian
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Method ini berfungsi untuk pembagian
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Pembagian dengan 0 tidak boleh dilakukan");
        }
        return a / b;
    }

    // Method ini berfungsi untuk mencari sisa hasil pembagian
    public static int modulus(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Pembagian dengan 0 tidak boleh dilakukan");
        }
        return a % b;
    }

    // Method ini berfungsi untuk memperoleh BMI
    public static int bodyMassIndex(double kgWeight, double cmHeight) {
        if (cmHeight <= 0) {
            throw new ArithmeticException("Tinggi badan tidak boleh kurang dari atau sama dengan 0");
        }
        return (int) ((kgWeight / Math.pow(cmHeight / 100, 2)));
    }
}
