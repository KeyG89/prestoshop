package mobile.viali.prontoshop.ui.customerslist;

import java.util.List;

import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.model.Customer;

public interface CustomerListContract {

    public interface View {

        void showCustomers(List<Customer> customers);

        void showAddCustomerForm();

        void showDeleteCustomerPrompt(Customer customer);

        void showEditCustomerForm(Customer customer);

        void showEmptyText();

        void hideEmptyText();

        void showMessage(String message);

    }

    public interface Action {

        void loadCustomer();

        Customer getCustomer(long id);

        void onCustomerSelected(Customer customer);

        void onAddCustomerButtonClicked();

        void addCustomer(Customer customer);

        void onDeleteCustomerButtonClicked(Customer customer);

        void deleteCustomer(Customer customer);

        void onEditCustomerButtonNClicked(Customer customer);

        void updateCustomer(Customer customer);

    }

    public interface Repository {

        List<Customer> getAllCustomers();

        Customer getCustomerById(long id);

        void onDeleteCustomer(Customer customer, OnDatabaseOperationCompleteListener listener);

        void addCustomer(Customer customer, OnDatabaseOperationCompleteListener listener);

        void updateCustomer(Customer cusomter, OnDatabaseOperationCompleteListener listener);


    }
}
