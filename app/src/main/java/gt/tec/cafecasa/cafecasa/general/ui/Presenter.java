package gt.tec.cafecasa.cafecasa.general.ui;

import gt.tec.cafecasa.cafecasa.general.Event;

public interface Presenter {
    void onCreate();
    void onDestroy();
    void getUsuario();
    void onEvent(Event event);
    void moreOnEvent(Event event);
    void totalCarrito();
}
