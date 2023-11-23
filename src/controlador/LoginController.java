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

    public LoginController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AbrirRegistro(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Registro.fxml"));
            Parent root = loader.load();

            Stage vtnregis = new Stage();
            vtnregis.setTitle("Registrar");
            vtnregis.setScene(new Scene(root));
            // Obtén el controlador de la segunda ventana si es necesario
            RegistraController controlregis = loader.getController();
            controlregis.setLisUsu(LisUsu);

            vtnregis.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void IngresCata(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Catalogo.fxml"));
            Parent root = loader.load();

            Stage vtnCatalogo = new Stage();
            vtnCatalogo.setTitle("Catalogo");
            vtnCatalogo.setScene(new Scene(root));
            CatalogoController controlCatalog = loader.getController();

            //mostrarAlerta("INFO LOGIN", "HA INICIADO SESION");
            vtnCatalogo.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
