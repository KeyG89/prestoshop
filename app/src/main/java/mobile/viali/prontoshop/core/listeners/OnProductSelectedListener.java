package mobile.viali.prontoshop.core.listeners;

import mobile.viali.prontoshop.model.Product;

public interface OnProductSelectedListener {
    void onSelectedProduct(Product selectedProduct);
    void onLongClickProduct(Product clickedProduct);
}
