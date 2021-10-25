package com.company;

import java.util.Scanner;

public class WyswietlWTerminalu {

    public boolean zamkniecie(){
        Scanner scan4 = new Scanner(System.in);
        System.out.println(" Jeżeli chcesz kontynuować wciśnij dowolny inny klawisz\n Aby zamknąć program wpisz n");
        String czyZamknac = scan4.next();
        if((czyZamknac).equalsIgnoreCase("n")){
            return false;
        }
        return true;
    }

    public void piszWTerminalu(){

        Kalkulator kalkulator = new Kalkulator();
        WczytajURL obj = WczytajURL.getInstance();
        obj.odswiez();

        boolean zapetlaj = true;

        while (zapetlaj) {

            obj.odswiez();

            for (int i = 0; i < WczytajURL.waluty.length; i++) {
                System.out.println(obj.waluty[i].wyswietl());
            }

            try {
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Podaj kod pierwszej waluty:");
                String nazwaWaluty1 = scan1.nextLine().toUpperCase();

                for (int i = 0; i < obj.waluty.length; i++) {
                    if (nazwaWaluty1.equals(obj.waluty[i].getKodWaluty())) {
                        kalkulator.setWaluta1(obj.waluty[i]);
                    }
                }

                Scanner scan2 = new Scanner(System.in);
                System.out.println("Podaj kod drugiej waluty:");
                String nazwaWaluty2 = scan2.nextLine().toUpperCase();


                if (nazwaWaluty2.equals(nazwaWaluty1)) {
                    System.out.println("Waluty sa takie same");
                    zapetlaj = zamkniecie();
                    if (zapetlaj == false) {
                        break;
                    }
                    continue;
                }

                for (int i = 0; i < obj.waluty.length; i++) {
                    if (nazwaWaluty2.equals(obj.waluty[i].getKodWaluty())) {
                        kalkulator.setWaluta2(obj.waluty[i]);
                    }
                }

                Scanner scan3 = new Scanner(System.in);
                System.out.println("Podaj ilosc waluty do przeliczenia:");
                Double iloscMonet = Double.valueOf(scan3.nextLine());
                if (iloscMonet <= 0){
                    iloscMonet *= -1;
                    System.out.println("Ilość monet nie może być ujemna, zamieniono znak naprzeciwny");
                }

                System.out.println();
                System.out.println(iloscMonet + " " + nazwaWaluty1 + " to " + kalkulator.licz(iloscMonet) + " " + nazwaWaluty2);
                System.out.println();
            }

            catch (NullPointerException e){
                System.out.println("Błąd! Podałeś walutę która nie istnieje, sprawdź ponownie poprawność wpisanego kodu waluty\n");
            }
            catch(NumberFormatException e){
                System.out.println("Błąd! Ilość waluty musi być liczbą");
            }
            catch (Exception e){
                System.out.println("Błąd! Spróbuj ponownie");
            }
            finally {

                kalkulator.setWaluta1(null);
                kalkulator.setWaluta2(null);
                zapetlaj = zamkniecie();
            }
        }

    }
}
