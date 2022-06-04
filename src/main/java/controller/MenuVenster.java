package controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuVenster extends NavigationController implements Initializable {

    @FXML
    public AnchorPane rootPane;

    @FXML
    private Label displayIngelod;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(Account.ingelogdeUser().isIngelogd()){
            displayIngelod.setText(Account.ingelogdeUser().getUsername());
        }
    }
}
