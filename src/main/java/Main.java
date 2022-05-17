import controller.Account;
import controller.LoginVenster;
import controller.Product;

public class Main {
    public static void main(String[] args) {
        Account a = new Account("a", "a", 1);
        Account b = new Account("b", "b", 2);
        JavaFXApp.main(args);
    }
}
