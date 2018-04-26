package gt.tec.cafecasa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static gt.tec.cafecasa.R.layout.pedido_main;

/**
 * Created by Rudy Quiej on 22/07/2017.
 */

public class GridAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> arrayList;

    public GridAdapter(Context context, ArrayList<String> arrayList) {

        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

     @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         if (convertView == null) {
             LayoutInflater layoutinflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
             convertView = layoutinflater.inflate(R.layout.item_grid, null);
             TextView tituloTv = (TextView) convertView.findViewById(R.id.grid_item_label);
             tituloTv.setText(arrayList.get(position));
         }


         return convertView;
     }

}