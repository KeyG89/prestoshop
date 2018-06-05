package mobile.viali.prontoshop.core.events;

import mobile.viali.prontoshop.model.Customer;

public class CustomerSelectedEvent {

    private final boolean clearCustomer;
    private final Customer selectedCustomer;

    public CustomerSelectedEvent(Customer selectedCustomer, boolean clearCustomer) {
        this.selectedCustomer = selectedCustomer;
        this.clearCustomer = clearCustomer;
    }

    public boolean isClearCustomer() {
        return clearCustomer;
    }


    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }


}
