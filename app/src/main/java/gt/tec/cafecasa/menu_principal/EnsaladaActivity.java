package gt.tec.cafecasa.menu_principal;
//ENSALADAS
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import gt.tec.cafecasa.R;
import gt.tec.cafecasa.Word;
import gt.tec.cafecasa.WordAdapter;

import java.util.ArrayList;
// agregamos la clase EnsaladaActivity en manifests
public class EnsaladaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Creamos lista de productos en word
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Q.65", "Popeye Salad",R.drawable.ensalada));
        words.add(new Word("Q.35", "BOK CHOY",R.drawable.ensalada));
        words.add(new Word("Q.45", "Del Mar",R.drawable.ensalada));
        words.add(new Word("Q.45", "Hongos",R.drawable.ensalada));
        words.add(new Word("Q.60", "Lomito y Arúgula",R.drawable.ensalada));
        words.add(new Word("Q.55", "Oriental Salad",R.drawable.ensalada));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
