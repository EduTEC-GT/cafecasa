package gt.tec.cafecasa;
// se realiza el Switch con los diferentes Activity
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import gt.tec.cafecasa.menu_principal.CafeActivity;
import gt.tec.cafecasa.menu_principal.DesayunoActivity;
import gt.tec.cafecasa.menu_principal.EnsaladaActivity;
import gt.tec.cafecasa.menu_principal.SandwichesActivity;
import gt.tec.cafecasa.menu_principal.PastaActivity;
import gt.tec.cafecasa.menu_principal.PostreActivity;

public class switchActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        GridView gridView = (GridView) findViewById(R.id.am_gv_gridv);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                switch (position) {
                    case 0: // CAFE
                        startActivity(new Intent(switchActivity.this, CafeActivity.class));
                        Toast.makeText(getApplicationContext(), "El mejor cafe", Toast.LENGTH_LONG).show();
                        break;
                    case 1: // DESAYUNOS
                        startActivity(new Intent(switchActivity.this, DesayunoActivity.class));
                        Toast.makeText(getApplicationContext(), "Los mejores Desayunos", Toast.LENGTH_LONG).show();
                        break;
                    case 2: //SANDWICHES
                        startActivity(new Intent(switchActivity.this, SandwichesActivity.class));
                        break;
                    case 3: //PASTAS
                        startActivity(new Intent(switchActivity.this, PastaActivity.class));
                        break;
                    case 4://ENSALADAS
                        startActivity(new Intent(switchActivity.this, EnsaladaActivity.class));
                        break;
                    case 5://POSTRES
                        startActivity(new Intent(switchActivity.this, PostreActivity.class));
                        break;
                }
            }
        });
    }
    //llamado de PedidoActiviy mediando ImagenView en @id.logocafe
    public void comprar(View view) {
        Intent PedidoActivity = new Intent(switchActivity.this, PedidoActivity.class);
        startActivity(PedidoActivity);
    }
}