package mobile.viali.prontoshop.ui.customerslist;

import java.util.List;

import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.data.SampleCustomerData;
import mobile.viali.prontoshop.model.Customer;

public class CustomerListInMemoryRepository implements CustomerListContract.Repository{

    public CustomerListInMemoryRepository() {
    }

    @Override
    public List<Customer> getAllCustomers() {
        return SampleCustomerData.getCustomers();
    }

    @Override
    public Customer getCustomerById(long id) {
        return null;
    }

    @Override
    public void onDeleteCustomer(Customer customer, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public void addCustomer(Customer customer, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public void updateCustomer(Customer cusomter, OnDatabaseOperationCompleteListener listener) {

    }
}
