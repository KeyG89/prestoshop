package mobile.viali.prontoshop.core.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobile.viali.prontoshop.core.ProntoShopApplication;

@Module
public class AppModule {
    private final ProntoShopApplication app;


    public AppModule(ProntoShopApplication app) {
        this.app = app;
    }


    @Provides @Singleton
    public ProntoShopApplication profideApp(){
        return app;
    }

    @Provides @Singleton
    public Context provideContext(){
        return app;
    }

}
