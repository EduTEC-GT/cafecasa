package gt.tec.cafecasa.menu_principal;
// POSTRES
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import gt.tec.cafecasa.R;
import gt.tec.cafecasa.Word;
import gt.tec.cafecasa.WordAdapter;

import java.util.ArrayList;
// agregamos la clase PostreActivity en manifests
public class PostreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Creamos lista de productos en word
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Q.20","Cheesecake(Fresa y Tropical)", R.drawable.postre));
        words.add(new Word("Q.18","Pie de queso", R.drawable.postre));
        words.add(new Word("Q.20","Pie de higo",  R.drawable.postre));
        words.add(new Word("Q.20","Pie de melocotón", R.drawable.postre));
        words.add(new Word("Q.20","Tres leches", R.drawable.postre));
        words.add(new Word("Q.20", "tiramisú", R.drawable.triamisu));
        words.add(new Word("Q.18","Trufa de chocolate", R.drawable.postre));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_postres);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}