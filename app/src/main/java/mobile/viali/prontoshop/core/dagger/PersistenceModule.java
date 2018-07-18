package mobile.viali.prontoshop.core.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobile.viali.prontoshop.ui.customerslist.CustomerListContract;
import mobile.viali.prontoshop.ui.customerslist.CustomerListInMemoryRepository;
import mobile.viali.prontoshop.ui.customerslist.CustomerListSQLiteManager;
import mobile.viali.prontoshop.ui.productList.ProductInMemoryRepository;
import mobile.viali.prontoshop.ui.productList.ProductListContract;
import mobile.viali.prontoshop.ui.productList.ProductListSqliteManager;
import mobile.viali.prontoshop.ui.transaction.TempRepository;
import mobile.viali.prontoshop.ui.transaction.TransactionContract;
import mobile.viali.prontoshop.ui.transaction.TransactionSQLiteManager;

@Module
public class PersistenceModule {

    @Provides @Singleton
    public ProductListContract.Repository providesProductRepository(Context context){
        return  new ProductListSqliteManager(context);
    }

    @Provides @Singleton
    public CustomerListContract.Repository providesCustomerRepository(Context context){
        return  new CustomerListSQLiteManager(context);
    }

    @Provides @Singleton
    public TransactionContract.Repository providesTransactionRepositoryy(Context context){
        return  new TransactionSQLiteManager(context);
    }



}
