package gt.tec.cafecasa.cafecasa.main.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gt.tec.cafecasa.cafecasa.R;
import gt.tec.cafecasa.cafecasa.entitys.Opciones;
import gt.tec.cafecasa.cafecasa.lib.base.ImageLoader;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    private List<Opciones> opciones;
    private OpcionesListener listener;
    private Context context;
    private ImageLoader imageLoader;

    public MainAdapter(List<Opciones> opciones, OpcionesListener listener, Context context, ImageLoader imageLoader) {
        this.opciones = opciones;
        this.listener = listener;
        this.context = context;
        this.imageLoader = imageLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_opciones_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Opciones opcion = opciones.get(position);
        holder.nombre.setText(opcion.getNombre());
        imageLoader.load(holder.imagen, opcion.getImagen());
        holder.onClick(opcion, listener);
    }

    public void setOpciones(List<Opciones> opciones){
        this.opciones = null;
        this.opciones = opciones;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return opciones.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imagen)
        ImageView imagen;
        @BindView(R.id.nombre)
        TextView nombre;
        @BindView(R.id.option)
        RelativeLayout option;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void onClick(final Opciones opcion, final OpcionesListener listener){
            option.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(opcion);
                }
            });
        }
    }

}
