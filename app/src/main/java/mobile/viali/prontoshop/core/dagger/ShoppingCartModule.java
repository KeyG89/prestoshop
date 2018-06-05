package mobile.viali.prontoshop.core.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobile.viali.prontoshop.common.ShoppingCart;

@Module
public class ShoppingCartModule {

    @Provides @Singleton
    SharedPreferences providesSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides @Singleton
    ShoppingCart providesShoppingCart(SharedPreferences preferences){
        return new ShoppingCart(preferences);
    }
}
