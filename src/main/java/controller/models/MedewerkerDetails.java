package controller.models;

public class MedewerkerDetails extends AccountDetails{
    @Override
    void laadNaam() {
        setNaam(Account.ingelogdeUser().getUsername());
    }

    @Override
    void laadNummer() {
        setNummer(Account.ingelogdeUser().getUserNumber());
    }

    @Override
    void laadAdmin() {
        setAdmin(Account.ingelogdeUser().isKeuzeAdmin());
    }
}
