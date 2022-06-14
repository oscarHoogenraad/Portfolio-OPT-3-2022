package controller.models;

public class Medewerker extends Account {
    public Medewerker(String username, String password, int userNumber) {
        super(username, password, userNumber);
    }

    @Override
    public boolean check(Account medewerker) {
        medewerker.setKeuzeAdmin(medewerker.getUsername().contains("~"));
        return medewerker.isKeuzeAdmin();
    }
}
