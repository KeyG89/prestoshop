package mobile.viali.prontoshop.ui.checkout;

import java.util.List;

import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.model.LineItem;
import mobile.viali.prontoshop.model.SalesTransaction;

public interface CheckoutContract {

    public interface View {

        void showLineItem(List<LineItem> items);

        void showEmptyText();

        void showCartTotals(double tax, double subTotal, double total);

        void showConfirmCheckout();

        void showConfirmClearChart();

        void hideText();

        void showMessage(String message);


    }

    public interface Action {
        void loadLineItems();

        void onCheckoutButtonClicked();

        void onDeleteItemButtonClicked(LineItem item);

        void checkout();

        void onClearButtonClicked();

        void clearShoppingCart();

        void setPaymentType(String paymentType);

        void markAsPaid(boolean paid);

        void onItemQuantityChanged(LineItem item, int qty);

    }

    public interface Repository {

        List<LineItem> getAllLineItems();

        void saveTransaction(SalesTransaction salesTransaction, OnDatabaseOperationCompleteListener listener);

        void updateTransaction(SalesTransaction salesTransaction, OnDatabaseOperationCompleteListener listener);


    }
}
