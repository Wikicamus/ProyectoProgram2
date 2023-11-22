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
public class Producto1Controller implements Initializable {

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
    private void irCarrito(ActionEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Carrito.fxml"));
            Parent root = loader.load();

            Stage vtnCarrito = new Stage();
            vtnCarrito.setTitle("Carrito");
            vtnCarrito.setScene(new Scene(root));
            CarritoController controlCArrito = loader.getController();
            vtnCarrito.show();
        } catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void IrLis(ActionEvent event) {
                        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ListDeseos.fxml"));
            Parent root = loader.load();

            Stage vtnLis = new Stage();
            vtnLis.setTitle("Lista de Deseos");
            vtnLis.setScene(new Scene(root));
            ListDeseosController controlCarrito = loader.getController();
            vtnLis.show();
        } catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void Atras(MouseEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Catalogo.fxml"));
            Parent root = loader.load();

            Stage vtnCatalogo = new Stage();
            vtnCatalogo.setTitle("Producto1");
            vtnCatalogo.setScene(new Scene(root));
           CatalogoController controlcat = loader.getController();
            vtnCatalogo.show();
        } catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
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
    
}
