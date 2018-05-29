package gt.tec.cafecasa.cafecasa.main.DI;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gt.tec.cafecasa.cafecasa.entitys.Opciones;
import gt.tec.cafecasa.cafecasa.firebase.FirebaseHelper;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;
import gt.tec.cafecasa.cafecasa.lib.base.ImageLoader;
import gt.tec.cafecasa.cafecasa.main.MainInteractor;
import gt.tec.cafecasa.cafecasa.main.MainInteractorImpl;
import gt.tec.cafecasa.cafecasa.main.MainRepo;
import gt.tec.cafecasa.cafecasa.main.MainRepoImpl;
import gt.tec.cafecasa.cafecasa.main.ui.MainPresenter;
import gt.tec.cafecasa.cafecasa.main.ui.MainPresenterImpl;
import gt.tec.cafecasa.cafecasa.main.ui.MainView;
import gt.tec.cafecasa.cafecasa.main.ui.adapters.MainAdapter;
import gt.tec.cafecasa.cafecasa.main.ui.adapters.OpcionesListener;

@Module
public class MainModule {

    private MainView view;
    private OpcionesListener listener;

    public MainModule(MainView view, OpcionesListener listener) {
        this.view = view;
        this.listener = listener;
    }

    @Singleton
    @Provides
    MainView providesMainView(){
        return this.view;
    }

    @Singleton
    @Provides
    OpcionesListener providesOpcionesListener(){
        return this.listener;
    }

    @Singleton
    @Provides
    MainPresenter providesMainPresenter(EventBus bus, Context  context, MainView view, MainInteractor interactor){
        return new MainPresenterImpl(bus, context, view, interactor);
    }

    @Singleton
    @Provides
    MainInteractor providesMainInteractor(EventBus bus, Context context, MainRepo repo){
        return new MainInteractorImpl(bus, context, repo);
    }

    @Singleton
    @Provides
    MainRepo providesMainRepo(EventBus bus, Context context, FirebaseHelper helper, SharedPreferences preferences){
        return new MainRepoImpl(bus, context, helper,preferences);
    }

    @Singleton
    @Provides
    MainAdapter providesMainAdapter(List<Opciones> opciones, OpcionesListener listener
    , Context context, ImageLoader imageLoader){
        return new MainAdapter(opciones, listener, context, imageLoader);
    }

    @Singleton
    @Provides
    List<Opciones> providesListOpcioens(){
        return new ArrayList<Opciones>();
    }
}
