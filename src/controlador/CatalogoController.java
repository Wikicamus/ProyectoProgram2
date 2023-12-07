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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
public class CatalogoController implements Initializable {

    @FXML
    private AnchorPane contProd1;
    @FXML
    private AnchorPane contTblFav;
    @FXML
    private VBox tblFav;
    @FXML
    private AnchorPane contProd2;
    @FXML
    private Label nombreProd1;
    @FXML
    private AnchorPane contProd3;
    @FXML
    private Label nombreProd2;
    @FXML
    private ImageView btnProd1;
    @FXML
    private ImageView btnProd2;
    @FXML
    private ImageView btnProd3;
    @FXML
    private Label nombreProd3;
    @FXML
    private ImageView btnAggFav1;
    @FXML
    private ImageView btnAggFav2;
    @FXML
    private ImageView btnAggFav3;
    @FXML
    private ImageView btnAggCar1;
    @FXML
    private ImageView btnAggCar2;
    @FXML
    private ImageView btnAggCar3;
    @FXML
    private AnchorPane contCar;
    @FXML
    private VBox tblProdCar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Produc1(MouseEvent event) {
        contProd1.setVisible(true);
    }

    @FXML
    private void Produc2(MouseEvent event) {
        contProd2.setVisible(true);
    }

    @FXML
    private void Produc3(MouseEvent event) {
        contProd3.setVisible(true);
    }

    @FXML
    private void irCarrito(ActionEvent event) {

    }

    @FXML
    private void irLista(ActionEvent event) {
        contTblFav.setVisible(true);

    }

    @FXML
    private void IrPago(ActionEvent event) {
    }

    @FXML
    private void IrLis(ActionEvent event) {
        contTblFav.setVisible(true);

    }

    @FXML
    private void Atras(MouseEvent event) {
        ImageView imageViewPresionado = (ImageView) event.getSource();
        String imageViewId = imageViewPresionado.getId();
        if (imageViewId.equals("btnProd1")) {
            contProd1.setVisible(false);
            contProd2.setVisible(false);
            contProd3.setVisible(false);
        } else if (imageViewId.equals("btnProd2")) {
            contProd2.setVisible(false);
            contProd1.setVisible(false);
            contProd3.setVisible(false);
        } else if (imageViewId.equals("btnProd3")) {
            contProd3.setVisible(false);
            contProd2.setVisible(false);
            contProd1.setVisible(false);
        }
    }

    @FXML
    private void agregarFav(MouseEvent event) {
        Label lblNombre = new Label();
        Button btnDel = new Button("ELIMINAR ELEMENTO");
        GridPane contLibSelected = new GridPane();
        ColumnConstraints column = new ColumnConstraints();
        ImageView imageViewPresionado = (ImageView) event.getSource();
        String imageViewId = imageViewPresionado.getId();

        if (imageViewId.equals("btnAggFav1")) {

            column.setPrefWidth(tblFav.getWidth() / 2);

            contLibSelected.getColumnConstraints().addAll(column);
            contLibSelected.prefWidth(tblFav.getMaxWidth());
            contLibSelected.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

            lblNombre.setText(nombreProd1.getText());

            contLibSelected.add(lblNombre, 0, 0);
            contLibSelected.add(btnDel, 1, 0);

            tblFav.getChildren().add(contLibSelected);
        } else if (imageViewId.equals("btnAggFav2")) {
            column.setPrefWidth(tblFav.getWidth() / 2);

            contLibSelected.getColumnConstraints().addAll(column);
            contLibSelected.prefWidth(tblFav.getMaxWidth());
            contLibSelected.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

            lblNombre.setText(nombreProd2.getText());

            contLibSelected.add(lblNombre, 0, 0);
            contLibSelected.add(btnDel, 1, 0);

            tblFav.getChildren().add(contLibSelected);
        } else if (imageViewId.equals("btnAggFav3")) {

            column.setPrefWidth(tblFav.getWidth() / 2);

            contLibSelected.getColumnConstraints().addAll(column);
            contLibSelected.prefWidth(tblFav.getMaxWidth());
            contLibSelected.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

            lblNombre.setText(nombreProd3.getText());

            contLibSelected.add(lblNombre, 0, 0);
            contLibSelected.add(btnDel, 1, 0);

            tblFav.getChildren().add(contLibSelected);
        }
    }

    @FXML
    private void volverCatalogoBtn(ActionEvent event) {
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
        contTblFav.setVisible(true);
    }

    @FXML
    private void AgregarCar(MouseEvent event) {
        Label lblNombre = new Label();
        Button btnDel = new Button("ELIMINAR ELEMENTO");
        GridPane contLibSelected = new GridPane();
        ColumnConstraints column = new ColumnConstraints();
        ImageView imageViewPresionado = (ImageView) event.getSource();
        String imageViewId = imageViewPresionado.getId();

        if (imageViewId.equals("btnAggCar1")) {

            column.setPrefWidth(tblFav.getWidth() / 2);

            contLibSelected.getColumnConstraints().addAll(column);
            contLibSelected.prefWidth(tblFav.getMaxWidth());
            contLibSelected.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

            lblNombre.setText(nombreProd1.getText());

            contLibSelected.add(lblNombre, 0, 0);
            contLibSelected.add(btnDel, 1, 0);

            tblFav.getChildren().add(contLibSelected);
        } else if (imageViewId.equals("btnAggCar2")) {
            column.setPrefWidth(tblFav.getWidth() / 2);

            contLibSelected.getColumnConstraints().addAll(column);
            contLibSelected.prefWidth(tblFav.getMaxWidth());
            contLibSelected.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

            lblNombre.setText(nombreProd2.getText());

            contLibSelected.add(lblNombre, 0, 0);
            contLibSelected.add(btnDel, 1, 0);

            tblFav.getChildren().add(contLibSelected);
        } else if (imageViewId.equals("btnAggCar3")) {

            column.setPrefWidth(tblFav.getWidth() / 2);

            contLibSelected.getColumnConstraints().addAll(column);
            contLibSelected.prefWidth(tblFav.getMaxWidth());
            contLibSelected.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

            lblNombre.setText(nombreProd3.getText());

            contLibSelected.add(lblNombre, 0, 0);
            contLibSelected.add(btnDel, 1, 0);

            tblFav.getChildren().add(contLibSelected);
        }
    }


}
