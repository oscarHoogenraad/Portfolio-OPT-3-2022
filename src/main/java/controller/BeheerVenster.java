package controller;
import controller.models.Account;
import controller.models.Boormachines;
import controller.models.Personenautos;
import controller.models.Vrachtautos;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class BeheerVenster extends NavigationController implements Initializable {

    LoginVenster ReliesOn;
    OverzichtsVenster Updates;

    @FXML
    public AnchorPane rootPane;

    @FXML
    private Label displayingelogd, merkLabel, gewichtLabel, laadvermogenLabel, typeLabel;

    @FXML
    private Button toevoegPersonenautoButton, toevoegBoormachineButton, toevoegVrachtautoButton;

    @FXML
    private TextField gewichtField, merkField, typeField, laadVermogenField;

    @FXML
    private TableView<Personenautos> personenautosTable;

    @FXML
    private TableView<Vrachtautos> vrachtautosTable;

    @FXML
    private TableView<Boormachines> boormachinesTable;

    @FXML
    private TableColumn<Personenautos, String> Soort;

    @FXML
    private TableColumn<Vrachtautos, String> Soort2;

    @FXML
    private TableColumn<Boormachines, String> Soort3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(Account.ingelogdeUser().isIngelogd()){
            displayingelogd.setText(Account.ingelogdeUser().getUsername());
        }
        OverzichtsVenster.addToList();
        addToTableView();
        onClick();
    }

    public void onClick(){
        personenautosTable.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            toevoegPersonenauto();
        });
        vrachtautosTable.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            toevoegVrachtauto();
        });
        boormachinesTable.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            toevoegBoormachine();
        });
    }

    public void addToTableView(){
        Soort.setCellValueFactory(new PropertyValueFactory<>("soort"));
        Soort2.setCellValueFactory(new PropertyValueFactory<>("soort"));
        Soort3.setCellValueFactory(new PropertyValueFactory<>("soort"));
        personenautosTable.setItems(FXCollections.observableArrayList(OverzichtsVenster.personenautosArrayList.get(0)));
        vrachtautosTable.setItems(FXCollections.observableArrayList(OverzichtsVenster.vrachtautosArrayList.get(0)));
        boormachinesTable.setItems(FXCollections.observableArrayList(OverzichtsVenster.boormachinesArrayList.get(0)));
    }

    public void setInvisible(){
        merkField.setVisible(false);
        merkLabel.setVisible(false);
        gewichtField.setVisible(false);
        gewichtLabel.setVisible(false);
        laadvermogenLabel.setVisible(false);
        laadVermogenField.setVisible(false);
        typeField.setVisible(false);
        typeLabel.setVisible(false);
        toevoegBoormachineButton.setVisible(false);
        toevoegPersonenautoButton.setVisible(false);
        toevoegVrachtautoButton.setVisible(false);
    }

    public void toevoegPersonenauto(){
        setInvisible();
        merkField.setVisible(true);
        gewichtField.setVisible(true);
        gewichtLabel.setVisible(true);
        merkLabel.setVisible(true);
        toevoegPersonenautoButton.setVisible(true);
    }

    public void toevoegVrachtauto(){
        setInvisible();
        laadVermogenField.setVisible(true);
        gewichtLabel.setVisible(true);
        laadvermogenLabel.setVisible(true);
        gewichtField.setVisible(true);
        toevoegVrachtautoButton.setVisible(true);
    }

    public void toevoegBoormachine(){
        setInvisible();
        merkLabel.setVisible(true);
        merkField.setVisible(true);
        typeLabel.setVisible(true);
        typeField.setVisible(true);
        toevoegBoormachineButton.setVisible(true);
    }

    public void addToPersonenauto(){
        double a = Double.parseDouble(gewichtField.getText());
        OverzichtsVenster.getPersonenautosArrayList().add(new Personenautos(true, 40, merkField.getText(), a, 0.01, "Personenauto", "", ""));
    }

    public void addToBoormachine(){
        OverzichtsVenster.getBoormachinesArrayList().add(new Boormachines(true, 5, merkField.getText(), typeField.getText(), 1, "Boormachine", "", ""));
    }

    public void addToVrachtauto(){
        double b = Double.parseDouble(laadVermogenField.getText());
        double c = Double.parseDouble(gewichtField.getText());
        OverzichtsVenster.getVrachtautosArrayList().add(new Vrachtautos(true, 0.1, 0.01, b, c, "Vrachtauto", "", ""));
    }
}

