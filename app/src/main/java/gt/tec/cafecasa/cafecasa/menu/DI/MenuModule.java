package gt.tec.cafecasa.cafecasa.menu.DI;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.firebase.FirebaseHelper;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;
import gt.tec.cafecasa.cafecasa.lib.base.ImageLoader;
import gt.tec.cafecasa.cafecasa.menu.MenuInteractor;
import gt.tec.cafecasa.cafecasa.menu.MenuInteractorImpl;
import gt.tec.cafecasa.cafecasa.menu.MenuRepo;
import gt.tec.cafecasa.cafecasa.menu.MenuRepoImpl;
import gt.tec.cafecasa.cafecasa.menu.ui.MenuPresenter;
import gt.tec.cafecasa.cafecasa.menu.ui.MenuPresenterImpl;
import gt.tec.cafecasa.cafecasa.menu.ui.MenuView;
import gt.tec.cafecasa.cafecasa.menu.ui.adapters.MenuAdapter;
import gt.tec.cafecasa.cafecasa.menu.ui.adapters.MenuClickListener;

@Module
public class MenuModule {
    private MenuView view;
    private MenuClickListener listener;

    public MenuModule(MenuView view, MenuClickListener listener) {
        this.view = view;
        this.listener = listener;
    }

    @Singleton
    @Provides
    MenuView providesMenuView(){
        return this.view;
    }

    @Singleton
    @Provides
    MenuPresenter providesMenuPresenter(EventBus bus, Context context, MenuView view, MenuInteractor interactor){
        return new MenuPresenterImpl(bus, context, view, interactor);
    }

    @Singleton
    @Provides
    MenuInteractor providesMenuInteractor(EventBus bus, Context context, MenuRepo repo){
        return new MenuInteractorImpl(bus, context, repo);
    }

    @Singleton
    @Provides
    MenuRepo providesMenuRepo(EventBus bus, Context context, FirebaseHelper helper, SharedPreferences preferences){
        return new MenuRepoImpl(bus, context, helper, preferences);
    }

    @Singleton
    @Provides
    MenuClickListener providesMenuClickListener(){
        return this.listener;
    }

    @Singleton
    @Provides
    List<Menu> provideMenuList(){
        return new ArrayList<Menu>();
    }

    @Singleton
    @Provides
    MenuAdapter providesMenuAdapter(List<Menu> menus, ImageLoader imageLoader, MenuClickListener listener, DecimalFormat decimalFormat){
        return new MenuAdapter(menus, imageLoader, listener, decimalFormat);
    }
}
