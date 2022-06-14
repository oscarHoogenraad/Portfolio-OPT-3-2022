package controller.models;

public class Personenautos extends Product {

    private String merk;
    private double gewicht;

    public Personenautos(boolean opVoorraad, double huurprijsPerDag, String merk, double gewicht, double verzekering, String soort, String doorVerhuurd, String aanVerhuurd) {
        super(opVoorraad, huurprijsPerDag, verzekering, soort, doorVerhuurd, aanVerhuurd);
        this.merk=merk;
        this.gewicht=gewicht;
    }

    public String getMerk() {
        return merk;
    }

    public double getGewicht() {
        return gewicht;
    }

    @Override
    public void soortProductMessage(){
        System.out.println("Dit product valt onder het soort product: Personenauto");
    }
}
