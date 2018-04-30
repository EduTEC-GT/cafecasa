package gt.tec.cafecasa.cafecasa.main.ui;

import android.content.Context;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import gt.tec.cafecasa.cafecasa.entitys.Opciones;
import gt.tec.cafecasa.cafecasa.general.Event;
import gt.tec.cafecasa.cafecasa.general.Interactor;
import gt.tec.cafecasa.cafecasa.general.ui.PresenterImpl;
import gt.tec.cafecasa.cafecasa.general.ui.View;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;
import gt.tec.cafecasa.cafecasa.main.MainInteractor;

public class MainPresenterImpl extends PresenterImpl implements MainPresenter {

    private MainInteractor mainInteractor;
    private MainView mainView;

    public MainPresenterImpl(EventBus bus, Context context, MainView view, MainInteractor interactor) {
        super(bus, context, view, interactor);
        mainInteractor = interactor;
        mainView = view;
    }

    @Override
    @Subscribe
    public void onEvent(Event event) {
        super.onEvent(event);
    }

    @Override
    public void moreOnEvent(Event event) {
        switch (event.getTipo()){
            case Event.getOpciones:
                mainView.setOpciones((List<Opciones>) event.getObject());
                break;
        }
    }

    @Override
    public void getOpciones() {
        view.loading(true);
        mainInteractor.getOpciones();
    }
}
