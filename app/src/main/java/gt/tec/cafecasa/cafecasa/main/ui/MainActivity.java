package gt.tec.cafecasa.cafecasa.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import gt.tec.cafecasa.cafecasa.App;
import gt.tec.cafecasa.cafecasa.R;
import gt.tec.cafecasa.cafecasa.entitys.Opciones;
import gt.tec.cafecasa.cafecasa.general.DrawableActivity;
import gt.tec.cafecasa.cafecasa.lib.base.ImageLoader;
import gt.tec.cafecasa.cafecasa.main.ui.adapters.MainAdapter;
import gt.tec.cafecasa.cafecasa.main.ui.adapters.OpcionesListener;
import gt.tec.cafecasa.cafecasa.menu.ui.MenuActivity;
import gt.tec.cafecasa.cafecasa.util.ObjectSerializer;

public class MainActivity extends DrawableActivity implements MainView, OpcionesListener {

    @BindView(R.id.opciones_recycler)
    RecyclerView recycler;
    @BindView(R.id.content_main)
    RelativeLayout content;
    @Inject
    MainAdapter adapter;
    @Inject
    MainPresenter presenter;
    @Inject
    ImageLoader imageLoader;

    private App app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        inject();
        content.setVisibility(View.VISIBLE);
        presenter.onCreate();
        setMenu(imageLoader, presenter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
        presenter.getOpciones();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    private void inject() {
        app = (App) getApplication();
        app.main(this, this).inject(this);
    }

    @Override
    public void setOpciones(List<Opciones> opciones) {
        adapter.setOpciones(opciones);
    }

    @Override
    public void onClick(Opciones opcion) {
        try {
            startActivity(new Intent(this, MenuActivity.class)
            .putExtra(MenuActivity.opcion, ObjectSerializer.serialize(opcion)));
        } catch (Exception e) {
            Log.e("opt-click", e.getLocalizedMessage());
        }
    }
}
