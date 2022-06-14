package controller;
import controller.models.Account;
import controller.models.Medewerker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
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

    public void toegangBeheer() throws IOException {
        if(Account.ingelogdeUser().getUsername().contains("~")){
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/BeheerVenster.fxml"));
            rootPane.getChildren().setAll(pane);
        }
        else{
            System.out.println("U mag geen gebruik maken van het Beheerscherm omdat u geen admin bent.");
        }
    }

    public void displayAdmin(){
        if(Medewerker.ingelogdeUser().check(Medewerker.ingelogdeUser())){
            welAdmin.setVisible(true);
        }
    }
}
