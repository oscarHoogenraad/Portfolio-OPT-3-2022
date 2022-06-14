package controller;
import controller.models.Account;
import controller.models.Medewerker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuVenster extends NavigationController implements Initializable {

    LoginVenster ReliesOn;

    @FXML
    public AnchorPane rootPane;

    @FXML
    private Label displayIngelogd, welAdmin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(Account.ingelogdeUser().isIngelogd()){
            welAdmin.setVisible(false);
            displayIngelogd.setText(Account.ingelogdeUser().getUsername());
            displayAdmin();
        }
    }

    public void displayAdmin(){
        if(Medewerker.ingelogdeUser().check(Medewerker.ingelogdeUser())){
            welAdmin.setVisible(true);
        }
    }
}
