package gt.tec.cafecasa.cafecasa.entitys;

import java.io.Serializable;

public class Opciones implements Serializable {
    private String key;
    private String nombre;
    private String imagen;

    public Opciones() {
    }

    public Opciones(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Opciones(String key, String nombre, String imagen) {
        this.key = key;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
