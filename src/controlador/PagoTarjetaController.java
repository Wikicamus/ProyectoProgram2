/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javafx.scene.control.DialogPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wikic
 */
public class PagoTarjetaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

   @FXML
private void IrTar(ActionEvent event) {
    try {
        // Obtén el Stage de la escena actual
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Carga la nueva vista
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Catalogo.fxml"));
        Parent root = loader.load();

        // Configura la nueva escena
        Scene nuevaEscena = new Scene(root);

        // Muestra la nueva escena en un nuevo Stage
        Stage nuevoStage = new Stage();
        nuevoStage.setTitle("Catálogo");
        nuevoStage.setScene(nuevaEscena);
        CatalogoController controlCatalogo = loader.getController();

        // Mostrar la alerta antes de cerrar la ventana actual
        mostrarAlerta("Pagado con éxito!!", "Al pagar en 24 llegará un correo de confirmación y su pedido\n"
                + "llegará en un máximo de 15 días,\n"
                + " muchas gracias por comprar con nosotros");

        // Cierra la ventana actual
        stageActual.close();
    } catch (IOException e) {
        e.printStackTrace();
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
