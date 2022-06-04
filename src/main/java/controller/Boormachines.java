package controller;

import java.util.ArrayList;

public class Boormachines extends Product{
    private String merk;

    public String getMerk() {
        return merk;
    }

    public String getType() {
        return type;
    }

    private String type;

    public Boormachines(boolean opVoorraad, double huurprijsPerDag, String merk, String type, double verzekering, String soort, String doorVerhuurd, String aanVerhuurd) {
        super(opVoorraad, huurprijsPerDag, verzekering, soort, doorVerhuurd, aanVerhuurd);
        this.merk = merk;
        this.type = type;
    }

    public static ArrayList<Boormachines> getBoormachinesList() {
        return boormachinesList;
    }

    private static ArrayList<Boormachines> boormachinesList = new ArrayList<>();
}