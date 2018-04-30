package gt.tec.cafecasa.cafecasa.main.DI;

import javax.inject.Singleton;

import dagger.Component;
import gt.tec.cafecasa.cafecasa.AppModule;
import gt.tec.cafecasa.cafecasa.firebase.DI.FirebaseModule;
import gt.tec.cafecasa.cafecasa.lib.DI.LibsModule;
import gt.tec.cafecasa.cafecasa.main.ui.MainActivity;

@Singleton
@Component(modules = {AppModule.class, LibsModule.class, FirebaseModule.class, MainModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
