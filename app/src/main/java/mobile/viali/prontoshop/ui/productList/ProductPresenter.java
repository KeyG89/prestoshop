package mobile.viali.prontoshop.ui.productList;

import com.squareup.otto.Bus;

import java.util.List;

import javax.inject.Inject;

import mobile.viali.prontoshop.common.ShoppingCart;
import mobile.viali.prontoshop.core.ProntoShopApplication;
import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.model.LineItem;
import mobile.viali.prontoshop.model.Product;

public class ProductPresenter implements ProductListContract.Action, OnDatabaseOperationCompleteListener {

    private final ProductListContract.View mView;

    @Inject
    ProductListContract.Repository mRepository;
    @Inject
    ShoppingCart mCart;
    @Inject
    Bus mBus;

    public ProductPresenter(ProductListContract.View mView) {
        this.mView = mView;
        ProntoShopApplication.getInstance().getAppComponent().inject(this);
    }

    @Override
    public void loadProducts() {
        List<Product> availableProducts = mRepository.getAllProducts();
        if (availableProducts != null && availableProducts.size() > 0) {
            mView.hideEmptyText();
            mView.showProducts(availableProducts);
        } else {
            mView.showEmptyText();
        }
    }

    @Override
    public void onAddProductButtonClicked() {
        mView.showAddProductsForm();

    }

    @Override
    public void onAddToCartButtonClicked(Product product) {
        // Create LineItem from the passed product
        LineItem item = new LineItem(product, 1);
        mView.addItemToCart(item);

    }

    @Override
    public Product getProduct(long id) {
        return  mRepository.getProductById(id);
    }

    @Override
    public void addProduct(Product product) {
        mRepository.addProduct(product, this);
    }

    @Override
    public void onDeleteProductButtonClicked(Product product) {
        mView.showDeleteProducPrompt(product);

    }

    @Override
    public void deleteProduct(Product product) {
        mRepository.deleteProduct(product, this);

    }

    @Override
    public void onEditProductButtonClicked(Product product) {
        mView.showEditProductForm(product);

    }

    @Override
    public void updateProduct(Product product) {
        mRepository.updateProduct(product, this);

    }

    @Override
    public void onGoogleSearchButtonClicked(Product product) {
        mView.showGoogleSearch(product);

    }

    @Override
    public void onDatabaseOperationFailed(String error) {
        mView.showMessage("Error: " + error);

    }

    @Override
    public void onDatabaseOperationSucceded(String message) {
        mView.showMessage(message);
    }
}
