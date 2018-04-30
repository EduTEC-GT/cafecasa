package gt.tec.cafecasa.cafecasa.firebase.DI;

import javax.inject.Singleton;

import dagger.Component;
import gt.tec.cafecasa.cafecasa.AppModule;
import gt.tec.cafecasa.cafecasa.lib.DI.LibsModule;

/**
 * Created by javie on 11/12/2017.
 */
@Singleton
@Component(modules = {AppModule.class, LibsModule.class, FirebaseModule.class})
public interface FirebaseComponent {
}
