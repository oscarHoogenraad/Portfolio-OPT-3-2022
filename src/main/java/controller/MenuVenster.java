package controller;
import controller.models.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Label displayIngelogd, welAdmin, naamdisplay, nummerDisplay, adminDisplay;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(Account.ingelogdeUser().isIngelogd()){
            welAdmin.setVisible(false);
            displayIngelogd.setText(Account.ingelogdeUser().getUsername());
            displayAdmin();
            informatieIngelogdeAccount();
        }
    }

    public void informatieIngelogdeAccount(){
        if(Account.ingelogdeUser().isKeuzeAdmin()){
            AccountDetails admin = new AdminDetails();
            admin.laadGegevens();
            naamdisplay.setText(admin.getNaam());
            nummerDisplay.setText(String.valueOf(admin.getNummer()));
            adminDisplay.setText(String.valueOf(admin.isAdmin()));
        }
        else{
            AccountDetails medewerker = new MedewerkerDetails();
            medewerker.laadGegevens();
            naamdisplay.setText(medewerker.getNaam());
            nummerDisplay.setText(String.valueOf(medewerker.getNummer()));
            adminDisplay.setText(String.valueOf(medewerker.isAdmin()));
        }
    }

    public void toegangBeheer() throws IOException {
        if(Account.ingelogdeUser().isKeuzeAdmin()){
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/BeheerVenster.fxml"));
            rootPane.getChildren().setAll(pane);
        }
        else{
            System.out.println("U mag geen gebruik maken van het Beheerscherm omdat u geen admin bent.");
        }
    }

    public void displayAdmin(){
        if(Medewerker.ingelogdeUser().isKeuzeAdmin()){
            welAdmin.setVisible(true);
        }
    }
}