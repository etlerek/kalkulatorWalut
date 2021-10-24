package com.company;
public class Waluta {
    private Integer idWaluty;
    private String nazwaWaluty;
    private String przelicznik;
    private String kodWaluty;
    private String kursSredni;

    public Waluta(Integer idWaluty, String nazwaWaluty, String przelicznik, String kodWaluty, String kursSredni) {
        this.idWaluty = idWaluty;
        this.nazwaWaluty = nazwaWaluty;
        this.przelicznik = przelicznik;
        this.kodWaluty = kodWaluty;
        this.kursSredni = kursSredni;
    }

    public String wyswietl(){
        return getIdWaluty() + " " + getKodWaluty() + " " + getNazwaWaluty() + " " + getKursSredni() + " " + getPrzelicznik();
    }

    public String getNazwaWaluty() {
        return nazwaWaluty;
    }

    public Integer getIdWaluty() {
        return idWaluty;
    }

    public String getPrzelicznik() {
        return przelicznik;
    }

    public String getKodWaluty() {
        return kodWaluty;
    }

    public String getKursSredni() {
        return kursSredni;
    }

}
