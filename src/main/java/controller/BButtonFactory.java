package controller;

public class BButtonFactory implements ButtonFactory{

    @Override
    public OButton createOButton() {
        return null;
    }

    @Override
    public BButton createBButton() {
        return new BButton();
    }
}
