package mobile.viali.prontoshop.core;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.squareup.otto.Bus;

import mobile.viali.prontoshop.core.dagger.AppComponent;
import mobile.viali.prontoshop.core.dagger.AppModule;
import mobile.viali.prontoshop.core.dagger.DaggerAppComponent;
import mobile.viali.prontoshop.util.Constants;

public class ProntoShopApplication extends Application {

    private static AppComponent appComponent;
    private Bus bus;

    public Bus getBus() {
        return bus;
    }

    private static ProntoShopApplication instance = new ProntoShopApplication();


    @Override
    public void onCreate() {
        super.onCreate();
        instance.bus = new Bus();
        initDefaultProducts();
        getAppComponent();
    }

    public AppComponent getAppComponent() {

        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }

    public static ProntoShopApplication getInstance() {
        return instance;
    }

    private void initDefaultProducts() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean(Constants.FIRST_RUN, true)) {
            startService(new Intent(this, AddInitialDataService.class));
            Log.d("INIT", "INIT DEFAULT PRODUCTS");
            editor.putBoolean(Constants.FIRST_RUN, false).commit();
        }
    }

}
