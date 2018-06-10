package mobile.viali.prontoshop.core.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobile.viali.prontoshop.ui.customerslist.CustomerListContract;
import mobile.viali.prontoshop.ui.customerslist.CustomerListInMemoryRepository;
import mobile.viali.prontoshop.ui.productList.ProductInMemoryRepository;
import mobile.viali.prontoshop.ui.productList.ProductListContract;

@Module
public class PersistenceModule {

    @Provides @Singleton
    public ProductListContract.Repository providesProductRepository(Context context){
        return  new ProductInMemoryRepository();
    }

    @Provides @Singleton
    public CustomerListContract.Repository providesCustomerRepository(Context context){
        return  new CustomerListInMemoryRepository();
    }


}