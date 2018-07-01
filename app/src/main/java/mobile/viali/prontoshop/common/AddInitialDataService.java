package mobile.viali.prontoshop.common;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.data.SampleCustomerData;
import mobile.viali.prontoshop.data.SampleProductData;
import mobile.viali.prontoshop.model.Customer;
import mobile.viali.prontoshop.model.Product;
import mobile.viali.prontoshop.ui.customerslist.CustomerListSQLiteManager;
import mobile.viali.prontoshop.ui.productList.ProductListSqliteManager;

public class AddInitialDataService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public AddInitialDataService() {
        super("AddInitialDataService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        //Add sampple Customers to database
        List<Customer> customers = SampleCustomerData.getCustomers();
        CustomerListSQLiteManager customerListSQLiteManager = new CustomerListSQLiteManager(getApplicationContext());
        for (Customer customer : customers) {
            customerListSQLiteManager.addCustomer(customer, new OnDatabaseOperationCompleteListener() {
                @Override
                public void onDatabaseOperationFailed(String error) {
                    Log.d("Customer", "Error" + error);
                }

                @Override
                public void onDatabaseOperationSucceded(String message) {
                    Log.d("Customer", "Customer Inserted");
                }
            });
        }

        List<Product> products = SampleProductData.getSampleProducts();
        ProductListSqliteManager productListSqliteManager = new ProductListSqliteManager(getApplicationContext());
        for (Product product : products) {
            productListSqliteManager.addProduct(product, new OnDatabaseOperationCompleteListener() {
                @Override
                public void onDatabaseOperationFailed(String error) {
                    Log.d("First Run", "Error: " + error);
                }

                @Override
                public void onDatabaseOperationSucceded(String message) {
                    Log.d("First Run", "Success: " + message);
                }
            });
        }

        //Add sample categories
        List<String> categories = new ArrayList<>();
        categories.add("Electronics");
        categories.add("Computers");
        categories.add("Toys");
        categories.add("Garden");
        categories.add("Kitchen");
        categories.add("Clothing");
        categories.add("Health");

        for (String category : categories) {
            productListSqliteManager.createOrGetCategoryId(category, new OnDatabaseOperationCompleteListener() {
                @Override
                public void onDatabaseOperationFailed(String error) {

                }

                @Override
                public void onDatabaseOperationSucceded(String message) {

                }
            });
        }

        Intent restartIntent = new Intent(this, MainActivity.class);
        restartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(restartIntent);

    }
}
