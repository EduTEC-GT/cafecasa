package gt.tec.cafecasa.cafecasa.general.ui;

import com.google.firebase.auth.FirebaseUser;

public interface View {
    void loading(boolean load);
    void showError(String error);
    void showMessage(String message);
    void loadUser(FirebaseUser user);
    void forcedLogout();
}
