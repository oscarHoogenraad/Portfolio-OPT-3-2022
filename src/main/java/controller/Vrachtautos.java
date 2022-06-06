package controller;

public class Vrachtautos extends Product{
    private double laadvermogen;
    private double gewicht;

    public Vrachtautos(boolean opVoorraad, double huurprijsPerDag, double verzekering, double laadvermogen, double gewicht, String soort, String doorVerhuurd, String aanVerhuurd) {
        super(opVoorraad, huurprijsPerDag, verzekering, soort, doorVerhuurd, aanVerhuurd);
        this.laadvermogen=laadvermogen;
        this.gewicht=gewicht;
    }

    public double getLaadvermogen() {
        return laadvermogen;
    }

    public double getGewicht() {
        return gewicht;
    }

    @Override
    void soortProductMessage(){
        System.out.println("Dit product valt onder het soort product: Vrachtauto");
    }
}
