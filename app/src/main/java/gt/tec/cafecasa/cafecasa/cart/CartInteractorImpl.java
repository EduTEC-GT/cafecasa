package gt.tec.cafecasa.cafecasa.cart;

import android.content.Context;

import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.general.InteractorImpl;
import gt.tec.cafecasa.cafecasa.general.Repo;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;

public class CartInteractorImpl extends InteractorImpl implements CartInteractor {

    private CartRepo cartRepo;

    public CartInteractorImpl(EventBus bus, Context context, CartRepo repo) {
        super(bus, context, repo);
        this.cartRepo = repo;
    }

    @Override
    public void getCarrito() {
        this.cartRepo.getCarrito();
    }

    @Override
    public void updateCart(Menu menu, int cantidad) {
        this.cartRepo.updateCart(menu, cantidad);
    }
}
