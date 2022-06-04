package controller;

public abstract class Product {
    public void setOpVoorraad(boolean opVoorraad) {
        this.opVoorraad = opVoorraad;
    }

    private boolean opVoorraad;

    public void setHuurprijsPerDag(double huurprijsPerDag) {
        this.huurprijsPerDag = huurprijsPerDag;
    }

    private double huurprijsPerDag;

    public void setVerzekering(double verzekering) {
        this.verzekering = verzekering;
    }

    private double verzekering;
    private String soort;

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

    private String doorVerhuurd;
    private String aanverhuurd;

    public double getVerzekering() {
        return verzekering;
    }

    public String getSoort() {
        return soort;
    }

    public Product(boolean opVoorraad, double huurprijsPerDag, double verzekering, String soort, String doorVerhuurd, String aanverhuurd) {
        this.opVoorraad = opVoorraad;
        this.huurprijsPerDag = huurprijsPerDag;
        this.verzekering = verzekering;
        this.soort = soort;
        this.doorVerhuurd = doorVerhuurd;
        this.aanverhuurd = aanverhuurd;
    }

    public void changeVoorraad(){
        this.opVoorraad=false;
    }


    public boolean isOpVoorraad() {
        return opVoorraad;
    }

    public double getHuurprijsPerDag() {
        return huurprijsPerDag;
    }




}
