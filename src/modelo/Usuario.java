package modelo;

/**
 *
 * @author wikic
 */
public class Usuario {
    
    public String nombre;
    public String contraseña;
    public String direccion;
    Usuario siguiente;
    Usuario anterior;

    public Usuario(String nombre, String contraseña, String direccion) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.direccion = direccion;
        this.siguiente = null;
        this.anterior = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
