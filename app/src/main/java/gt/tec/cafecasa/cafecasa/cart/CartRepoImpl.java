package gt.tec.cafecasa.cafecasa.cart;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;
import java.util.ArrayList;

import gt.tec.cafecasa.cafecasa.entitys.Carrito;
import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.firebase.FirebaseHelper;
import gt.tec.cafecasa.cafecasa.general.Event;
import gt.tec.cafecasa.cafecasa.general.RepoImpl;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;
import gt.tec.cafecasa.cafecasa.util.ObjectSerializer;

public class CartRepoImpl extends RepoImpl implements CartRepo {
    public CartRepoImpl(EventBus bus, Context context, FirebaseHelper helper, SharedPreferences preferences) {
        super(bus, context, helper, preferences);
    }

    @Override
    public void getCarrito() {
        ArrayList<Carrito> carritos = new ArrayList<Carrito>();
        try {
            carritos = (ArrayList<Carrito>) ObjectSerializer.deserialize(preferences.getString("carrito", ObjectSerializer.serialize(new ArrayList<Carrito>())));
        } catch (Exception e) {
            bus.post(new Event(e.getLocalizedMessage()));
        }
        bus.post(new Event(Event.getCarrito, carritos));
    }

    @Override
    public void updateCart(Menu menu, int cantidad) {
        ArrayList<Carrito> carritos = new ArrayList<Carrito>();
        ArrayList<Carrito> carritosNuevos = new ArrayList<Carrito>();
        try {
            carritos = (ArrayList<Carrito>) ObjectSerializer.deserialize(preferences.getString("carrito", ObjectSerializer.serialize(new ArrayList<Carrito>())));
            for (Carrito carrito : carritos){
                if (carrito.getMenu().getKey().equals(menu.getKey())){
                    carrito.setCantidad(cantidad);
                }
                if (carrito.getCantidad() > 0){
                    carritosNuevos.add(carrito);
                }
            }
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("carrito", ObjectSerializer.serialize(carritosNuevos));
            editor.commit();
            totalCarrito();
            getCarrito();
        } catch (Exception e) {
            bus.post(new Event(e.getLocalizedMessage()));
        }
    }
}
