import controller.*;

public class Main {
    public static void main(String[] args) {
        Account a = new Medewerker("jan123~", "123", 1);
        Account b = new Medewerker("klaas66", "66", 2);
        Account c = new Medewerker("admin1~", "1", 3);
        Account d = new Medewerker("piet22", "22", 4);
        JavaFXApp.main(args);
    }
}
