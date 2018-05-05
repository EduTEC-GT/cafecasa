package gt.tec.cafecasa.cafecasa.general;

import android.content.Context;

import gt.tec.cafecasa.cafecasa.firebase.FirebaseHelper;
import gt.tec.cafecasa.cafecasa.firebase.FirebaseResut;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;

public class RepoImpl implements Repo {

    public EventBus bus;
    public Context context;
    public FirebaseHelper helper;

    public RepoImpl(EventBus bus, Context context, FirebaseHelper helper) {
        this.bus = bus;
        this.context = context;
        this.helper = helper;
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
}
