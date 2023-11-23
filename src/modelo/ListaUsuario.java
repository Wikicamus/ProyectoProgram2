package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
    public void guardarEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Usuarios.txt"))) {
            Usuario actual = cab;
            while (actual != null) {
                // Escribir la información del usuario en el archivo
                writer.write(actual.getNombre() + "," + actual.getContraseña() + "," + actual.getDireccion());
                writer.newLine(); // Agregar nueva línea para el próximo usuario
                actual = actual.siguiente;
            }
            System.out.println("Información de usuarios guardada en el archivo: ");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

// Método para buscar un usuario por nombre de usuario
    private Usuario buscarUsuario(String nombreUsuario) {
        Usuario actual = cab;
        while (actual != null) {
            if (actual.getNombre().equals(nombreUsuario)) {
                return actual; // El usuario ya existe en la lista
            }
            actual = actual.siguiente;
        }
        return null; // El usuario no existe en la lista
    }
}
