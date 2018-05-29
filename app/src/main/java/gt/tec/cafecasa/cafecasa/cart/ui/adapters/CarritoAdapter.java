package gt.tec.cafecasa.cafecasa.cart.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import gt.tec.cafecasa.cafecasa.R;
import gt.tec.cafecasa.cafecasa.entitys.Carrito;
import gt.tec.cafecasa.cafecasa.lib.base.ImageLoader;
import gt.tec.cafecasa.cafecasa.main.ui.adapters.MainAdapter;

public class CarritoAdapter extends RecyclerView.Adapter<CarritoAdapter.ViewHolder>{

    private ImageLoader imageLoader;
    private ArrayList<Carrito> carritos;
    private DecimalFormat decimalFormat;
    private CartClickListener listener;

    public CarritoAdapter(ImageLoader imageLoader, ArrayList<Carrito> carritos, DecimalFormat decimalFormat, CartClickListener listener) {
        this.imageLoader = imageLoader;
        this.carritos = carritos;
        this.decimalFormat = decimalFormat;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Carrito carrito = carritos.get(position);
        holder.nombre.setText(carrito.getMenu().getNombre());
        imageLoader.load(holder.imagen, carrito.getMenu().getImagen());
        holder.precioCantidad.setText(String.valueOf(carrito.getCantidad()) + " X " + decimalFormat.format(carrito.getMenu().getPrecio()));
        holder.total.setText(decimalFormat.format(carrito.getCantidad()*carrito.getMenu().getPrecio()));
        holder.onClick(listener, carrito);
    }

    public void setCarritos(ArrayList<Carrito> carritos) {
        this.carritos = carritos;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return carritos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imagen_cart)
        CircleImageView imagen;
        @BindView(R.id.nombre_cart)
        TextView nombre;
        @BindView(R.id.precio_cantidad)
        TextView precioCantidad;
        @BindView(R.id.precio_cart)
        TextView total;
        @BindView(R.id.item_cart)
        RelativeLayout item;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void onClick(final CartClickListener listener, final Carrito carrito){
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.cartClick(carrito);
                }
            });
        }
    }
}
