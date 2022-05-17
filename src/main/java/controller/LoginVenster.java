package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class LoginVenster {
    Account use;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField passWord;

    @FXML
    private Label failedLogin;

    public void loginCheck(MouseEvent mouseEvent) throws IOException {
        for(Account i: Account.getAccountList()){
            if(userName.getText().equals(i.getUsername())&& passWord.getText().equals(i.getPassword())){
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/MenuVenster.fxml"));
                rootPane.getChildren().setAll(pane);
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
