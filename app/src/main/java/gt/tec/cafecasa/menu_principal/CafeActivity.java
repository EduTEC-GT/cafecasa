package gt.tec.cafecasa.menu_principal;
//BEBIDAS CALIENTES//

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import gt.tec.cafecasa.R;
import gt.tec.cafecasa.Word;
import gt.tec.cafecasa.WordAdapter;

import java.util.ArrayList;
// agregamos la clase CAfeActivity en manifests
public class CafeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Creamos lista de productos en word
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word( "Q.12", "Espresso", R.drawable.espresso));
        words.add(new Word( "Normal Q.18","Cappuchino", R.drawable.cappuccino));
        words.add(new Word("Normal Q.14","Café Tradicional",  R.drawable.cafetradicional));
        words.add(new Word( "Normal Q.16","Café con Leche", R.drawable.cafeconleche));
        words.add(new Word("Normal Q.16", "Café Latté", R.drawable.latte));
        words.add(new Word( "Normal Q.18","Te Chaí (Vanilla y Especies)", R.drawable.chai));
        words.add(new Word( "Normal Q.15","Té Caliente", R.drawable.te));

        // hacemos el llamado a la actividad List para mostrar los productos
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
