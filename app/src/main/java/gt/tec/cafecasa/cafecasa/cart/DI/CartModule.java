package gt.tec.cafecasa.cafecasa.cart.DI;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gt.tec.cafecasa.cafecasa.cart.CartInteractor;
import gt.tec.cafecasa.cafecasa.cart.CartInteractorImpl;
import gt.tec.cafecasa.cafecasa.cart.CartRepo;
import gt.tec.cafecasa.cafecasa.cart.CartRepoImpl;
import gt.tec.cafecasa.cafecasa.cart.ui.CartPresenter;
import gt.tec.cafecasa.cafecasa.cart.ui.CartPresenterImpl;
import gt.tec.cafecasa.cafecasa.cart.ui.CartView;
import gt.tec.cafecasa.cafecasa.cart.ui.adapters.CarritoAdapter;
import gt.tec.cafecasa.cafecasa.cart.ui.adapters.CartClickListener;
import gt.tec.cafecasa.cafecasa.entitys.Carrito;
import gt.tec.cafecasa.cafecasa.firebase.FirebaseHelper;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;
import gt.tec.cafecasa.cafecasa.lib.base.ImageLoader;

@Module
public class CartModule {
    private CartView view;
    private CartClickListener listener;

    public CartModule(CartView view, CartClickListener listener) {
        this.view = view;
        this.listener = listener;
    }

    @Singleton
    @Provides
    CartView providesCartView() {
        return this.view;
    }

    @Singleton
    @Provides
    CartPresenter providesCartPresenter(EventBus bus, Context context, CartView view, CartInteractor interactor) {
        return new CartPresenterImpl(bus, context, view, interactor);
    }

    @Singleton
    @Provides
    CartInteractor providesCartInteractor(EventBus bus, Context context, CartRepo repo) {
        return new CartInteractorImpl(bus, context, repo);
    }

    @Singleton
    @Provides
    CartRepo providesCartRepo(EventBus bus, Context context, FirebaseHelper helper, SharedPreferences preferences) {
        return new CartRepoImpl(bus, context, helper, preferences);
    }

    @Singleton
    @Provides
    CartClickListener providesCartClickListener() {
        return this.listener;
    }

    @Singleton
    @Provides
    ArrayList<Carrito> providesListadoCarrito() {
        return new ArrayList<Carrito>();
    }

    @Singleton
    @Provides
    CarritoAdapter providesCarritoAdapter(ImageLoader imageLoader, ArrayList<Carrito> carritos,
                                          DecimalFormat decimalFormat, CartClickListener listener) {
        return new CarritoAdapter(imageLoader, carritos, decimalFormat, listener);
    }
}
