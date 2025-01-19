package com.juaracoding.belajarTestNG.ATM;

public class ATM {
    private double saldo;

    public ATM(double saldo) {
        this.saldo = saldo;
    }

    public double lihatSaldo() {
        return saldo;
    }

    public void setorUang(double jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Tidak bisa setor kurang dari atau sama dengan 0");
        }
        saldo += jumlah;
        System.out.println("Uangmu sudah disetor sejumlah " + jumlah);
    }

    public void tarikUang(double jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Tidak bisa tarik kurang dari atau sama dengan 0");
        }
        if (jumlah > saldo) {
            throw new IllegalArgumentException("Saldo tidak cukup");
        }
        saldo -= jumlah;
        System.out.println("Ini uangmu " + jumlah);
    }
}
