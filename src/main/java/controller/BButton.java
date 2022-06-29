package controller;

import javafx.scene.control.Button;

public class BButton implements IButton{
    @Override
    public Button createButton() {

        return new Button();
    }
}
