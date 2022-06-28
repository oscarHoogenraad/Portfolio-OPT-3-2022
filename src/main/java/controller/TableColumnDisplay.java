package controller;

public class TableColumnDisplay implements OverzichtObserver{

    private boolean opvoorraad;

    public TableColumnDisplay(boolean opvoorraad){
        this.opvoorraad=opvoorraad;
    }

    @Override
    public void update(boolean voorraad) {
        this.opvoorraad=voorraad;
        System.out.println("Personenauto op voorraad (TableColumn): " + opvoorraad);
    }
}
