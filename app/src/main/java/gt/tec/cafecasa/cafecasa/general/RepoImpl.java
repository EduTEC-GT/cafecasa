package gt.tec.cafecasa.cafecasa.general;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import gt.tec.cafecasa.cafecasa.entitys.Carrito;
import gt.tec.cafecasa.cafecasa.firebase.FirebaseHelper;
import gt.tec.cafecasa.cafecasa.firebase.FirebaseResut;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;
import gt.tec.cafecasa.cafecasa.util.ObjectSerializer;

public class RepoImpl implements Repo {

    public EventBus bus;
    public Context context;
    public FirebaseHelper helper;
    public SharedPreferences preferences;

    public RepoImpl(EventBus bus, Context context, FirebaseHelper helper, SharedPreferences preferences) {
        this.bus = bus;
        this.context = context;
        this.helper = helper;
        this.preferences = preferences;
    }

    @Override
    public void getUsuario() {
        helper.getUsuario(new FirebaseResut() {
            @Override
            public void found(Object o) {
                bus.post(new Event(Event.getUsuario, o));
            }

            @Override
            public void error(String error) {
                bus.post(new Event(Event.forcedLogout));
            }

            @Override
            public void ok() {

            }
        });
    }

    @Override
    public void totalCarrito() {
        double total = 0;
        try {
            ArrayList<Carrito> carritos = (ArrayList<Carrito>) ObjectSerializer.deserialize(preferences.getString("carrito", ObjectSerializer.serialize(new ArrayList<Carrito>())));
            for (Carrito carrito : carritos){
                total = total + (carrito.getCantidad() * carrito.getMenu().getPrecio());
            }
        } catch (Exception e) {
            Log.e("total", e.getLocalizedMessage());
        }
        bus.post(new Event(Event.totalCarrito, total));
    }
}
