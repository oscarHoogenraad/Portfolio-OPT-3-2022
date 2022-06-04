package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import controller.Account;
import java.io.IOException;

public class NavigationController {

    Account use;

    @FXML
    private AnchorPane rootPane;

    public void toLogin() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/LoginVenster.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void toMenu() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/MenuVenster.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void toBeheer() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/BeheerVenster.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void logout() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/LoginVenster.fxml"));
        rootPane.getChildren().setAll(pane);
        Account.ingelogdeUser().uitgelogdeUser();
    }

    public void toOverzicht() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/OverzichtsVenster.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void toToevoeg() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ToevoegVenster.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
