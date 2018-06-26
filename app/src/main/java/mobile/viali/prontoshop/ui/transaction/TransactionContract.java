package mobile.viali.prontoshop.ui.transaction;

import java.util.List;

import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.model.Customer;
import mobile.viali.prontoshop.model.LineItem;
import mobile.viali.prontoshop.model.SalesTransaction;

public interface TransactionContract {

    public interface View {
        void showTransaction(List<SalesTransaction> salesTransactions);

        void showEmptyText();

        void hideEmptyText();

        void showConfirmDeletePrompt(SalesTransaction salesTransaction);

        void showMessage(String message);


    }

    public interface Action {
        void loadTransaction();

        void onDeleteItemButtonClicked(SalesTransaction salesTransaction);

        void editTransaction(SalesTransaction salesTransaction);

        void deleteTransaction(SalesTransaction salesTransaction);

        Customer getCustomerById(long id);


    }

    public interface Repository {
        List<SalesTransaction> getAllTransactions();
        SalesTransaction getTransactionById(long id);
        void deleteTransaction(long id, OnDatabaseOperationCompleteListener listener);
        List<LineItem> getAllLineItems();
        long saveTransaction(SalesTransaction transaction, OnDatabaseOperationCompleteListener listener);
        void updateTransaction(SalesTransaction salesTransaction, OnDatabaseOperationCompleteListener listener);
    }
}
