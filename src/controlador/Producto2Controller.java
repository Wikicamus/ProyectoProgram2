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
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wikic
 */
public class Producto2Controller implements Initializable {

    @FXML
    private AnchorPane contTblFav;
    @FXML
    private VBox tblFav;
    @FXML
    private Label nombreProd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void IrPago(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/OpcionesPago.fxml"));
            Parent root = loader.load();

            Stage vtnPago = new Stage();
            vtnPago.setTitle("Opciones de Pago");
            vtnPago.setScene(new Scene(root));

            // Obtén el controlador de la segunda ventana si es necesario
            OpcionesPagoController controlOpPago = loader.getController();

            vtnPago.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Atras(MouseEvent event) {
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageActual.close();
    }

    private void ALis(MouseEvent event) {
        mostrarAlerta("Añadir", "Añadido correctamente a la lista de deseos");

    }

    @FXML
    private void Acarrito(MouseEvent event) {
        mostrarAlerta("Añadir", "Añadido correctamente al carrito");
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

    @FXML
    private void volverCatalogoBtn(ActionEvent event) {
        contTblFav.setVisible(false);
    }

    @FXML
    private void VolverCat(MouseEvent event) {
        contTblFav.setVisible(false);
    }

    @FXML
    private void verCarrito(ActionEvent event) {
    }

    @FXML
    private void verFav(ActionEvent event) {
    }

    @FXML
    private void aggFavorito(MouseEvent event) {
        Label lblNombre = new Label();
        Button btnDel = new Button("ELIMINAR ELEMENTO");

        GridPane contLibSelected = new GridPane();
        ColumnConstraints column = new ColumnConstraints();

        column.setPrefWidth(tblFav.getWidth() / 2);

        contLibSelected.getColumnConstraints().addAll(column);
        contLibSelected.prefWidth(tblFav.getMaxWidth());
        contLibSelected.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

        lblNombre.setText(nombreProd.getText());

        contLibSelected.add(lblNombre, 0, 0);
        contLibSelected.add(btnDel, 0, 1);

        tblFav.getChildren().add(contLibSelected);
    }

}
