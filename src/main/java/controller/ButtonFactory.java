package controller;

import javafx.scene.control.Button;

import java.security.PublicKey;

public interface ButtonFactory {
    OButton createOButton();
    BButton createBButton();
}
