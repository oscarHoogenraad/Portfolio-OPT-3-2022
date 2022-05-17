package controller;

import java.util.ArrayList;

public class Product {
    private String merk;
    private boolean opVoorraad;

    public Product(String merk, boolean opVoorraad, int huurprijsPerDag, double verzekering, int gewicht) {
        this.merk = merk;
        this.opVoorraad = opVoorraad;
        this.huurprijsPerDag = huurprijsPerDag;
        this.verzekering = verzekering;
        this.gewicht = gewicht;
    }

    public String getMerk() {
        return merk;
    }

    public boolean isOpVoorraad() {
        return opVoorraad;
    }

    public int getHuurprijsPerDag() {
        return huurprijsPerDag;
    }

    public double getVerzekering() {
        return verzekering;
    }

    public int getGewicht() {
        return gewicht;
    }

    public static ArrayList<Product> getPersonenautos() {
        return Personenautos;
    }

    private int huurprijsPerDag;
    private double verzekering;
    private int gewicht;

    private static ArrayList<Product> Personenautos= new ArrayList<Product>();


    public int Prijs(int gewicht){
        int prijs = 0;
        if(gewicht>1250&& gewicht<=2000){
            prijs+=100;
        }
        if(gewicht>2000){
            prijs+=250;
        }
        return prijs;
    }
}
