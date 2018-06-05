package mobile.viali.prontoshop.core;

import android.app.Application;

import mobile.viali.prontoshop.core.dagger.AppComponent;
import mobile.viali.prontoshop.core.dagger.AppModule;
import mobile.viali.prontoshop.core.dagger.DaggerAppComponent;

public class ProntoShopApplication extends Application {

    private static AppComponent appComponent;
    private static ProntoShopApplication instance = new ProntoShopApplication();


    @Override
    public void onCreate() {
        super.onCreate();
        getAppComponent();
    }

    public void getAppComponent() {

        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
    }
}
