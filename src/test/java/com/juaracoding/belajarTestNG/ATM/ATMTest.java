package com.juaracoding.belajarTestNG.ATM;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATMTest {
    // Field ini digunakan untuk objek ATM yang akan diuji
    private ATM atm;

    // Method ini digunakan untuk inisialisasi objek ATM sebelum setiap test
    @BeforeMethod
    public void setUp() {
        atm = new ATM(1000);
    }

    // Tes lihat saldo
    @Test
    public void testLihatSaldo() {
        double actualResult = atm.lihatSaldo();
        double expectedResult = 1000;
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Tes setor uang 1000, seharusnya 1000 + 1000 = 2000
    @Test
    public void testSetorUang() {
        atm.setorUang(1000);
        double actualResult = atm.lihatSaldo();
        double expectedResult = 2000;
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Tes setor uang negatif, seharusnya saldonya tetap 1000
    @Test
    public void testSetorUangNegatif() {
        try {
            atm.setorUang(-1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        double actualResult = atm.lihatSaldo();
        double expectedResult = 1000;
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Tes tarik uang, seharusnya 1000 - 1000 = 0
    @Test
    public void testTarikUang() {
        atm.tarikUang(1000);
        double actualResult = atm.lihatSaldo();
        double expectedResult = 0;
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Tes tarik uang melebihi saldo, seharusnya saldo tetap 1000
    @Test
    public void testTarikUangLebihDariSaldo() {
        try {
            atm.tarikUang(1001);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        double actualResult = atm.lihatSaldo();
        double expectedResult = 1000;
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Tes tarik uang negatif, seharusnya saldo tetap 1000
    @Test
    public void testTarikUangNegatif() {
        try {
            atm.tarikUang(-1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        double actualResult = atm.lihatSaldo();
        double expectedResult = 1000;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
