package mobile.viali.prontoshop.ui.checkout;

import java.util.List;

import javax.inject.Inject;

import mobile.viali.prontoshop.common.ShoppingCart;
import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.model.LineItem;
import mobile.viali.prontoshop.model.SalesTransaction;

public class CheckoutPresenter implements CheckoutContract.Action, OnDatabaseOperationCompleteListener {

    private final CheckoutContract.View mView;

    @Inject
    CheckoutContract.Repository mRepository;
    @Inject
    ShoppingCart mCart;
/*    @Inject
    Bus mBus;*/

    private double subTotal = 0.0;
    private double total;
    private double tax;
    private double taxRate = 0.08;
    private String selectedPaymentType = "";
    private boolean paid = false;

    public CheckoutPresenter(CheckoutContract.View mView) {
        this.mView = mView;
    }


    @Override
    public void loadLineItems() {
        List<LineItem> availableLineItems = mCart.getShoppingCart();
        calculateTotals(availableLineItems);
        if(availableLineItems !=null && availableLineItems.size() >0){
            mView.hideText();
            mView.showLineItem(availableLineItems);
        }else {
            mView.showEmptyText();
        }

    }

    private void calculateTotals(List<LineItem> availableLineItems) {
        subTotal = 0.0;
        total = 0.0;
        tax = 0.0;

        for (LineItem item: availableLineItems){
            subTotal += item.getSumPrice();
        }

        tax = subTotal*taxRate;
        total = tax + subTotal;
        mView.showCartTotals(tax, subTotal, total);
    }

    @Override
    public void onCheckoutButtonClicked() {
        mView.showConfirmCheckout();

    }

    @Override
    public void onDeleteItemButtonClicked(LineItem item) {
        mCart.removeItemFromCart(item);
        loadLineItems();
    }

    @Override
    public void checkout() {
        // Ensure a customer is selected
        if(mCart.getShoppingCart() != null || mCart.getShoppingCart().size() ==0){
            mView.showMessage("Cart is empty");
            return;
        }

        if(mCart.getSelectedCustomer() == null || mCart.getSelectedCustomer().getId() ==0){
            mView.showMessage("No Customer is selected");
        }

        SalesTransaction salesTransaction = new SalesTransaction();
        salesTransaction.setCustomerId(mCart.getSelectedCustomer().getId());
        salesTransaction.setLineItems(mCart.getShoppingCart());
        salesTransaction.setTaxAmount(tax);
        salesTransaction.setSubTotalAmount(subTotal);
        salesTransaction.setTotalAmount(total);
        salesTransaction.setPaymentType(selectedPaymentType);
        salesTransaction.setPaid(paid);
        mRepository.saveTransaction(salesTransaction, this);

    }

    @Override
    public void onClearButtonClicked() {
        mView.showConfirmClearChart();

    }

    @Override
    public void clearShoppingCart() {
        mCart.clearAllItemsFromCart();
        loadLineItems();

    }

    @Override
    public void setPaymentType(String paymentType) {
        selectedPaymentType = paymentType;

    }

    @Override
    public void markAsPaid(boolean paid) {
        this.paid = paid;

    }

    @Override
    public void onItemQuantityChanged(LineItem item, int qty) {
        mCart.updateItemQty(item, qty);

    }


    @Override
    public void onDatabaseOperationFailed(String error) {
        mView.showMessage("Error Message: " + error);
    }

    @Override
    public void onDatabaseOperationSucceded(String message) {
        mView.showMessage(message);

    }
}
