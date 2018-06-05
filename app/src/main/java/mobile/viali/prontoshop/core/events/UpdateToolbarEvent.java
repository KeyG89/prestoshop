package mobile.viali.prontoshop.core.events;

import java.util.List;

import mobile.viali.prontoshop.model.LineItem;

public class UpdateToolbarEvent {
    public List<LineItem> getmLineItems() {
        return mLineItems;
    }

    private final List<LineItem> mLineItems;

    public UpdateToolbarEvent(List<LineItem> mLineItems) {
        this.mLineItems = mLineItems;
    }
}
