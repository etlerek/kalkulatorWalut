package com.company;


public class Main {

    public static void main(String[] args) {

        WczytajURL obj = WczytajURL.getInstance();

        obj.odswiez();

        for (int i = 0; i < obj.waluty.length; i++){
            System.out.println(obj.waluty[i].wyswietl());
        }

        Kalkulator kalkulator = new Kalkulator();
        kalkulator.setWaluta1(obj.waluty[0]);
        kalkulator.setWaluta2(obj.waluty[1]);
        kalkulator.print();

    }
}
