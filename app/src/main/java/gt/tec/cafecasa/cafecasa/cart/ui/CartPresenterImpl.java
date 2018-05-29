package gt.tec.cafecasa.cafecasa.cart.ui;

import android.content.Context;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import gt.tec.cafecasa.cafecasa.cart.CartInteractor;
import gt.tec.cafecasa.cafecasa.entitys.Carrito;
import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.general.Event;
import gt.tec.cafecasa.cafecasa.general.Interactor;
import gt.tec.cafecasa.cafecasa.general.ui.PresenterImpl;
import gt.tec.cafecasa.cafecasa.general.ui.View;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;

public class CartPresenterImpl extends PresenterImpl implements CartPresenter {

    private CartView cartView;
    private CartInteractor cartInteractor;

    public CartPresenterImpl(EventBus bus, Context context, CartView view, CartInteractor interactor) {
        super(bus, context, view, interactor);
        this.cartView = view;
        this.cartInteractor = interactor;
    }

    @Override
    @Subscribe
    public void onEvent(Event event) {
        super.onEvent(event);
    }

    @Override
    public void moreOnEvent(Event event) {
        switch (event.getTipo()){
            case Event.getCarrito:
                cartView.getCarrito((ArrayList<Carrito>) event.getObject());
                break;
        }
    }

    @Override
    public void getCarrito() {
        view.loading(true);
        this.cartInteractor.getCarrito();
    }

    @Override
    public void updateCart(Menu menu, int cantidad) {
        view.loading(true);
        this.cartInteractor.updateCart(menu, cantidad);
    }
}
