package gt.tec.cafecasa.cafecasa.menu;

import android.content.Context;

import gt.tec.cafecasa.cafecasa.R;
import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.general.Event;
import gt.tec.cafecasa.cafecasa.general.InteractorImpl;
import gt.tec.cafecasa.cafecasa.general.Repo;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;

public class MenuInteractorImpl extends InteractorImpl implements MenuInteractor {

    private MenuRepo menuRepo;

    public MenuInteractorImpl(EventBus bus, Context context, MenuRepo repo) {
        super(bus, context, repo);
        this.menuRepo = repo;
    }

    @Override
    public void getMenu(String key) {
        if (key != null && !key.isEmpty()){
            this.menuRepo.getMenu(key);
        }else{
            bus.post(new Event(context.getString(R.string.opcion_invalida)));
        }
    }

    @Override
    public void agregarCart(Menu menu, int cantidad) {
        if (cantidad > 0){
            menuRepo.agregarCart(menu, cantidad);
        }else{
            bus.post(new Event(context.getString(R.string.cantidad_invalida)));
        }
    }
}
