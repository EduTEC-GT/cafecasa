package gt.tec.cafecasa.cafecasa.menu;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gt.tec.cafecasa.cafecasa.entitys.Carrito;
import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.firebase.FirebaseHelper;
import gt.tec.cafecasa.cafecasa.firebase.FirebaseResut;
import gt.tec.cafecasa.cafecasa.general.Event;
import gt.tec.cafecasa.cafecasa.general.RepoImpl;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;
import gt.tec.cafecasa.cafecasa.util.ObjectSerializer;

public class MenuRepoImpl extends RepoImpl implements MenuRepo {
    public MenuRepoImpl(EventBus bus, Context context, FirebaseHelper helper, SharedPreferences preferences) {
        super(bus, context, helper, preferences);
    }

    @Override
    public void getMenu(String key) {
        helper.getMenu(key, new FirebaseResut() {
            @Override
            public void found(Object o) {
                bus.post(new Event(Event.getMenu, o));
            }

            @Override
            public void error(String error) {
                bus.post(new Event(error));
            }

            @Override
            public void ok() {

            }
        });
    }

    @Override
    public void agregarCart(Menu menu, int cantidad) {
        ArrayList<Carrito> carritos = new ArrayList<Carrito>();
        try {
            carritos = (ArrayList<Carrito>) ObjectSerializer.deserialize(preferences.getString("carrito", ObjectSerializer.serialize(new ArrayList<Carrito>())));
            carritos.add(new Carrito(menu, cantidad));
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("carrito", ObjectSerializer.serialize(carritos));
            editor.commit();
            totalCarrito();
        } catch (Exception e) {
            Log.e("cart", e.getLocalizedMessage());
        }
    }
}
