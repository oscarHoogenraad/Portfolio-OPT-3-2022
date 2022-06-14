package controller;
import controller.models.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class LoginVenster extends NavigationController {

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

    public void loginCheck() throws IOException {
        for(Account i: Account.getAccountList()){
            if(userName.getText().equals(i.getUsername())&& passWord.getText().equals(i.getPassword())&& Integer.parseInt(gebruikersNummer.getText()) == i.getUserNumber() ){
                i.setIngelogd(true);
                toMenu();
            }
            else{
                failedLogin.setVisible(true);
            }
        }
    }
}
