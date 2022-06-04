package controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class BeheerVenster extends NavigationController implements Initializable {

    @FXML
    private Label displayIngelod;

    @FXML
    public AnchorPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(Account.ingelogdeUser().isIngelogd()){
            displayIngelod.setText(Account.ingelogdeUser().getUsername());
        }
    }

}

