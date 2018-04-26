package gt.tec.cafecasa.menu_principal;
//PANINO
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import gt.tec.cafecasa.R;
import gt.tec.cafecasa.Word;
import gt.tec.cafecasa.WordAdapter;

import java.util.ArrayList;
// agregamos la clase SandwinchActivity en manifests
public class SandwichesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Creamos lista de productos en word
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Q.59","Pulled Pork", R.drawable.panido));
        words.add(new Word("Q.45","Tocino", R.drawable.panido));
        words.add(new Word("Q.69","Entraña",  R.drawable.panido));
        words.add(new Word("Q.35","Pollo", R.drawable.panido));
        words.add(new Word("Q.28","Ham & Egg",R.drawable.jamonyhuevo));
        words.add(new Word("Q.39", "Caprese", R.drawable.panido));
        words.add(new Word("Q.49","Orgánico", R.drawable.panido));
        words.add(new Word("Q.59","Vegetariano",  R.drawable.panido));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_paninos);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}