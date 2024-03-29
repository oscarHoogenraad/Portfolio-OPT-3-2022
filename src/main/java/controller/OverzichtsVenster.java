package controller;
import controller.models.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OverzichtsVenster extends NavigationController implements Initializable {

    LoginVenster ReliesOn;

    boolean voorraad;

    @FXML
    public AnchorPane rootPane;

    @FXML
    private Label displayIngelogd;

    @FXML
    private Label aanDisplay, doorDisplay, aanLabel, doorLabel, typeDisplay, laadvermogenDisplay, soortDisplay, gewichtDisplay, merkDisplay,
            hpDisplay, voorraadDisplay, typelabel, laadvermogenLabel, soortLabel,  gewichtLabel, merkLabel, hpLabel, voorraadLabel, naamLabel;

    @FXML
    private CheckBox retourAutoButton, retourVrachtButton, retourBoormachineButton, verzekerAutoButton, verzekerVrachtButton, verzekerBoorButton;

    @FXML
    private Button verhuurAutoButton, verhuurVrachtButton, verhuurBoorButton;

    @FXML
    private TextField klantNaamField;

    @FXML
    private TableView<Personenautos> personenautosTable;

    @FXML
    private TableView<Vrachtautos> vrachtautosTable;

    @FXML
    private TableView<Boormachines> boormachinesTable;

    @FXML
    private TableColumn<Personenautos, String> SoortP;

    @FXML
    private TableColumn<Personenautos, Boolean> OpVoorraadP;

    @FXML
    private TableColumn<Vrachtautos, String> SoortV;

    @FXML
    private TableColumn<Vrachtautos, Boolean> OpVoorraadV;

    @FXML
    private TableColumn<Boormachines, String> SoortB;

    @FXML
    private TableColumn<Boormachines, Boolean> OpVoorraadB;

    public static ArrayList<Personenautos> personenautosArrayList = new ArrayList<>();
    public static ArrayList<Product> emptylist = new ArrayList<>();
    public static ArrayList<Vrachtautos> vrachtautosArrayList = new ArrayList<>();
    public static ArrayList<Boormachines> boormachinesArrayList = new ArrayList<>();

    public static ArrayList<Personenautos> getPersonenautosArrayList() {
        return personenautosArrayList;
    }

    public static ArrayList<Vrachtautos> getVrachtautosArrayList() {
        return vrachtautosArrayList;
    }

    public static ArrayList<Boormachines> getBoormachinesArrayList() {
        return boormachinesArrayList;
    }



    private static ArrayList<OverzichtObserver> luisteraars = new ArrayList<>();

    public void setLuisteraars(){
        if(luisteraars.equals(emptylist)){
            luisteraars.add(new LabelDisplay(personenautosTable.getSelectionModel().getSelectedItem().isOpVoorraad()));
            luisteraars.add(new TableColumnDisplay(personenautosTable.getSelectionModel().getSelectedItem().isOpVoorraad()));
        }
    }

    public void notifyObservers(){
        for(OverzichtObserver i: luisteraars){
            i.update(personenautosTable.getSelectionModel().getSelectedItem().isOpVoorraad());
        }
    }

    public void setvoorraad(boolean voorraad){
        this.voorraad=voorraad;
        notifyObservers();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(Account.ingelogdeUser().isIngelogd()){
            displayIngelogd.setText(Account.ingelogdeUser().getUsername());
        }
        addToList();
        addToTable();
        onClick();
    }

    public void onClick(){
        personenautosTable.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            detailPersonenauto();
        });
        vrachtautosTable.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            detailVrachtauto();
        });
        boormachinesTable.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            detailBoormachine();
        });
    }

    public void changeAutoProduct(){
        personenautosTable.getSelectionModel().getSelectedItem().setOpVoorraad(false);
        personenautosTable.getSelectionModel().getSelectedItem().setAanverhuurd(klantNaamField.getText());
        personenautosTable.getSelectionModel().getSelectedItem().setDoorVerhuurd(Account.ingelogdeUser().getUsername());
        personenautosTable.refresh();
    }

    public void changeVrachtProduct(){
        vrachtautosTable.getSelectionModel().getSelectedItem().setOpVoorraad(false);
        vrachtautosTable.getSelectionModel().getSelectedItem().setAanverhuurd(klantNaamField.getText());
        vrachtautosTable.getSelectionModel().getSelectedItem().setDoorVerhuurd(Account.ingelogdeUser().getUsername());
        vrachtautosTable.refresh();
    }

    public void changeBoorProduct(){
        boormachinesTable.getSelectionModel().getSelectedItem().setOpVoorraad(false);
        boormachinesTable.getSelectionModel().getSelectedItem().setAanverhuurd(klantNaamField.getText());
        boormachinesTable.getSelectionModel().getSelectedItem().setDoorVerhuurd(Account.ingelogdeUser().getUsername());
        boormachinesTable.refresh();
    }

    public static void addToList(){
        if(personenautosArrayList.equals(emptylist)){
            personenautosArrayList.add(new Personenautos(false, 40, "Sedan", 1400, 0.01, "Personenauto", "jan123", "Anne van der Molen"));
            personenautosArrayList.add(new Personenautos(true, 40, "SUV", 1250, 0.01, "Personenauto", "", ""));
            personenautosArrayList.add(new Personenautos(true, 40, "Cabriolet", 1300, 0.01, "Personenauto", "", ""));
            vrachtautosArrayList.add(new Vrachtautos(false, 0.1, 0.01, 2000, 10000, "Vrachtauto", "klaas66", "Joop Bessendracht"));
            vrachtautosArrayList.add(new Vrachtautos(false, 0.1, 0.01, 1500, 9000, "Vrachtauto", "admin1", "Hicham el Khlifi"));
            vrachtautosArrayList.add(new Vrachtautos(true, 0.1, 0.01, 3000, 9500, "Vrachtauto", "", ""));
            boormachinesArrayList.add(new Boormachines(true, 5, "DeWalt", "Schroefboormachine", 1, "Boormachine", "", ""));
            boormachinesArrayList.add(new Boormachines(true, 5, "Bosch", "Accuboormachine", 1, "Boormachine", "", ""));
            boormachinesArrayList.add(new Boormachines(false, 5, "Makita", "Accuboormachine", 1, "Boormachine", "piet22", "Jan Boskamp"));
        }
    }

    public void addToTable(){
        SoortP.setCellValueFactory(new PropertyValueFactory<>("soort"));
        OpVoorraadP.setCellValueFactory(new PropertyValueFactory<>("OpVoorraad"));
        SoortV.setCellValueFactory(new PropertyValueFactory<>("soort"));
        OpVoorraadV.setCellValueFactory(new PropertyValueFactory<>("OpVoorraad"));
        SoortB.setCellValueFactory(new PropertyValueFactory<>("soort"));
        OpVoorraadB.setCellValueFactory(new PropertyValueFactory<>("OpVoorraad"));
        personenautosTable.setItems(FXCollections.observableArrayList(personenautosArrayList));
        vrachtautosTable.setItems(FXCollections.observableArrayList(vrachtautosArrayList));
        boormachinesTable.setItems(FXCollections.observableArrayList(boormachinesArrayList));
    }

    public void setInvisible(){
        voorraadLabel.setVisible(false); voorraadDisplay.setVisible(false); hpLabel.setVisible(false); hpDisplay.setVisible(false); merkLabel.setVisible(false);
        merkDisplay.setVisible(false); gewichtLabel.setVisible(false); gewichtDisplay.setVisible(false); soortLabel.setVisible(false); soortDisplay.setVisible(false);
        laadvermogenDisplay.setVisible(false); laadvermogenLabel.setVisible(false); typeDisplay.setVisible(false); typelabel.setVisible(false); doorDisplay.setVisible(false);
        doorLabel.setVisible(false); aanDisplay.setVisible(false); aanLabel.setVisible(false); retourAutoButton.setVisible(false); retourBoormachineButton.setVisible(false);
        retourVrachtButton.setVisible(false); verzekerAutoButton.setVisible(false); verzekerBoorButton.setVisible(false); verzekerVrachtButton.setVisible(false);
        verhuurAutoButton.setVisible(false); verhuurVrachtButton.setVisible(false); verhuurBoorButton.setVisible(false); naamLabel.setVisible(false); klantNaamField.setVisible(false);
    }

    public void changeVerzekerAuto(ActionEvent event){
        if(verzekerAutoButton.isSelected()){
            if((personenautosTable.getSelectionModel().getSelectedItem().getVerzekering()*personenautosTable.getSelectionModel().getSelectedItem().getGewicht()) + personenautosTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() <= (personenautosTable.getSelectionModel().getSelectedItem().getVerzekering()*personenautosTable.getSelectionModel().getSelectedItem().getGewicht()) + personenautosTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag()){
                hpDisplay.setText((personenautosTable.getSelectionModel().getSelectedItem().getVerzekering()*personenautosTable.getSelectionModel().getSelectedItem().getGewicht()) + personenautosTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() + "");
                personenautosTable.getSelectionModel().getSelectedItem().setHuurprijsPerDag((personenautosTable.getSelectionModel().getSelectedItem().getVerzekering()*personenautosTable.getSelectionModel().getSelectedItem().getGewicht()) + personenautosTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag());
            }
        }
        else{
            personenautosTable.getSelectionModel().getSelectedItem().setHuurprijsPerDag(personenautosTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() - (personenautosTable.getSelectionModel().getSelectedItem().getGewicht()/100));
            hpDisplay.setText(personenautosTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() + "");
        }
    }

    public void changeVerzekerVracht(ActionEvent event) {
        if (verzekerVrachtButton.isSelected()) {
            if (vrachtautosTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() * vrachtautosTable.getSelectionModel().getSelectedItem().getLaadvermogen() <= vrachtautosTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() * vrachtautosTable.getSelectionModel().getSelectedItem().getLaadvermogen() && vrachtautosTable.getSelectionModel().getSelectedItem().getVerzekering() * vrachtautosTable.getSelectionModel().getSelectedItem().getGewicht() <= vrachtautosTable.getSelectionModel().getSelectedItem().getVerzekering() * vrachtautosTable.getSelectionModel().getSelectedItem().getGewicht()) {
                hpDisplay.setText((vrachtautosTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() * vrachtautosTable.getSelectionModel().getSelectedItem().getLaadvermogen()) + (vrachtautosTable.getSelectionModel().getSelectedItem().getVerzekering() * vrachtautosTable.getSelectionModel().getSelectedItem().getGewicht()) + "");
                vrachtautosTable.getSelectionModel().getSelectedItem().setHuurprijsPerDag((vrachtautosTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() * vrachtautosTable.getSelectionModel().getSelectedItem().getLaadvermogen()) + (vrachtautosTable.getSelectionModel().getSelectedItem().getVerzekering() * vrachtautosTable.getSelectionModel().getSelectedItem().getGewicht()));
            }
        } else {
            double d = (vrachtautosTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() - vrachtautosTable.getSelectionModel().getSelectedItem().getVerzekering() * vrachtautosTable.getSelectionModel().getSelectedItem().getGewicht());
            double e = d * 10;
            vrachtautosTable.getSelectionModel().getSelectedItem().setHuurprijsPerDag(d / e);
            hpDisplay.setText(vrachtautosTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() * vrachtautosTable.getSelectionModel().getSelectedItem().getLaadvermogen() + "");
        }
    }

    public void changeVerzekerBoor(ActionEvent event){
            if(verzekerBoorButton.isSelected()){
                if(boormachinesTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() + boormachinesTable.getSelectionModel().getSelectedItem().getVerzekering() <= boormachinesTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() + boormachinesTable.getSelectionModel().getSelectedItem().getVerzekering()){
                    hpDisplay.setText(boormachinesTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() + boormachinesTable.getSelectionModel().getSelectedItem().getVerzekering() + "");
                    boormachinesTable.getSelectionModel().getSelectedItem().setHuurprijsPerDag(boormachinesTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() + boormachinesTable.getSelectionModel().getSelectedItem().getVerzekering());
                }
        }
        else{
                boormachinesTable.getSelectionModel().getSelectedItem().setHuurprijsPerDag(boormachinesTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() - 1);
            hpDisplay.setText(boormachinesTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() + "");
        }
    }

    public void changeVoorraadAuto(ActionEvent event){
        if(retourAutoButton.isSelected()){
            personenautosTable.getSelectionModel().getSelectedItem().setOpVoorraad(true);
            personenautosTable.getSelectionModel().getSelectedItem().setDoorVerhuurd("");
            personenautosTable.getSelectionModel().getSelectedItem().setAanverhuurd("");
            voorraadDisplay.setText(personenautosTable.getSelectionModel().getSelectedItem().isOpVoorraad() + "");
            doorDisplay.setVisible(false);
            doorLabel.setVisible(false);
            aanDisplay.setVisible(false);
            aanLabel.setVisible(false);
            personenautosTable.refresh();
            }
        }

    public void changeVoorraadVracht(ActionEvent event){
        if(retourVrachtButton.isSelected()){
            vrachtautosTable.getSelectionModel().getSelectedItem().setOpVoorraad(true);
            vrachtautosTable.getSelectionModel().getSelectedItem().setDoorVerhuurd("");
            vrachtautosTable.getSelectionModel().getSelectedItem().setAanverhuurd("");
            voorraadDisplay.setText(vrachtautosTable.getSelectionModel().getSelectedItem().isOpVoorraad() + "");
            doorDisplay.setVisible(false);
            doorLabel.setVisible(false);
            aanDisplay.setVisible(false);
            aanLabel.setVisible(false);
            vrachtautosTable.refresh();
        }
    }

    public void changeVoorraadBoor(ActionEvent event){
        if(retourBoormachineButton.isSelected()){
            boormachinesTable.getSelectionModel().getSelectedItem().setOpVoorraad(true);
            boormachinesTable.getSelectionModel().getSelectedItem().setAanverhuurd("");
            boormachinesTable.getSelectionModel().getSelectedItem().setDoorVerhuurd("");
            voorraadDisplay.setText(boormachinesTable.getSelectionModel().getSelectedItem().isOpVoorraad() + "");
            doorDisplay.setVisible(false);
            doorLabel.setVisible(false);
            aanDisplay.setVisible(false);
            aanLabel.setVisible(false);
            boormachinesTable.refresh();
        }
    }

    public void setVisibleP(){
        voorraadLabel.setVisible(true);
        voorraadDisplay.setVisible(true);
        merkLabel.setVisible(true);
        merkDisplay.setVisible(true);
        gewichtLabel.setVisible(true);
        gewichtDisplay.setVisible(true);
        soortLabel.setVisible(true);
        soortDisplay.setVisible(true);
    }

    public void setVisibleB(){
        voorraadLabel.setVisible(true);
        voorraadDisplay.setVisible(true);
        merkLabel.setVisible(true);
        merkDisplay.setVisible(true);
        typelabel.setVisible(true);
        typeDisplay.setVisible(true);
        soortLabel.setVisible(true);
        soortDisplay.setVisible(true);
    }

    public void setVisibleV(){
        voorraadLabel.setVisible(true);
        voorraadDisplay.setVisible(true);
        laadvermogenDisplay.setVisible(true);
        laadvermogenLabel.setVisible(true);
        gewichtLabel.setVisible(true);
        gewichtDisplay.setVisible(true);
        soortLabel.setVisible(true);
        soortDisplay.setVisible(true);
    }

    public void setVisiblePInvul(){
        klantNaamField.setVisible(true);
        verhuurAutoButton.setVisible(true);
        naamLabel.setVisible(true);
        hpLabel.setVisible(true);
        hpDisplay.setVisible(true);
        verzekerAutoButton.setVisible(true);
    }

    public void setVisiblePDisplay(){
        doorDisplay.setVisible(true);
        doorLabel.setVisible(true);
        aanDisplay.setVisible(true);
        aanLabel.setVisible(true);
        retourAutoButton.setVisible(true);
    }

    public void setVisibleVInvul(){
        klantNaamField.setVisible(true);
        hpLabel.setVisible(true);
        verhuurVrachtButton.setVisible(true);
        hpDisplay.setVisible(true);
        verzekerVrachtButton.setVisible(true);
    }

    public void setVisibleVDisplay(){
        retourVrachtButton.setVisible(true);
        doorDisplay.setVisible(true);
        doorLabel.setVisible(true);
        aanDisplay.setVisible(true);
        aanLabel.setVisible(true);
    }

    public void setVisibleBInvul(){
        klantNaamField.setVisible(true);
        verhuurBoorButton.setVisible(true);
        hpLabel.setVisible(true);
        hpDisplay.setVisible(true);
        verzekerBoorButton.setVisible(true);
    }

    public void setVisibleBDisplay(){
        retourBoormachineButton.setVisible(true);
        doorDisplay.setVisible(true);
        doorLabel.setVisible(true);
        aanDisplay.setVisible(true);
        aanLabel.setVisible(true);
    }

    public void setTextP(){
        voorraadDisplay.setText(personenautosTable.getSelectionModel().getSelectedItem().isOpVoorraad() + "");
        hpDisplay.setText(personenautosTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() + "");
        merkDisplay.setText(personenautosTable.getSelectionModel().getSelectedItem().getMerk());
        gewichtDisplay.setText(personenautosTable.getSelectionModel().getSelectedItem().getGewicht() + "");
        soortDisplay.setText(personenautosTable.getSelectionModel().getSelectedItem().getSoort());
    }

    public void setTextV(){
        voorraadDisplay.setText(vrachtautosTable.getSelectionModel().getSelectedItem().isOpVoorraad() + "");
        hpDisplay.setText((vrachtautosTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() * vrachtautosTable.getSelectionModel().getSelectedItem().getLaadvermogen()) + "");
        soortDisplay.setText(vrachtautosTable.getSelectionModel().getSelectedItem().getSoort());
        laadvermogenDisplay.setText(vrachtautosTable.getSelectionModel().getSelectedItem().getLaadvermogen() + "");
        gewichtDisplay.setText(vrachtautosTable.getSelectionModel().getSelectedItem().getGewicht() + "");
    }

    public void setTextB(){
        voorraadDisplay.setText(boormachinesTable.getSelectionModel().getSelectedItem().isOpVoorraad() + "");
        hpDisplay.setText(boormachinesTable.getSelectionModel().getSelectedItem().getHuurprijsPerDag() + "");
        merkDisplay.setText(boormachinesTable.getSelectionModel().getSelectedItem().getMerk());
        soortDisplay.setText(boormachinesTable.getSelectionModel().getSelectedItem().getSoort());
        typeDisplay.setText(boormachinesTable.getSelectionModel().getSelectedItem().getType());
    }

    public void detailPersonenauto() {
        setInvisible();
        setTextP();
        setVisibleP();
        setLuisteraars();
        setvoorraad(personenautosTable.getSelectionModel().getSelectedItem().isOpVoorraad());

        if(personenautosTable.getSelectionModel().getSelectedItem().isOpVoorraad()){
            setVisiblePInvul();
        }

        if(!personenautosTable.getSelectionModel().getSelectedItem().isOpVoorraad()){
            setVisiblePDisplay();
            doorDisplay.setText(personenautosTable.getSelectionModel().getSelectedItem().getDoorVerhuurd());
            aanDisplay.setText(personenautosTable.getSelectionModel().getSelectedItem().getAanverhuurd());
        }
    }

    public void detailVrachtauto(){
        setInvisible();
        setTextV();
        setVisibleV();
        if(vrachtautosTable.getSelectionModel().getSelectedItem().isOpVoorraad()){
            setVisibleVInvul();
        }
        if(!vrachtautosTable.getSelectionModel().getSelectedItem().isOpVoorraad()){
            setVisibleVDisplay();
            doorDisplay.setText(vrachtautosTable.getSelectionModel().getSelectedItem().getDoorVerhuurd());
            aanDisplay.setText(vrachtautosTable.getSelectionModel().getSelectedItem().getAanverhuurd());
        }
    }

    public void detailBoormachine(){
        setInvisible();
        setVisibleB();
        setTextB();

        if(boormachinesTable.getSelectionModel().getSelectedItem().isOpVoorraad()){
            setVisibleBInvul();
        }

        if(!boormachinesTable.getSelectionModel().getSelectedItem().isOpVoorraad()){
            setVisibleBDisplay();
            doorDisplay.setText(boormachinesTable.getSelectionModel().getSelectedItem().getDoorVerhuurd());
            aanDisplay.setText(boormachinesTable.getSelectionModel().getSelectedItem().getAanverhuurd());
        }
    }
}