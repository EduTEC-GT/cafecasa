package gt.tec.cafecasa.cafecasa.menu;

import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.general.Interactor;

public interface MenuInteractor extends Interactor {
    void getMenu(String key);

    void agregarCart(Menu menu, int cantidad);
}
