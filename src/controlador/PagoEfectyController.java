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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wikic
 */
public class PagoEfectyController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void IrCata(ActionEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Catalogo.fxml"));
            Parent root = loader.load();

            Stage vtnCata = new Stage();
            vtnCata.setTitle("Catalogo");
            vtnCata.setScene(new Scene(root));
            CatalogoController controlCArrito = loader.getController();
            vtnCata.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Atras(MouseEvent event) {
                        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/OpcionesPago.fxml"));
            Parent root = loader.load();
            Stage vtnPago = new Stage();
            vtnPago.setTitle("Opciones de Pago");
            vtnPago.setScene(new Scene(root));
            OpcionesPagoController controlOpPago = loader.getController();
            vtnPago.show();
        } catch (IOException e) {
            e.printStackTrace();
    }
    }
    
}
