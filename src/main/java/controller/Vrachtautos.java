package controller;

import java.util.ArrayList;

public class Vrachtautos extends Product{
    private double laadvermogen;

    public double getLaadvermogen() {
        return laadvermogen;
    }

    public double getGewicht() {
        return gewicht;
    }

    private double gewicht;
    public Vrachtautos(boolean opVoorraad, double huurprijsPerDag, double verzekering, double laadvermogen, double gewicht, String soort, String doorVerhuurd, String aanVerhuurd) {
        super(opVoorraad, huurprijsPerDag, verzekering, soort, doorVerhuurd, aanVerhuurd);
        this.laadvermogen=laadvermogen;
        this.gewicht=gewicht;
    }

    public static ArrayList<Product> getVrachtautosList() {
        return vrachtautosList;
    }

    private static ArrayList<Product> vrachtautosList = new ArrayList<>();

}