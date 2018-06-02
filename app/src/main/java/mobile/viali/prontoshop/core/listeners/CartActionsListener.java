package mobile.viali.prontoshop.core.listeners;

import mobile.viali.prontoshop.model.LineItem;

public interface CartActionsListener {
    void onItemDeleted(LineItem item);
    void onItemQtyChange(LineItem item, int qty);
}
