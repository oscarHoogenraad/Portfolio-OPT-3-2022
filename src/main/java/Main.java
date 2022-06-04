import controller.Account;
import controller.LoginVenster;
import controller.Personenautos;
import controller.Product;

public class Main {
    public static void main(String[] args) {
        Account a = new Account("jan123", "123", 1);
        Account b = new Account("klaas66", "66", 2);
        Account c = new Account("admin1", "1", 3);
        Account d = new Account("piet22", "22", 4);
        Account e = new Account("", "", 5);
        JavaFXApp.main(args);
    }
}
