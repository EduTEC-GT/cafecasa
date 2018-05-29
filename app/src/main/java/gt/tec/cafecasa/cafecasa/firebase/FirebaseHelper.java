package gt.tec.cafecasa.cafecasa.firebase;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import gt.tec.cafecasa.cafecasa.entitys.Menu;
import gt.tec.cafecasa.cafecasa.entitys.Opciones;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;

public class FirebaseHelper {

    private Context context;
    private DatabaseReference reference;
    private FirebaseAuth mAuth;
    private EventBus bus;

    public FirebaseHelper(Context context, EventBus bus) {
        this.context = context;
        this.mAuth = FirebaseAuth.getInstance();
        this.reference = FirebaseDatabase.getInstance().getReference();
    }

    public void getOpciones(final FirebaseResut resut){
        reference.child("opciones").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Opciones> opciones = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Opciones opcion = snapshot.getValue(Opciones.class);
                    opcion.setKey(snapshot.getKey());
                    opciones.add(opcion);
                }
                resut.found(opciones);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                resut.error(databaseError.toException().getLocalizedMessage());
            }
        });
    }

    public void getUsuario(final FirebaseResut result){
        if (mAuth.getCurrentUser() != null){
            result.found(mAuth.getCurrentUser());
        }else{
            result.error("");
        }
    }

    public void getMenu(String key, final FirebaseResut result) {
        reference.child("menu").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Menu> menus = new ArrayList<Menu>();
                for (DataSnapshot data : dataSnapshot.getChildren()){
                    Menu menu = data.getValue(Menu.class);
                    menu.setKey(data.getKey());
                    menus.add(menu);
                }
                result.found(menus);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                result.error(databaseError.toException().getLocalizedMessage());
            }
        });
    }
}
