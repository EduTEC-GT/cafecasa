package gt.tec.cafecasa.cafecasa.cart.ui;

import java.util.ArrayList;

import gt.tec.cafecasa.cafecasa.entitys.Carrito;
import gt.tec.cafecasa.cafecasa.general.ui.View;

public interface CartView extends View {
    void getCarrito(ArrayList<Carrito> carritos);
}
