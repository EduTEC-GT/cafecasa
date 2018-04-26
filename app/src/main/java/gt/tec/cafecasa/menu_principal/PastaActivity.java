package gt.tec.cafecasa.menu_principal;
// MENU PASTAS
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import gt.tec.cafecasa.R;
import gt.tec.cafecasa.Word;
import gt.tec.cafecasa.WordAdapter;

import java.util.ArrayList;
// agregamos la clase PastaActivity en manifests
public class PastaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Creamos lista de productos en word
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Q.59","Alfredo", R.drawable.pasta));
        words.add(new Word("Q.59","Bolognesa", R.drawable.pasta));
        words.add(new Word("Q.59","Pollo y Brócoli",  R.drawable.pasta));
        words.add(new Word("Q.59","Fresca", R.drawable.pasta));
        words.add(new Word("Q.59","Vegetariana", R.drawable.pasta));
        words.add(new Word("Q.65", "Salmón", R.drawable.pasta));
        words.add(new Word("Q.59","Carbonara", R.drawable.pasta));
        words.add(new Word("Q.59","Espinaca y Ricotta",  R.drawable.pasta));
        words.add(new Word("Q.59","Chorizo",  R.drawable.pasta));
        words.add(new Word("Q.50","Lasaña Hongos",  R.drawable.pasta));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_pastas);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}