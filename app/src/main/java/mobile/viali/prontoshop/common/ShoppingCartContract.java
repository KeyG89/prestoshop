package mobile.viali.prontoshop.common;

import java.util.List;

import mobile.viali.prontoshop.model.Customer;
import mobile.viali.prontoshop.model.LineItem;

public interface ShoppingCartContract {

    void addItemToCart(LineItem item);

    void removeItemFromCart(LineItem item);

    void clearAllItemsFromCart();

    List<LineItem> getShoppingCart();

    void setCustomer(Customer customer);

    void updateItemQty(LineItem item, int qty);

    Customer getSelectedCustomer();

    void completeCheckout();

}
