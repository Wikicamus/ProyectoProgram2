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
public class CatalogoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Produc1(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Producto1.fxml"));
            Parent root = loader.load();

            Stage vtnPr1 = new Stage();
            vtnPr1.setTitle("Producto1");
            vtnPr1.setScene(new Scene(root));

            // Obtén el controlador de la segunda ventana si es necesario
            Producto1Controller controlPr1 = loader.getController();

            //mostrarAlerta("INFO LOGIN", "HA INICIADO SESION");
            vtnPr1.show();
        } catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void Produc2(MouseEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Producto2.fxml"));
            Parent root = loader.load();

            Stage vtnPr2 = new Stage();
            vtnPr2.setTitle("Producto2");
            vtnPr2.setScene(new Scene(root));

            // Obtén el controlador de la segunda ventana si es necesario
            Producto2Controller controlPr2 = loader.getController();

            //mostrarAlerta("INFO LOGIN", "HA INICIADO SESION");
            vtnPr2.show();
        } catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void Produc3(MouseEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Producto3.fxml"));
            Parent root = loader.load();

            Stage vtnPr3 = new Stage();
            vtnPr3.setTitle("Producto3");
           vtnPr3.setScene(new Scene(root));

            // Obtén el controlador de la segunda ventana si es necesario
            Producto3Controller controlPr3 = loader.getController();

            //mostrarAlerta("INFO LOGIN", "HA INICIADO SESION");
            vtnPr3.show();
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

            // Obtén el controlador de la segunda ventana si es necesario
            CarritoController controlcarrito = loader.getController();

            //mostrarAlerta("INFO LOGIN", "HA INICIADO SESION");
            vtnCarrito.show();
        } catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void irLista(ActionEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ListDeseos.fxml"));
            Parent root = loader.load();

            Stage vtnLista = new Stage();
            vtnLista.setTitle("Lista de Deseos");
            vtnLista.setScene(new Scene(root));

            // Obtén el controlador de la segunda ventana si es necesario
            ListDeseosController controlLista = loader.getController();

            //mostrarAlerta("INFO LOGIN", "HA INICIADO SESION");
            vtnLista.show();
        } catch (IOException e) {
            e.printStackTrace();
    }
    }
    
}
