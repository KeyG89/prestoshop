package mobile.viali.prontoshop.ui.transaction;

import java.util.List;

import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.model.LineItem;
import mobile.viali.prontoshop.model.SalesTransaction;

public class TempRepository implements TransactionContract.Repository {
    @Override
    public List<SalesTransaction> getAllTransactions() {
        return null;
    }

    @Override
    public void updateTransaction(SalesTransaction salesTransaction, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public SalesTransaction getTransactionById(long id) {
        return null;
    }

    @Override
    public void deleteTransaction(long id, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public List<LineItem> getAllLineItems() {
        return null;
    }

    @Override
    public void saveTransaction(SalesTransaction transaction, OnDatabaseOperationCompleteListener listener) {

    }
}
