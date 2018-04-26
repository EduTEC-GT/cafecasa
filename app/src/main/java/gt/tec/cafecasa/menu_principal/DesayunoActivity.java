package gt.tec.cafecasa.menu_principal;
//DESAYUNOS
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import gt.tec.cafecasa.R;
import gt.tec.cafecasa.Word;
import gt.tec.cafecasa.WordAdapter;

import java.util.ArrayList;
// agregamos la clase DesayunoActivity en manifests
public class DesayunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Creamos lista de productos en word
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Q.39", "Sandwinch de jamón, huevo y queso", R.drawable.desayuno));
        words.add(new Word("Q.42", "Benedictinos", R.drawable.benedictinos));
        words.add(new Word("Q.59", "Rancheros", R.drawable.desayuno));
        words.add(new Word("Q.59", "Omellete", R.drawable.omelette));
        words.add(new Word("Q.49", "Tradicional", R.drawable.desayuno));
        words.add(new Word("Q.42", "Wafles", R.drawable.waffles));
        words.add(new Word("Q.39", "Yogurt", R.drawable.desayuno));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
