package controller;

public abstract class Product {
    private double verzekering;
    private String soort;
    private boolean opVoorraad;
    private double huurprijsPerDag;
    private String doorVerhuurd;
    private String aanverhuurd;

    public Product(boolean opVoorraad, double huurprijsPerDag, double verzekering, String soort, String doorVerhuurd, String aanverhuurd) {
        this.opVoorraad = opVoorraad;
        this.huurprijsPerDag = huurprijsPerDag;
        this.verzekering = verzekering;
        this.soort = soort;
        this.doorVerhuurd = doorVerhuurd;
        this.aanverhuurd = aanverhuurd;
    }

    abstract void soortProductMessage();

    public void setOpVoorraad(boolean opVoorraad) {
        this.opVoorraad = opVoorraad;
    }

    public void setHuurprijsPerDag(double huurprijsPerDag) {
        this.huurprijsPerDag = huurprijsPerDag;
    }

    public String getDoorVerhuurd() {
        return doorVerhuurd;
    }

    public String getAanverhuurd() {
        return aanverhuurd;
    }

    public void setDoorVerhuurd(String doorVerhuurd) {
        this.doorVerhuurd = doorVerhuurd;
    }

    public void setAanverhuurd(String aanverhuurd) {
        this.aanverhuurd = aanverhuurd;
    }

    public double getVerzekering() {
        return verzekering;
    }

    public String getSoort() {
        return soort;
    }

    public boolean isOpVoorraad() {
        return opVoorraad;
    }

    public double getHuurprijsPerDag() {
        return huurprijsPerDag;
    }
}
