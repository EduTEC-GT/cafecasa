package gt.tec.cafecasa.cafecasa.main;

import android.content.Context;

import gt.tec.cafecasa.cafecasa.general.Event;
import gt.tec.cafecasa.cafecasa.general.InteractorImpl;
import gt.tec.cafecasa.cafecasa.general.Repo;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;

public class MainInteractorImpl extends InteractorImpl implements MainInteractor {

    private MainRepo mainRepo;

    public MainInteractorImpl(EventBus bus, Context context, MainRepo repo) {
        super(bus, context, repo);
        this.mainRepo = repo;
    }

    @Override
    public void getOpciones() {
        mainRepo.getOpciones();
    }
}
