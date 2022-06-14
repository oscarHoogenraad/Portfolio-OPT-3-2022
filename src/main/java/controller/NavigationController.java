package controller;
import controller.models.Account;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class NavigationController {

    Account use;

    @FXML
    private AnchorPane rootPane;

    public void toMenu() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/MenuVenster.fxml"));
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
}
