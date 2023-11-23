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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.ListaUsuario;

/**
 * FXML Controller class
 *
 * @author wikic
 */
public class LoginController implements Initializable {

    ListaUsuario LisUsu = new ListaUsuario();
    @FXML
    private TextField usuario;
    @FXML
    private TextField contra;
    @FXML
    private Button IngresCata;

    public LoginController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void AbrirRegistro(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Registro.fxml"));
            Parent root = loader.load();

            Stage vtnregis = new Stage();
            vtnregis.setTitle("Registrar");
            vtnregis.setScene(new Scene(root));
            RegistraController controlregis = loader.getController();
            controlregis.setLisUsu(LisUsu);

            vtnregis.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void IngresCata(ActionEvent event) {
        if (LisUsu.buscarUsuario(usuario.getText()) != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Catalogo.fxml"));
                Parent root = loader.load();

                Stage vtnCatalogo = new Stage();
                vtnCatalogo.setTitle("Catalogo");
                vtnCatalogo.setScene(new Scene(root));
                CatalogoController controlCatalog = loader.getController();
                mostrarAlertaB("Ingreso", "Inicio sesion correctamente");
                vtnCatalogo.show();
                Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stageActual.close();
            } catch (IOException e) {
                e.printStackTrace();

            }

        } else {
            mostrarAlerta("Error", "El usuario no existe!!");
        }
    }

    private void mostrarAlerta(String info, String msj) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(info);
        alert.setContentText(msj);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: linear-gradient(to bottom, #A418E5, #18E18D);");
        alert.showAndWait();
    }
      private void mostrarAlertaB(String info, String msj) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(info);        
        alert.setContentText(msj);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: linear-gradient(to bottom, #A418E5, #18E18D);");
        alert.showAndWait();
    }

    @FXML
    private void ing(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            // Código que deseas ejecutar cuando se presiona Enter
            IngresCata.fire();
        }
    }

    @FXML
    private void ie(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            contra.requestFocus();
        }
    }

    @FXML
    private void ic(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            // Código que deseas ejecutar cuando se presiona Enter
            IngresCata.fire();
        }
    }

}
