package controller.models;

public abstract class AccountDetails {

    private String naam;
    private int nummer;
    private boolean admin;

    public void laadGegevens(){
        laadNaam();
        laadNummer();
        laadAdmin();
    }

    abstract void laadNaam();
    abstract void laadNummer();
    abstract void laadAdmin();

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
