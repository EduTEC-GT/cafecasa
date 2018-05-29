package gt.tec.cafecasa.cafecasa.cart.ui;

import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.general.ui.Presenter;

public interface CartPresenter extends Presenter {
    void getCarrito();

    void updateCart(Menu menu, int cantidad);
}
