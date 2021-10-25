package com.company;

public class Waluta implements IWaluta {
    private Integer idWaluty;
    private String nazwaWaluty;
    private Integer przelicznik;
    private String kodWaluty;
    private Double kursSredni;

    public Waluta(Integer idWaluty, String nazwaWaluty, String przelicznik, String kodWaluty, String kursSredni) {
        this.idWaluty = idWaluty;
        this.nazwaWaluty = nazwaWaluty;
        this.przelicznik = Integer.parseInt(przelicznik);
        this.kodWaluty = kodWaluty;
        this.kursSredni = Double.parseDouble(kursSredni.replace(",","."));
    }

    public Integer getIdWaluty() {
        return idWaluty;
    }

    @Override
    public String getNazwaWaluty() { return nazwaWaluty; }

    @Override
    public Integer getPrzelicznik() {
        return przelicznik;
    }

    @Override
    public String getKodWaluty() {
        return kodWaluty;
    }

    @Override
    public Double getKursSredni() {
        return kursSredni;
    }

    @Override
    public String wyswietl(){
        return getIdWaluty() + " " + getKodWaluty() + " " + getNazwaWaluty() + " " + getKursSredni() + " " + getPrzelicznik();
    }

}
