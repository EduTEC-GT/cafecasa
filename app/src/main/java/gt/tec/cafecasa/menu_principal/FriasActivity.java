package gt.tec.cafecasa.menu_principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import gt.tec.cafecasa.R;
import gt.tec.cafecasa.Word;
import gt.tec.cafecasa.WordAdapter;

import java.util.ArrayList;
//BEBIDAS FRIAS PARA AGREGAR A FUTURAS ACTUALIZACIONES.
public class FriasActivity extends AppCompatActivity {
    // agregamos la clase FriasActivity en manifests
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Creamos lista de productos en word
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Normal Q.22", "Te Chaí frappé", R.drawable.chilaquiles));
        words.add(new Word("Normal Q.20", "ICE Cauppuccino", R.drawable.chilaquiles));
        words.add(new Word("Normal Q.22", "White Chocolate Frost", R.drawable.chilaquiles));
        words.add(new Word("Normal Q.22", "Frapuccino", R.drawable.chilaquiles));
        words.add(new Word("Normal Q.22", "OREO Frappé", R.drawable.chilaquiles));
        words.add(new Word("Normal Q.18", "Smoothies", R.drawable.chilaquiles));
        words.add(new Word("Normal Q.18", "Sidra Italiana", R.drawable.chilaquiles));
        words.add(new Word("Normal Q.22", "Vainilla Frappé", R.drawable.chilaquiles));
        words.add(new Word("Normal Q.22", "Caramelo Frappé", R.drawable.chilaquiles));
        words.add(new Word("Normal Q.22", "Milshake", R.drawable.chilaquiles));
        words.add(new Word("Q.10", "Gaseosa", R.drawable.chilaquiles));
        words.add(new Word("Copa Q30", "Vino", R.drawable.chilaquiles));
        words.add(new Word("Gallo Q.25", "Cerveza", R.drawable.chilaquiles));
        words.add(new Word("Q.12", "Michelada Mix", R.drawable.chilaquiles));
        words.add(new Word("Q.37", "Michelada Gallo", R.drawable.chilaquiles));
        words.add(new Word("Q.40", "Michelada Montecarlo", R.drawable.chilaquiles));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
