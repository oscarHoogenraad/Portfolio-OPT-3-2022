package controller.models;

public class Boormachines extends Product{
    private String merk;
    private String type;

    public Boormachines(boolean opVoorraad, double huurprijsPerDag, String merk, String type, double verzekering, String soort, String doorVerhuurd, String aanVerhuurd) {
        super(opVoorraad, huurprijsPerDag, verzekering, soort, doorVerhuurd, aanVerhuurd);
        this.merk = merk;
        this.type = type;
    }

    public String getMerk() {
        return merk;
    }

    public String getType() {
        return type;
    }
}