package controller;

public class OButtonFactory implements ButtonFactory{

    @Override
    public OButton createOButton() {
        return new OButton();
    }

    @Override
    public BButton createBButton() {
        return null;
    }
}
