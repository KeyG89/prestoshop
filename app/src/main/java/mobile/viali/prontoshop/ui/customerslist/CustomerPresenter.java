package mobile.viali.prontoshop.ui.customerslist;

import com.squareup.otto.Bus;

import java.util.List;

import javax.inject.Inject;

import mobile.viali.prontoshop.common.ShoppingCart;
import mobile.viali.prontoshop.core.ProntoShopApplication;
import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.model.Customer;
import mobile.viali.prontoshop.ui.productList.ProductListContract;

public class CustomerPresenter implements CustomerListContract.Action, OnDatabaseOperationCompleteListener {

    private final CustomerListContract.View mView;

    @Inject
    CustomerListContract.Repository mRepository;
    @Inject
    ShoppingCart mCart;
    @Inject
    Bus mBus;


    public CustomerPresenter(CustomerListContract.View mView) {
        this.mView = mView;
        ProntoShopApplication.getInstance().getAppComponent().inject(this);
    }

    @Override
    public void loadCustomer() {
        List<Customer> availableCustomers = mRepository.getAllCustomers();
        if(availableCustomers !=null && availableCustomers.size() >0){
            mView.hideEmptyText();
            mView.showCustomers(availableCustomers);
        }else{
            mView.showEmptyText();
        }

    }

    @Override
    public Customer getCustomer(long id) {
        return mRepository.getCustomerById(id);

    }

    @Override
    public void onCustomerSelected(Customer customer) {
        mCart.setCustomer(customer);

    }

    @Override
    public void onAddCustomerButtonClicked() {
        mView.showAddCustomerForm();

    }

    @Override
    public void addCustomer(Customer customer) {
        mRepository.addCustomer(customer, this);


    }

    @Override
    public void onDeleteCustomerButtonClicked(Customer customer) {
        mView.showDeleteCustomerPrompt(customer);

    }

    @Override
    public void deleteCustomer(Customer customer) {
        mRepository.onDeleteCustomer(customer, this);

    }

    @Override
    public void onEditCustomerButtonNClicked(Customer customer) {
        mView.showEditCustomerForm(customer);

    }

    @Override
    public void updateCustomer(Customer customer) {
        mRepository.updateCustomer(customer, this);

    }

    @Override
    public void onDatabaseOperationFailed(String error) {
        mView.showMessage("Error:" + error);

    }

    @Override
    public void onDatabaseOperationSucceded(String message) {
        mView.showMessage(message);

    }
}
