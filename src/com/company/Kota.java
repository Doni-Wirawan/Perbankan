package com.company;

public class Kota {
    String namaKota;
    String namaKab;

    public Kota(String namaKota, String namaKab) {
        this.namaKota = namaKota;
        this.namaKab = namaKab;
    }

    @Override
    public String toString() {
        return namaKota + "-" + namaKab;
    }
}
