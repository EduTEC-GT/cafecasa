package gt.tec.cafecasa.cafecasa.main.ui;

import java.util.List;

import gt.tec.cafecasa.cafecasa.entitys.Opciones;
import gt.tec.cafecasa.cafecasa.general.ui.View;

public interface MainView extends View {
    void setOpciones(List<Opciones> opciones);
}
