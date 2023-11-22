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
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AbrirRegistro(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Registro.fxml"));
            Parent root = loader.load();

            Stage vtnRegistro = new Stage();
            vtnRegistro.setTitle("CATALOGO");
           vtnRegistro.setScene(new Scene(root));

            // Obtén el controlador de la segunda ventana si es necesario
            RegistraController controlregis = loader.getController();

           // mostrarAlerta("INFO LOGIN", "HA INICIADO SESION");
            vtnRegistro.show();
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
            vtnCatalogo.setTitle("CATALOGO");
            vtnCatalogo.setScene(new Scene(root));
            CatalogoController controlCatalog = loader.getController();

            //mostrarAlerta("INFO LOGIN", "HA INICIADO SESION");
            vtnCatalogo.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
