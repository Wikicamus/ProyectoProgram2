package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.ListaUsuario;

/**
 * FXML Controller class
 *
 * @author wikic
 */
public class RegistraController implements Initializable {

    ListaUsuario lisUsu;
    @FXML
    private TextField ingreseUsu;
    @FXML
    private TextField ingreseCon;
    @FXML
    private TextField reinContra;
    @FXML
    private TextField ingreseDIr;
    @FXML
    private Button btnReg;

    public RegistraController() {
    }

    public RegistraController(ListaUsuario lisUsu) {
        this.lisUsu = lisUsu;
    }

    public ListaUsuario getLisUsu() {
        return lisUsu;
    }

    public void setLisUsu(ListaUsuario lisUsu) {
        this.lisUsu = lisUsu;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Resgistrar(ActionEvent event) {
        if (ingreseCon.getText().equals(reinContra.getText())) {
            lisUsu.addUser(ingreseUsu, ingreseCon, ingreseDIr);
            lisUsu.guardarInfoUser();
            Stage stage = (Stage) btnReg.getScene().getWindow();
            stage.close();
        } else {
            mostrarAlerta("INFO REGISTER", "La contraseña no coincide");
            ingreseCon.setText("");
            reinContra.setText("");
            ingreseCon.requestFocus();
        }
    }

    @FXML
    private void Atras(MouseEvent event) {
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageActual.close();

    }

    private void mostrarAlerta(String info, String msj) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(info);
        alert.setContentText(msj);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: linear-gradient(to bottom, #A418E5, #18E18D);");
        alert.showAndWait();
    }
}
