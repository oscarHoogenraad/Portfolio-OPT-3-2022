package controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginVenster extends NavigationController implements Initializable {

    Account Uses;

    @FXML
    public AnchorPane rootPane;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField passWord;

    @FXML
    private Label failedLogin;

    @FXML
    private TextField gebruikersNummer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Account a = new Medewerker("jan123~", "123", 1);
        Account b = new Medewerker("klaas66", "66", 2);
        Account c = new Medewerker("admin1~", "1", 3);
        Account d = new Medewerker("piet22", "22", 4);
    }

    public void loginCheck() throws IOException {
        for(Account i: Account.getAccountList()){
            int tempNr = Integer.parseInt(gebruikersNummer.getText());
            if(userName.getText().equals(i.getUsername())&& passWord.getText().equals(i.getPassword())&& tempNr==i.getUserNumber() ){
                i.setIngelogd(true);
                toMenu();
            }
            else{
                failedLogin();
            }
        }
    }

    public void failedLogin(){
        failedLogin.setVisible(true);
    }
}
