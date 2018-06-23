package mobile.viali.prontoshop.ui.transaction;

import java.util.List;

import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.model.Transaction;

public class TempRepository implements TransactionContract.Repository {
    @Override
    public List<Transaction> getAllTransactions() {
        return null;
    }

    @Override
    public void updateTransaction(Transaction transaction, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public Transaction getTransactionById(long id) {
        return null;
    }

    @Override
    public void deleteTransaction(long id, OnDatabaseOperationCompleteListener listener) {

    }
}
