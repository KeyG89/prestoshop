package mobile.viali.prontoshop.ui.transaction;

import java.util.List;

import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.model.Customer;
import mobile.viali.prontoshop.model.Transaction;

public interface TransactionContract {

    public interface View {
        void showTransaction(List<Transaction> transactions);

        void showEmptyText();

        void hideEmptyText();

        void showConfirmDeletePrompt(Transaction transaction);

        void showMessage(String message);


    }

    public interface Action {
        void loadTransaction();

        void onDeleteItemButtonClicked(Transaction transaction);

        void editTransaction(Transaction transaction);

        void deleteTransaction(Transaction delete);

        Customer getCustomerById(long id);


    }

    public interface Repository {
        List<Transaction> getAllTransactions();

        void updateTransaction(Transaction transaction, OnDatabaseOperationCompleteListener listener);

        Transaction getTransactionById(long id);

        void deleteTransaction(long id, OnDatabaseOperationCompleteListener listener);
    }
}
