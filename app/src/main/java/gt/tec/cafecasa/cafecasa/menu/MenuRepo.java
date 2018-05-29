package gt.tec.cafecasa.cafecasa.menu;

import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.general.Repo;

public interface MenuRepo extends Repo {
    void getMenu(String key);

    void agregarCart(Menu menu, int cantidad);
}
