package gt.tec.cafecasa.cafecasa.firebase.DI;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gt.tec.cafecasa.cafecasa.firebase.FirebaseHelper;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;

/**
 * Created by javie on 11/12/2017.
 */
@Module
public class FirebaseModule {

    @Singleton
    @Provides
    FirebaseHelper providesFireBaseHelper(Context context, EventBus bus){
        return new FirebaseHelper(context, bus);
    }

}
