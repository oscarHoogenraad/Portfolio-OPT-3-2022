package controller;

import java.util.Scanner;

public class ProductHuren {
    public ProductHuren(boolean verhuurd, int kwantiteit, int tijdInWeken, boolean kortingsCode) {
        this.verhuurd = verhuurd;
        this.kwantiteit = kwantiteit;
        this.tijdInWeken = tijdInWeken;
        this.kortingsCode = kortingsCode;
    }

    public boolean isVerhuurd() {
        return verhuurd;
    }

    public boolean verhuurd;
    public int kwantiteit;

    public int getKwantiteit() {
        return kwantiteit;
    }

    public int getTijdInWeken() {
        return tijdInWeken;
    }

    public boolean getKortingsCode() {
        return kortingsCode;
    }

    public int tijdInWeken;
    public boolean kortingsCode;

    public boolean keuzeKlant(boolean verhuurd, int kwantiteit, int tijdInWeken, boolean kortingsCode) {
        boolean keuze = false;
        if ((verhuurd = true) && kwantiteit >= 1 && tijdInWeken >= 1 && tijdInWeken <= 24) {
            System.out.printf("Uw aanvraag is succesvol verwerkt!");
            keuze = true;
        }
        else if(verhuurd = false){
            System.out.printf("Uw aanvraag is niet verwerkt!");
            return false;
        }
        return keuze;
    }

}
