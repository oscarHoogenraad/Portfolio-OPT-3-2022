package controller;

import javafx.scene.control.Button;

public class OButton implements IButton{

    @Override
    public Button createButton() {

        return new Button();
    }
}
