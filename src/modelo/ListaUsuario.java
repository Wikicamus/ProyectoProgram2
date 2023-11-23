package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/**
 *
 * @author wikic
 */
public class ListaUsuario {

    Usuario cab;

    public ListaUsuario() {
        cab = null;
    }

    public void agregar(TextField txtNomUser, TextField txtPasswrd, TextField txtDireccion) {
        String nombreUsuario = txtNomUser.getText();
        String contrasena = txtPasswrd.getText();
        String direccion = txtDireccion.getText();

        // Verificar si el nombre de usuario ya existe en la lista
        if (buscarUsuario(nombreUsuario) != null) {
            System.out.println("El nombre de usuario ya existe. Por favor, elija otro.");
            return;
        }

        Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasena, direccion);

        if (cab == null) {
            cab = nuevoUsuario;
        } else {
            nuevoUsuario.siguiente = cab;
            cab.anterior = nuevoUsuario;
            cab = nuevoUsuario;
        }

        System.out.println("Usuario agregado: " + nombreUsuario);
    }

// Método para buscar un usuario por nombre de usuario
    public Usuario buscarUsuario(String nombreUsuario) {
        Usuario actual = cab;
        while (actual != null) {
            if (actual.getNombre().equals(nombreUsuario)) {
                return actual; // El usuario ya existe en la lista
            }
            actual = actual.siguiente;
        }
        return null; // El usuario no existe en la lista
    }

public void ActualizarElArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Usuarios.txt"))) {
            Usuario actual = cab;
            while (actual != null) {
                // Escribir la información del usuario en el archivo
                writer.write(actual.getNombre() + "," + actual.getContraseña() + "," + actual.getDireccion());
                writer.newLine(); // Agregar nueva línea para el próximo usuario
                actual = actual.siguiente;
            }
            System.out.println("Información de usuarios guardada/actualizada en el archivo: Usuarios.txt");
        } catch (IOException e) {
            mostrarAlertaError("Error al escribir en el archivo", e.getMessage());
        }
    }

    private void mostrarAlertaError(String titulo, String mensaje) {
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(titulo);
        alerta.setContentText(mensaje);
        
        // Mostrar la alerta en el hilo de JavaFX para garantizar que se muestre correctamente
        Platform.runLater(() -> alerta.showAndWait());
    }
}
