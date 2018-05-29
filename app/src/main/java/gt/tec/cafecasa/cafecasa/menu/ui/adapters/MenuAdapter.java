package gt.tec.cafecasa.cafecasa.menu.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import gt.tec.cafecasa.cafecasa.R;
import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.lib.base.ImageLoader;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private List<Menu> menus;
    private ImageLoader imageLoader;
    private MenuClickListener listener;
    private DecimalFormat decimalFormat;

    public MenuAdapter(List<Menu> menus, ImageLoader imageLoader, MenuClickListener listener, DecimalFormat decimalFormat) {
        this.menus = menus;
        this.imageLoader = imageLoader;
        this.listener = listener;
        this.decimalFormat = decimalFormat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Menu menu = menus.get(position);
        holder.nombre.setText(menu.getNombre());
        holder.precio.setText(decimalFormat.format(menu.getPrecio()));
        imageLoader.load(holder.imagen, menu.getImagen());
        holder.onClick(menu, listener);
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imagen)
        CircleImageView imagen;
        @BindView(R.id.nombre)
        TextView nombre;
        @BindView(R.id.precio)
        TextView precio;
        @BindView(R.id.item)
        RelativeLayout item;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void onClick(final Menu menu, final MenuClickListener listener){
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.menuClick(menu);
                }
            });
        }
    }
}
