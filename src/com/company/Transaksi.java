package com.company;

import java.time.LocalDate;

public class Transaksi {
    static int nextNoTrans = 1;
    int noTransaksi;
    Rekening noRek;
    LocalDate tgl;
    char operasi;
    double jmlTrans;

    public Transaksi(Rekening noRek, LocalDate tgl, char operasi, double jmlTrans) {
        this.noTransaksi = nextNoTrans++;
        this.noRek = noRek;
        this.tgl = tgl;
        this.operasi = operasi;
        this.jmlTrans = jmlTrans;
    }

    public static int getNextNoTrans() {
        return nextNoTrans;
    }

    public static void setNextNoTrans(int nextNoTrans) {
        Transaksi.nextNoTrans = nextNoTrans;
    }

    public int getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(int noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public Rekening getNoRek() {
        return noRek;
    }

    public void setNoRek(Rekening noRek) {
        this.noRek = noRek;
    }

    public LocalDate getTgl() {
        return tgl;
    }

    public void setTgl(LocalDate tgl) {
        this.tgl = tgl;
    }

    public char getOperasi() {
        return operasi;
    }

    public void setOperasi(char operasi) {
        this.operasi = operasi;
    }

    public double getJmlTrans() {
        return jmlTrans;
    }

    public void setJmlTrans(double jmlTrans) {
        this.jmlTrans = jmlTrans;
    }

    @Override
    public String toString() {
        return "Transaksi{" +
                "noTransaksi=" + noTransaksi +
                ", noRek=" + noRek +
                ", tgl=" + tgl +
                ", operasi=" + operasi +
                ", jmlTrans=" + jmlTrans +
                '}';
    }
}
