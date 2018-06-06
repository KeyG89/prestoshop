package mobile.viali.prontoshop.core.listeners;

public interface OnDatabaseOperationCompleteListener {

    void onDatabaseOperationFailed(String error);
    void onDatabaseOperationSucceded(String message);

}
