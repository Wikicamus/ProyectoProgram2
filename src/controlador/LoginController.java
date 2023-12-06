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
        LisUsu.cargarInfoUser();
    }

    @FXML
    private void AbrirRegistro(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Registro.fxml"));
            Parent root = loader.load();

            Stage vtnRegister = new Stage();
            vtnRegister.setTitle("REGISTRO");
            vtnRegister.setScene(new Scene(root));

            // Obtén el controlador de la segunda ventana si es necesario
            RegistraController controlRegister = loader.getController();
            controlRegister.setLisUsu(LisUsu);

            vtnRegister.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void IngresCata(ActionEvent event) {
        if (LisUsu.getUser(usuario.getText())) {
            if (LisUsu.verificarContraseña(contra.getText())) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Catalogo.fxml"));
                    Parent root = loader.load();

                    Stage vtnCatalogo = new Stage();
                    vtnCatalogo.setTitle("CATALOGO");
                    vtnCatalogo.setScene(new Scene(root));

                    // Obtén el controlador de la segunda ventana si es necesario
                    CatalogoController controlCatalog = loader.getController();

                    mostrarAlerta("INFO LOGIN", "HA INICIADO SESION");
                    vtnCatalogo.showAndWait();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            } else {
                mostrarAlerta("INFO LOGIN", "Contraseña incorrecta");
            }
        } else {
            mostrarAlerta("INFO LOGIN", "El usuario no existe por favor registrese");
        }
    }

    private void mostrarAlerta(String info, String msj) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(info);
        alert.setContentText(msj);

        DialogPane dialogPane = alert.getDialogPane();

        alert.showAndWait();

    }

    @FXML
    private void ing(KeyEvent event) {

    }

    @FXML
    private void ie(KeyEvent event) {

    }

    @FXML
    private void ic(KeyEvent event) {

    }

}
