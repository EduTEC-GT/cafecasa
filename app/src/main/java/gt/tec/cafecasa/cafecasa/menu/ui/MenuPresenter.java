package gt.tec.cafecasa.cafecasa.menu.ui;

import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.general.ui.Presenter;

public interface MenuPresenter extends Presenter {
    void getMenu(String key);

    void agregarCart(Menu menu, int i);
}
