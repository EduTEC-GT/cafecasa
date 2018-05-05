package gt.tec.cafecasa.cafecasa.lib.DI;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gt.tec.cafecasa.cafecasa.lib.GlideImageLoader;
import gt.tec.cafecasa.cafecasa.lib.GreenRobotEventBus;
import gt.tec.cafecasa.cafecasa.lib.base.EventBus;
import gt.tec.cafecasa.cafecasa.lib.base.ImageLoader;

/**
 * Created by javie on 11/12/2017.
 */
@Module
public class LibsModule {
    public LibsModule() {
    }

    @Singleton
    @Provides
    EventBus providesEventBus(org.greenrobot.eventbus.EventBus bus){
        return new GreenRobotEventBus(bus);
    }

    @Singleton
    @Provides
    org.greenrobot.eventbus.EventBus providesGreenRobot(){
        return org.greenrobot.eventbus.EventBus.getDefault();
    }

    @Singleton
    @Provides
    ImageLoader providesImageLoader(RequestManager manager){
        return new GlideImageLoader(manager);
    }

    @Singleton
    @Provides
    RequestManager providesRequestManager(Context context){
        return Glide.with(context);
    }
}
