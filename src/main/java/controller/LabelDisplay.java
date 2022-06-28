package controller;

public class LabelDisplay implements OverzichtObserver{

    private boolean opvoorraad;

    public LabelDisplay(boolean opvoorraad){
        this.opvoorraad=opvoorraad;
    }

    @Override
    public void update(boolean voorraad) {
        this.opvoorraad=voorraad;
        System.out.println("Personenauto op voorraad (Label): " + opvoorraad);
    }
}
