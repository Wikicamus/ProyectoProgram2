package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
        lisUsu.agregar(ingreseUsu, ingreseCon, ingreseDIr);
        lisUsu.guardarEnArchivo();
    }

    @FXML
    private void Atras(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Login.fxml"));
            Parent root = loader.load();

            Stage vtnLog = new Stage();
            vtnLog.setTitle("Catalogo");
            vtnLog.setScene(new Scene(root));
            LoginController controlCarrito = loader.getController();
            vtnLog.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
