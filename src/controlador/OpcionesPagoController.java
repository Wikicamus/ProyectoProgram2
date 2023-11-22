/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class OpcionesPagoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void IrEfecty(MouseEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PagoEfecty.fxml"));
            Parent root = loader.load();

            Stage vtnEfe = new Stage();
            vtnEfe.setTitle("Pago por Efecty");
            vtnEfe.setScene(new Scene(root));
            PagoEfectyController controlCArrito = loader.getController();
            vtnEfe.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void IrTarjeta(MouseEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PagoTarjeta.fxml"));
            Parent root = loader.load();

            Stage vtnTar = new Stage();
            vtnTar.setTitle("Pago por Tarjeta");
            vtnTar.setScene(new Scene(root));
            PagoTarjetaController controlCArrito = loader.getController();
            vtnTar.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Atras(MouseEvent event) {
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
    
}
