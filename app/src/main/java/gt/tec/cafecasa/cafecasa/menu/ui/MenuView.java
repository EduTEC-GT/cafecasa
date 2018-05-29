package gt.tec.cafecasa.cafecasa.menu.ui;

import java.util.List;

import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.general.ui.View;

public interface MenuView extends View {
    void getMenu(List<Menu> menu);
}
