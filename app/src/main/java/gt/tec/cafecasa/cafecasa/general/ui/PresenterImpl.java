package gt.tec.cafecasa.cafecasa.general.ui;

import android.content.Context;

import com.google.firebase.auth.FirebaseUser;

import gt.tec.cafecasa.cafecasa.general.Event;
import gt.tec.cafecasa.cafecasa.general.Interactor;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;

public class PresenterImpl implements Presenter {

    public EventBus bus;
    public Context context;
    public View view;
    public Interactor interactor;

    public PresenterImpl(EventBus bus, Context context, View view, Interactor interactor) {
        this.bus = bus;
        this.context = context;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onCreate() {
        bus.register(this);
    }

    @Override
    public void onDestroy() {
        bus.unRegister(this);
    }

    @Override
    public void getUsuario() {
        view.loading(true);
        interactor.getUsuario();
    }

    @Override
    public void onEvent(Event event) {
        view.loading(false);
        if (event.getError() != null && !event.getError().isEmpty()) {
            view.showError(event.getError());
        } else {
            if (event.getMensaje() != null && !event.getMensaje().isEmpty()) {
                view.showMessage(event.getMensaje());
            }
            switch (event.getTipo()) {
                case Event.getUsuario:
                    view.loadUser((FirebaseUser) event.getObject());
                    break;
                case Event.forcedLogout:
                    view.forcedLogout();
                    break;
                case Event.totalCarrito:
                    view.totalCarrito((Double) event.getObject());
                    break;
                default:
                    moreOnEvent(event);
            }
        }
    }

    @Override
    public void moreOnEvent(Event event) {
    }

    @Override
    public void totalCarrito() {
        view.loading(true);
        interactor.totalCarrito();
    }
}
