package gt.tec.cafecasa.cafecasa.cart.DI;

import javax.inject.Singleton;

import dagger.Component;
import gt.tec.cafecasa.cafecasa.AppModule;
import gt.tec.cafecasa.cafecasa.cart.ui.CartActivity;
import gt.tec.cafecasa.cafecasa.firebase.DI.FirebaseModule;
import gt.tec.cafecasa.cafecasa.lib.DI.LibsModule;

@Singleton
@Component(modules = {AppModule.class, LibsModule.class, FirebaseModule.class, CartModule.class})
public interface CartComponent {
    void inject(CartActivity activity);
}
