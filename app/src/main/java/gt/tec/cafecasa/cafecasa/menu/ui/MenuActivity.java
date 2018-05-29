package gt.tec.cafecasa.cafecasa.menu.ui;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import gt.tec.cafecasa.cafecasa.App;
import gt.tec.cafecasa.cafecasa.R;
import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.entitys.Opciones;
import gt.tec.cafecasa.cafecasa.general.DrawableActivity;
import gt.tec.cafecasa.cafecasa.lib.base.ImageLoader;
import gt.tec.cafecasa.cafecasa.main.ui.MainPresenter;
import gt.tec.cafecasa.cafecasa.menu.ui.adapters.MenuAdapter;
import gt.tec.cafecasa.cafecasa.menu.ui.adapters.MenuClickListener;
import gt.tec.cafecasa.cafecasa.util.ObjectSerializer;

public class MenuActivity extends DrawableActivity implements MenuView, MenuClickListener {

    @BindView(R.id.menu_recycler)
    RecyclerView recycler;
    @BindView(R.id.menu_header_img)
    ImageView header;
    @BindView(R.id.menu_opt_nombre)
    TextView nombre;
    @BindView(R.id.content_menu)
    RelativeLayout content;

    @BindString(R.string.cantidad_invalida)
    String cantidadInvalida;

    @Inject
    MenuPresenter presenter;
    @Inject
    ImageLoader imageLoader;
    @Inject
    MenuAdapter adapter;
    @Inject
    DecimalFormat decimalFormat;

    private App app;
    private Opciones opt;
    private AlertDialog dialog;
    public static final String opcion = "OPCION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        inject();
        presenter.onCreate();
        setMenu(imageLoader, presenter);
        content.setVisibility(View.VISIBLE);
        try {
            opt = (Opciones) ObjectSerializer.deserialize(getIntent().getStringExtra(opcion));
            imageLoader.load(header, opt.getImagen());
            nombre.setText(opt.getNombre());
            presenter.getMenu(opt.getKey());
        } catch (Exception e) {
            Log.e("Menu", e.getLocalizedMessage());
        }
        recycler.setLayoutManager(new GridLayoutManager(this, 2));
        recycler.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    private void inject() {
        app = (App) getApplication();
        app.menu(this, this).inject(this);
    }

    @Override
    public void getMenu(List<Menu> menu) {
        adapter.setMenus(menu);
    }

    @Override
    public void menuClick(final Menu menu) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View view = LayoutInflater.from(this).inflate(R.layout.add_cart_dialog, null);
        CircleImageView image = view.findViewById(R.id.imagen_dialog);
        TextView nombre = view.findViewById(R.id.nombre_dialog);
        TextView precio = view.findViewById(R.id.precio_dialog);
        ImageView add = view.findViewById(R.id.add_dialog);
        ImageView remove = view.findViewById(R.id.remove_dialog);
        final EditText monto = view.findViewById(R.id.monto_dialog);
        Button cancel = view.findViewById(R.id.cancel_dialog);
        Button ok = view.findViewById(R.id.ok_dialog);
        imageLoader.load(image, menu.getImagen());
        nombre.setText(menu.getNombre());
        precio.setText(decimalFormat.format(menu.getPrecio()));
        monto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int cantidad = Integer.parseInt(monto.getText().toString());
                if (cantidad < 1){
                    showError(cantidadInvalida);
                    monto.setText("1");
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidad = Integer.parseInt(monto.getText().toString());
                cantidad = cantidad + 1;
                monto.setText(String.valueOf(cantidad));
            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidad = Integer.parseInt(monto.getText().toString());
                if (cantidad > 1){
                    cantidad = cantidad - 1;
                }
                monto.setText(String.valueOf(cantidad));
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.agregarCart(menu, Integer.parseInt(monto.getText().toString()));
                dialog.cancel();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        builder.setView(view);
        this.dialog = builder.show();
    }
}
