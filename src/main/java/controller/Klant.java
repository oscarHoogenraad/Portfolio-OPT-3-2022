package controller;

import java.util.ArrayList;

public class Klant {
    public Klant(String voornaam, String achternaam){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
    }

    public static ArrayList<Klant> getKlantList() {
        return klantList;
    }

    private static ArrayList<Klant> klantList= new ArrayList<>();

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    private String voornaam;
    private String achternaam;
}
