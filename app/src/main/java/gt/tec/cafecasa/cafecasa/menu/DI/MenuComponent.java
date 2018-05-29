package gt.tec.cafecasa.cafecasa.menu.DI;

import javax.inject.Singleton;

import dagger.Component;
import gt.tec.cafecasa.cafecasa.AppModule;
import gt.tec.cafecasa.cafecasa.firebase.DI.FirebaseModule;
import gt.tec.cafecasa.cafecasa.lib.DI.LibsModule;
import gt.tec.cafecasa.cafecasa.menu.ui.MenuActivity;

@Singleton
@Component(modules = {AppModule.class, LibsModule.class, FirebaseModule.class, MenuModule.class})
public interface MenuComponent {
    void inject(MenuActivity activity);
}
