package gt.tec.cafecasa.cafecasa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 100;
    private FirebaseAuth mauth;

    @BindView(R.id.loader)
    ProgressBar loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mauth = FirebaseAuth.getInstance();
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mauth.getCurrentUser() != null){

        }else{
            login();
        }
    }

    private void login() {
        AuthUI.SignInIntentBuilder intentBuilder = AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(getProviders())
                .setLogo(R.mipmap.ic_launcher)
                .setIsSmartLockEnabled(false);
        Intent intent = intentBuilder.build();
        startActivityForResult(intent, RC_SIGN_IN);
    }

    private List<AuthUI.IdpConfig> getProviders() {
        List<AuthUI.IdpConfig> providers = new ArrayList<AuthUI.IdpConfig>();
        providers.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        return providers;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Log.e("SIGN_IN_OK", String.valueOf(mauth.getCurrentUser().getUid()));
            }else{
                Log.e("SIGN_IN_FAIL", String.valueOf(data.getDataString()));
            }
        }
    }
}
