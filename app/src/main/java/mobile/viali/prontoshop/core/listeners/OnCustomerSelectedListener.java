package mobile.viali.prontoshop.core.listeners;

import mobile.viali.prontoshop.model.Customer;

public interface OnCustomerSelectedListener {
    void onSelectCustomer(Customer customer);
    void onLongClickCustomer(Customer customer);
}
