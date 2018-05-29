package gt.tec.cafecasa.cafecasa.cart.ui;

import android.app.AlertDialog;
import android.content.Intent;
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

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import gt.tec.cafecasa.cafecasa.App;
import gt.tec.cafecasa.cafecasa.R;
import gt.tec.cafecasa.cafecasa.cart.ui.adapters.CarritoAdapter;
import gt.tec.cafecasa.cafecasa.cart.ui.adapters.CartClickListener;
import gt.tec.cafecasa.cafecasa.entitys.Carrito;
import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.entitys.Opciones;
import gt.tec.cafecasa.cafecasa.general.DrawableActivity;
import gt.tec.cafecasa.cafecasa.lib.base.ImageLoader;
import gt.tec.cafecasa.cafecasa.main.ui.MainActivity;
import gt.tec.cafecasa.cafecasa.menu.ui.MenuPresenter;
import gt.tec.cafecasa.cafecasa.menu.ui.adapters.MenuAdapter;
import gt.tec.cafecasa.cafecasa.util.ObjectSerializer;

public class CartActivity extends DrawableActivity implements CartView, CartClickListener {

    @BindView(R.id.content_cart)
    RelativeLayout content;
    @BindView(R.id.recycler_cart)
    RecyclerView recycler;
    @BindView(R.id.total_mount)
    TextView total;

    @BindString(R.string.cantidad_invalida)
    String cantidadInvalida;

    @Inject
    CartPresenter presenter;
    @Inject
    ImageLoader imageLoader;
    @Inject
    DecimalFormat decimalFormat;
    @Inject
    CarritoAdapter adapter;

    private App app;
    private Opciones opt;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        inject();
        presenter.onCreate();
        setMenu(imageLoader, presenter);
        content.setVisibility(View.VISIBLE);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
        presenter.getCarrito();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    private void inject() {
        app = (App) getApplication();
        app.cart(this, this).inject(this);
    }

    @Override
    public void totalCarrito(double total) {
        if (total == 0){
            startActivity(new Intent(this, MainActivity.class).addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP
                    |Intent.FLAG_ACTIVITY_CLEAR_TASK
            ));
        }
        this.total.setText(decimalFormat.format(total));
    }

    @Override
    public void getCarrito(ArrayList<Carrito> carritos) {
        adapter.setCarritos(carritos);
    }

    @OnClick(R.id.paybtn)
    public void pay(){

    }

    @Override
    public void cartClick(Carrito carrito) {
        final Menu menu = carrito.getMenu();
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
        monto.setText(carrito.getCantidad());
        monto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (monto.getText().toString() != null && !monto.getText().toString().isEmpty()){
                    int cantidad = Integer.parseInt(monto.getText().toString());
                    if (cantidad < 1){
                        showError(cantidadInvalida);
                        monto.setText("1");
                    }
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
                if (monto.getText().toString() != null && !monto.getText().toString().isEmpty()) {
                    presenter.updateCart(menu, Integer.parseInt(monto.getText().toString()));
                }
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
