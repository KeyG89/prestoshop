package mobile.viali.prontoshop.core.dagger;

import javax.inject.Singleton;

import dagger.Component;
import mobile.viali.prontoshop.common.MainActivity;
import mobile.viali.prontoshop.common.ShoppingCart;
import mobile.viali.prontoshop.ui.productList.ProductPresenter;

@Singleton
@Component(
        modules = {
                AppModule.class,
                ShoppingCartModule.class,
                BusModule.class
        }
)

public interface AppComponent {
    void inject(MainActivity activity);
    void inject(ShoppingCart cart);
    void inject(ProductPresenter productPresenter);

}
