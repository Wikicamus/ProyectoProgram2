package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class ListaUsuario {

    Usuario cab;

    public ListaUsuario() {
        this.cab = null;
    }

    public boolean getUser(String correo) {
        // Verifica si ya existe un usuario con el mismo correo
        Usuario actual = cab;
        while (actual != null) {
            if (actual.getNombre().equals(correo)) {
                return true; // El correo ya está registrado
            }
            actual = actual.getSiguiente();
        }
        return false; // El correo no está registrado
    }

    public boolean verificarContraseña(String passwd) {
        Usuario actual = cab;
        while (actual != null) {
            if (actual.getContraseña().equals(passwd)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void addUser(
            TextField txtNomUser,
            TextField txtPasswrd,
            TextField txtDireccion
    ) {

        // Verifica si el correo ya está registrado
        if (getUser(txtNomUser.getText())) {
            mostrarAlerta("Error", "Ya existe un usuario con este correo.");
            return;
        }

        Usuario nuevoNodo = new Usuario(
                txtNomUser.getText(),
                txtPasswrd.getText(),
                txtDireccion.getText()
        ); // Agrega el nuevo nodo a la lista
        if (cab == null) {
            cab = nuevoNodo; // Si la lista está vacía, el nuevo nodo es la cabecera
        } else {
            nuevoNodo.setSiguiente(cab); // El siguiente del nuevo nodo es la cabecera actual
            cab.setAnterior(nuevoNodo); // El anterior de la cabecera actual es el nuevo nodo
            cab = nuevoNodo; // El nuevo nodo ahora es la cabecera
        }
        mostrarAlerta("Registro Exitoso", "¡¡Se ha registrado de manera exitosa!!");
    }

    public void guardarInfoUser() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("archivoUser.txt"))) {
            Usuario actual = cab;

            while (actual != null) {
                if (!correoRegEnArchivo(actual.getNombre())) {
                    String usuarioStr = String.format("%s,%s,%s",
                            actual.getNombre(),
                            actual.getContraseña(),
                            actual.getDireccion());

                    writer.write(usuarioStr);
                    writer.newLine();
                } else {
                    System.out.println("Correo duplicado: " + actual.getNombre());
                }

                actual = actual.getSiguiente();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarInfoUser() {
        try (BufferedReader reader = new BufferedReader(new FileReader("archivoUser.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Divide la línea en partes usando la coma como separador
                String[] partes = line.split(",");

                // Asegúrate de tener suficientes partes para construir un usuario
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String contra = partes[1].trim();
                    String direccion = partes[2].trim();

                    Usuario nuevoNodo = new Usuario(nombre, contra, direccion);

                    // Agrega el nuevo nodo a la lista
                    if (cab == null) {
                        cab = nuevoNodo;
                    } else {
                        nuevoNodo.setSiguiente(cab);
                        cab.setAnterior(nuevoNodo);
                        cab = nuevoNodo;
                    }
                }
            }
            System.out.println("La información se cargó correctamente desde el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }

    private boolean correoRegEnArchivo(String correo) {
        try (BufferedReader reader = new BufferedReader(new FileReader("archivoUser.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Divide la línea en partes usando la coma como separador
                String[] partes = line.split(",");

                // La posición 1 (índice 0) debería contener el correo en este ejemplo
                String correoEnArchivo = partes[1].trim();

                // Compara el correo actual con el correo en el archivo
                if (correoEnArchivo.equals(correo)) {
                    return true; // El correo ya está registrado
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        }

        return false; // El correo no está registrado
    }

    private void mostrarAlerta(String tipo, String contenido) {
        // Muestra una alerta al usuario
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle(tipo);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void mostrarMensajeConfirmacion(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void aggFavoritos() {

    }

    public void delFavoritos() {

    }

    public void makeBuy() {

    }

}
