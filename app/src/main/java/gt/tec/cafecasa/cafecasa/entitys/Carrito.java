package gt.tec.cafecasa.cafecasa.entitys;

import java.io.Serializable;

public class Carrito implements Serializable{

    private Menu menu;
    private int cantidad;

    public Carrito() {
    }

    public Carrito(Menu menu, int cantidad) {
        this.menu = menu;
        this.cantidad = cantidad;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
