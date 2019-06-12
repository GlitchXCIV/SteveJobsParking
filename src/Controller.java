import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
public class Controller {
    @FXML
    private Button entrata_button;
    @FXML
    private Button uscita_button;
    @FXML
    private Button conferma_button;
    @FXML
    private Button invio_button;
    @FXML
    private Pane boxIn;
    @FXML
    private Pane boxOut;
    @FXML
    private Pane bloccoPaga;
    @FXML
    private Pane boxmenu;
    @FXML
    private TextField targaIn_label;
    @FXML
    private TextField targaOut_label;
    @FXML
    private Label timeOut_label;
    @FXML
    private TextField kindLabel;
    @FXML
    private TextField importo_label;
    @FXML
    private RadioButton scooter_radio;
    @FXML
    private RadioButton auto_radio;
    @FXML
    private RadioButton tir_radio;
    @FXML
    private Label timeIn;
    @FXML
    private Button menu;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy \n HH:mm:ss");
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    ParkingLot talete= new ParkingLot("Talete",500);

    //private Button entrata_button;
    public void enter(javafx.event.ActionEvent actionEvent) {
        this.boxIn.visibleProperty().setValue(true);
        this.boxmenu.visibleProperty().setValue(false);
        this.timeIn.setText(sdf.format(timestamp));
    }
    //private Button uscita_button;
    public void exit (javafx.event.ActionEvent actionEvent) {
        this.boxOut.visibleProperty().setValue(true);
        this.boxmenu.visibleProperty().setValue(false);
        this.timeOut_label.setText(sdf.format(timestamp));
    }

    public void confirmEnter (javafx.event.ActionEvent actionEvent) {
        Vehicle vehicle = new Vehicle(this.targaIn_label.getText(), Vehicle.Kind.valueOf(this.kindLabel.getText()));
        Parking parking = new Parking(vehicle);
        talete.addVehicle(vehicle);
        this.boxIn.visibleProperty().setValue(false);
        this.boxmenu.visibleProperty().setValue(true);

    }
    public void confirmExit (javafx.event.ActionEvent actionEvent) {
        this.boxOut.visibleProperty().setValue(false);
        this.bloccoPaga.visibleProperty().setValue(true);
        talete.exitVehicle(this.targaOut_label.getText());
        this.importo_label.setText(talete.getCash()+"");
    }
    public void restartMenu (javafx.event.ActionEvent actionEvent) {
    this.bloccoPaga.visibleProperty().setValue(false);
    this.boxmenu.visibleProperty().setValue(true);
}
}

