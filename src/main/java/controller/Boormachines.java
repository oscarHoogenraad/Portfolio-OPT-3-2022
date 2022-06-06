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

    @Override
    void soortProductMessage(){
        System.out.println("Dit product valt onder het soort product: Boormachine");
    }
}
