package mobile.viali.prontoshop.core.dagger;

import javax.inject.Singleton;

import dagger.Component;
import mobile.viali.prontoshop.common.MainActivity;

@Singleton @Component (modules = {AppModule.class, ShoppingCartModule.class})

public interface AppComponent {
    void inject(MainActivity activity);

}
