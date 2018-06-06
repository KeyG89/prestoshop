package mobile.viali.prontoshop.ui.transaction;

import java.util.List;

import javax.inject.Inject;

import mobile.viali.prontoshop.core.ProntoShopApplication;
import mobile.viali.prontoshop.core.dagger.AppComponent;
import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.model.Customer;
import mobile.viali.prontoshop.model.Transaction;
import mobile.viali.prontoshop.ui.customerslist.CustomerListContract;

public class TransactionPresenter implements TransactionContract.Action, OnDatabaseOperationCompleteListener {
    private final TransactionContract.View mView;
    @Inject
    TransactionContract.Repository mRepository;
    @Inject
    CustomerListContract.Repository mCustomerRepository;

    public TransactionPresenter(TransactionContract.View mView) {
        this.mView = mView;
        ProntoShopApplication.getInstance().getAppComponent().inject(this);

    }

    @Override
    public void loadTransaction() {
        List<Transaction> transactions = mRepository.getAllTransactions();
        if (transactions != null && transactions.size() > 0) {
            mView.hideEmptyText();
            mView.showTransaction(transactions);
        } else {
            mView.showEmptyText();
        }

    }

    @Override
    public void onDeleteItemButtonClicked(Transaction transaction) {
        mView.showConfirmDeletePrompt(transaction);

    }

    @Override
    public void editTransaction(Transaction transaction) {
        mRepository.updateTransaction(transaction, this);

    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        mRepository.deleteTransaction(transaction.getId(), this);

    }

    @Override
    public Customer getCustomerById(long id) {
        return mCustomerRepository.getCustomerById(id);
    }

    @Override
    public void onDatabaseOperationFailed(String error) {
        mView.showMessage("Error: " + error);

    }

    @Override
    public void onDatabaseOperationSucceded(String message) {
        mView.showMessage(message);

    }
}
