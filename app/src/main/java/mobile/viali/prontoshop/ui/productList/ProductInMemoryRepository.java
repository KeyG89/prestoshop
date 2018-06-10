package mobile.viali.prontoshop.ui.productList;

import java.util.List;

import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.data.SampleProductData;
import mobile.viali.prontoshop.model.Category;
import mobile.viali.prontoshop.model.Product;

public class ProductInMemoryRepository implements ProductListContract.Repository {

    public ProductInMemoryRepository(){

    }

    @Override
    public List<Product> getAllProducts() {
        return SampleProductData.getSampleProducts();
    }

    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public void deleteProduct(Product product, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public void addProduct(Product product, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public void updateProduct(Product product, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }
}
