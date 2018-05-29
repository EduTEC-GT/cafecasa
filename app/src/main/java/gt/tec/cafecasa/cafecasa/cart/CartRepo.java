package gt.tec.cafecasa.cafecasa.cart;

import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.general.Repo;

public interface CartRepo extends Repo {
    void getCarrito();
    void updateCart(Menu menu, int cantidad);
}
