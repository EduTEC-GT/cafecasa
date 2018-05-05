package gt.tec.cafecasa.cafecasa;

import android.app.Application;

import gt.tec.cafecasa.cafecasa.firebase.DI.FirebaseModule;
import gt.tec.cafecasa.cafecasa.lib.DI.LibsModule;
import gt.tec.cafecasa.cafecasa.main.DI.DaggerMainComponent;
import gt.tec.cafecasa.cafecasa.main.DI.MainComponent;
import gt.tec.cafecasa.cafecasa.main.DI.MainModule;
import gt.tec.cafecasa.cafecasa.main.ui.MainView;
import gt.tec.cafecasa.cafecasa.main.ui.adapters.OpcionesListener;

/**
 * Created by javie on 11/28/2017.
 */

public class App extends Application {
    private AppModule appModule;
    private LibsModule libsModule;
    private FirebaseModule firebaseModule;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initModules();
    }

    private void initModules() {
        this.appModule = new AppModule(this);
        this.libsModule = new LibsModule();
        this.firebaseModule = new FirebaseModule();
    }

    public static synchronized App getInstance() {
        return instance;
    }

    public static String getUserSharedPreferences() {
        return "cafe-casa-app";
    }

    //Inyeccion - INICIO
    public MainComponent main(MainView view, OpcionesListener listener){
        return DaggerMainComponent.builder()
                .appModule(appModule)
                .libsModule(libsModule)
                .firebaseModule(firebaseModule)
                .mainModule(new MainModule(view, listener))
                .build();
    }
    //Inyection - FIN
}
