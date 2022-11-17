package com.company;

import java.util.Date;

public class Rekening {
    static int nextNoAkun = 10;
    int noRek;
    String pemilikRek;
    Kota kotaRek;
    char genderRek;
    double saldoRek;
    Date tglBukaAkun;

    public Rekening() {
    }

    public Rekening(String pemilikRek, Kota kotaRek, char genderRek) {
        this.noRek = nextNoAkun;
        nextNoAkun ++;
        this.pemilikRek = pemilikRek;
        this.kotaRek = kotaRek;
        this.genderRek = genderRek;
    }

    @Override
    public String toString() {
        return noRek +
                ", '" + pemilikRek +
                ", " + kotaRek +
                ", " + genderRek +
                ", " + saldoRek +
                ", " + tglBukaAkun;
    }

    //buat fungsi tabung
    public void tabung (double jmltabung){
        if (jmltabung > 0){
            saldoRek = saldoRek+jmltabung;
        }
    }

    //buat fungsi tarik
    public double tarik (double jmlTarik){
        if (jmlTarik > 0){
            if (jmlTarik>this.saldoRek){
                System.out.println("Saldo Anda Tidak mencukupi");
            } else {
                saldoRek=saldoRek-jmlTarik;
            }
            return saldoRek;
        }else {
            return saldoRek;
        }
    }
}

