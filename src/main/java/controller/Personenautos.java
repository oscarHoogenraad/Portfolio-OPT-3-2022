package controller;

import java.util.ArrayList;

public class Personenautos extends Product {
    public String getMerk() {
        return merk;
    }

    public double getGewicht() {
        return gewicht;
    }

    private String merk;
    private double gewicht;

    public Personenautos(boolean opVoorraad, double huurprijsPerDag, String merk, double gewicht, double verzekering, String soort, String doorVerhuurd, String aanVerhuurd) {
        super(opVoorraad, huurprijsPerDag, verzekering, soort, doorVerhuurd, aanVerhuurd);
        this.merk=merk;
        this.gewicht=gewicht;
    }

    @Override
    void soortProductMessage(){
        System.out.println("Dit product valt onder het soort product: Personenauto");
    }


    public static ArrayList<Personenautos> getPersonenAutosList() {
        return personenAutosList;
    }

    private static ArrayList<Personenautos> personenAutosList = new ArrayList<>();

}
