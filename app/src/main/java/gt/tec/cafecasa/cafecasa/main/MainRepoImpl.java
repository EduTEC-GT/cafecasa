package gt.tec.cafecasa.cafecasa.main;

import android.content.Context;
import android.content.SharedPreferences;

import gt.tec.cafecasa.cafecasa.firebase.FirebaseHelper;
import gt.tec.cafecasa.cafecasa.firebase.FirebaseResut;
import gt.tec.cafecasa.cafecasa.general.Event;
import gt.tec.cafecasa.cafecasa.general.RepoImpl;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;

public class MainRepoImpl extends RepoImpl implements MainRepo {
    public MainRepoImpl(EventBus bus, Context context, FirebaseHelper helper, SharedPreferences preferences) {
        super(bus, context, helper, preferences);
    }

    @Override
    public void getOpciones() {
        helper.getOpciones(new FirebaseResut() {
            @Override
            public void found(Object o) {
                bus.post(new Event(Event.getOpciones, o));
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
}
