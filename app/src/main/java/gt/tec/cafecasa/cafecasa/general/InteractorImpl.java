package gt.tec.cafecasa.cafecasa.general;

import android.content.Context;

import gt.tec.cafecasa.cafecasa.lib.base.EventBus;

public class InteractorImpl implements Interactor {

    public EventBus bus;
    public Context context;
    public Repo repo;

    public InteractorImpl(EventBus bus, Context context, Repo repo) {
        this.bus = bus;
        this.context = context;
        this.repo = repo;
    }

    @Override
    public void getUsuario() {
        repo.getUsuario();
    }
}
