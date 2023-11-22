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
public class RegistraController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Resgistrar(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Login.fxml"));
            Parent root = loader.load();

            Stage vtnLog = new Stage();
            vtnLog.setTitle("Catalogo");
            vtnLog.setScene(new Scene(root));
            LoginController controlCArrito = loader.getController();
            mostrarAlerta("Registro", "Usuario registrado exitosamente");
            vtnLog.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Atras(MouseEvent event) {
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Login.fxml"));
            Parent root = loader.load();

            Stage vtnLog = new Stage();
            vtnLog.setTitle("Catalogo");
            vtnLog.setScene(new Scene(root));
            LoginController controlCArrito = loader.getController();
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
