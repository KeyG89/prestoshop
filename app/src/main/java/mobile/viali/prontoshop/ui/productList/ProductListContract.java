package mobile.viali.prontoshop.ui.productList;

import java.util.List;

import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.model.Category;
import mobile.viali.prontoshop.model.LineItem;
import mobile.viali.prontoshop.model.Product;

public interface ProductListContract {

    public interface View {

        void showProducts(List<Product> products);

        void showAddProductsForm();

        void showEditProductForm(Product product);

        void showDeleteProducPrompt(Product product);

        void showGoogleSearch(Product product);

        void showEmptyText();

        void hideEmptyText();

        void showMessage(String message);

        void addItemToCart(LineItem item);

    }

    public interface Action {

        void loadProducts();

        void onAddProductButtonClicked();

        void onAddToCartButtonClicked(Product product);

        Product getProduct(long id);

        void addProduct(Product product);

        void onDeleteProductButtonClicked(Product product);

        void deleteProduct(Product product);

        void onEditProductButtonClicked(Product product);

        void updateProduct(Product product);

        void onGoogleSearchButtonClicked(Product product);


    }

    public interface Repository {

        List<Product> getAllProducts();

        Product getProductById(long id);

        void deleteProduct(Product product, OnDatabaseOperationCompleteListener listener);

        void addProduct(Product product, OnDatabaseOperationCompleteListener listener);

        void updateProduct(Product product, OnDatabaseOperationCompleteListener listener);

        List<Category> getAllCategories();

    }

}
