/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
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
import javafx.stage.StageStyle;

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
    @FXML
    private Label lblPrecio1;
    @FXML
    private Label lblPrecio2;
    @FXML
    private Label lblPrecio3;
    @FXML
    private ImageView btnCar;

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
    private void IrPago(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/OpcionesPago.fxml"));
            Parent root = loader.load();

            Stage vtnRegister = new Stage();
            vtnRegister.setTitle("REGISTRO");
            vtnRegister.setScene(new Scene(root));

            // Obtén el controlador de la segunda ventana si es necesario
            OpcionesPagoController controlOpciones = loader.getController();

            vtnRegister.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        btnDel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Botón clickeado");

                tblFav.getChildren().remove(contLibSelected);
            }
        });

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
                mostrarAlerta("INFORMACION","PRODUCTO AGREGADO A FAVORITOS");

    }

    @FXML
    private void volverCatalogoBtn(ActionEvent event) {
        contCar.setVisible(false);
        contTblFav.setVisible(false);

    }

    @FXML
    private void VolverCat(MouseEvent event) {
        contTblFav.setVisible(false);
        contCar.setVisible(false);
    }

    @FXML
    private void AgregarCar(MouseEvent event) {
        Label lblNombre = new Label();
        Label lblPrecio = new Label();
        Label lblCant = new Label();
        Label lblPrecioT = new Label();
        Spinner<Integer> cant = new Spinner(1, 10, 1);
        Button btnDel = new Button("ELIMINAR ELEMENTO");

        GridPane contLibSelected = new GridPane();
        ColumnConstraints column = new ColumnConstraints();
        ImageView imageViewPresionado = (ImageView) event.getSource();
        String imageViewId = imageViewPresionado.getId();
        btnDel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Botón clickeado");

                tblProdCar.getChildren().remove(contLibSelected);
            }
        });

        if (imageViewId.equals("btnAggCar1")) {

            column.setPrefWidth(tblFav.getWidth() / 2);

            contLibSelected.getColumnConstraints().addAll(column);
            contLibSelected.prefWidth(tblProdCar.getMaxWidth());
            contLibSelected.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

            lblNombre.setText(nombreProd1.getText());
            lblPrecio.setText(textoDosPuntos(lblPrecio1));
            lblCant.setText(String.valueOf(cant.getValue()));
            double cantTotal = Integer.parseInt(lblCant.getText()) * Double.parseDouble(lblPrecio.getText());
            lblPrecioT.setText(String.valueOf(cantTotal));

            contLibSelected.add(lblNombre, 0, 0);
            contLibSelected.add(lblPrecio, 1, 0);
            contLibSelected.add(lblCant, 0, 1);
            contLibSelected.add(lblPrecioT, 1, 1);
            contLibSelected.add(btnDel, 0, 2);
            contLibSelected.add(cant, 1, 2);

            tblProdCar.getChildren().add(contLibSelected);
        } else if (imageViewId.equals("btnAggCar2")) {
            column.setPrefWidth(tblFav.getWidth() / 2);

            contLibSelected.getColumnConstraints().addAll(column);
            contLibSelected.prefWidth(tblProdCar.getMaxWidth());
            contLibSelected.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

            lblNombre.setText(nombreProd2.getText());
            lblPrecio.setText(textoDosPuntos(lblPrecio2));
            lblCant.setText(String.valueOf(cant.getValue()));
            double cantTotal = Integer.parseInt(lblCant.getText()) * Double.parseDouble(lblPrecio.getText());
            lblPrecioT.setText(String.valueOf(cantTotal));

            contLibSelected.add(lblNombre, 0, 0);
            contLibSelected.add(lblPrecio, 1, 0);
            contLibSelected.add(lblCant, 0, 1);
            contLibSelected.add(lblPrecioT, 1, 1);
            contLibSelected.add(btnDel, 0, 2);
            contLibSelected.add(cant, 1, 2);

            tblProdCar.getChildren().add(contLibSelected);
        } else if (imageViewId.equals("btnAggCar3")) {

            column.setPrefWidth(tblFav.getWidth() / 2);

            contLibSelected.getColumnConstraints().addAll(column);
            contLibSelected.prefWidth(tblProdCar.getMaxWidth());
            contLibSelected.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

            lblNombre.setText(nombreProd3.getText());
            lblPrecio.setText(textoDosPuntos(lblPrecio3));
            lblCant.setText(String.valueOf(cant.getValue()));
            double cantTotal = Integer.parseInt(lblCant.getText()) * Double.parseDouble(lblPrecio.getText());
            lblPrecioT.setText(String.valueOf(cantTotal));

            contLibSelected.add(lblNombre, 0, 0);
            contLibSelected.add(lblPrecio, 1, 0);
            contLibSelected.add(lblCant, 0, 1);
            contLibSelected.add(lblPrecioT, 1, 1);
            contLibSelected.add(btnDel, 0, 2);
            contLibSelected.add(cant, 1, 2);

            tblProdCar.getChildren().add(contLibSelected);
        }
        mostrarAlerta("INFORMACION","PRODUCTO AGREGADO AL CARRITO");
    }

    @FXML
    private void abrirCarrito(ActionEvent event) {
        contCar.setVisible(true);

    }

    @FXML
    private void abrirFavoritos(ActionEvent event) {
        contTblFav.setVisible(true);

    }

    public String textoDosPuntos(Label label) {
        String textoCompleto = label.getText();
        // Buscar la posición del primer carácter dos puntos
        int indiceDosPuntos = textoCompleto.indexOf(':');

        // Verificar si se encontró el primer carácter dos puntos
        if (indiceDosPuntos != -1 && indiceDosPuntos < textoCompleto.length() - 1) {
            // Obtener el texto después de dos puntos
            String textoDespuesDosPuntos = textoCompleto.substring(indiceDosPuntos + 1);

            // Imprimir o utilizar el texto obtenido
            return textoDespuesDosPuntos;
        } else {
            // Manejar el caso en el que no se encuentren dos puntos o estén al final del texto
            return null;
        }
    }

    public void mostrarAlerta(String titulo, String msj) {
        // Crear una alerta de información
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.initStyle(StageStyle.UTILITY);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(msj);

        // Agregar un botón de cierre
        ButtonType cerrarBoton = new ButtonType("Cerrar");
        alerta.getButtonTypes().setAll(cerrarBoton);

        // Mostrar la alerta y esperar a que el usuario cierre
        alerta.showAndWait();
    }

}
