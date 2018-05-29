package gt.tec.cafecasa.cafecasa.menu.ui;

import android.content.Context;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.general.Event;
import gt.tec.cafecasa.cafecasa.general.Interactor;
import gt.tec.cafecasa.cafecasa.general.ui.PresenterImpl;
import gt.tec.cafecasa.cafecasa.general.ui.View;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;
import gt.tec.cafecasa.cafecasa.menu.MenuInteractor;


public class MenuPresenterImpl extends PresenterImpl implements MenuPresenter {

    private MenuView menuView;
    private MenuInteractor menuInteractor;

    public MenuPresenterImpl(EventBus bus, Context context, MenuView view, MenuInteractor interactor) {
        super(bus, context, view, interactor);
        this.menuView = view;
        this.menuInteractor = interactor;
    }

    @Override
    @Subscribe
    public void onEvent(Event event) {
        super.onEvent(event);
    }

    @Override
    public void moreOnEvent(Event event) {
        switch (event.getTipo()){
            case Event.getMenu:
                menuView.getMenu((List<Menu>) event.getObject());
                break;
        }
    }

    @Override
    public void getMenu(String key) {
        view.loading(true);
        menuInteractor.getMenu(key);
    }

    @Override
    public void agregarCart(Menu menu, int cantidad) {
        view.loading(true);
        menuInteractor.agregarCart(menu, cantidad);
    }
}
