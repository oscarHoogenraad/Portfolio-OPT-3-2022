import controller.OverzichtsVenster;
import controller.models.*;

public class Main {
    public static void main(String[] args) {
        Account a = new Admin("jan123", "123", 1, true);
        Account b = new Medewerker("klaas66", "66", 2, false);
        Account c = new Admin("admin1", "1", 3, true);
        Account d = new Medewerker("piet22", "22", 4, false);
        JavaFXApp.main(args);
    }
}
