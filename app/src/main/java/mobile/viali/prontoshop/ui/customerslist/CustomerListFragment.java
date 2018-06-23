package mobile.viali.prontoshop.ui.customerslist;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mobile.viali.prontoshop.R;
import mobile.viali.prontoshop.core.listeners.OnCustomerSelectedListener;
import mobile.viali.prontoshop.model.Customer;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerListFragment extends Fragment implements OnCustomerSelectedListener, CustomerListContract.View {

    private View mRootView;
    private Unbinder unbinder;
    private CustomerListAdapter mAdapter;
    private CustomerListContract.Action mPresenter;

    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.customer_list_recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.empty_text)
    TextView mEmptyTextView;


    public CustomerListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_customer_list, container, false);
        unbinder = ButterKnife.bind(this, mRootView);
        mPresenter = new CustomerPresenter(this);

        // Setup the Adapter
        List<Customer> tempCustomers = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mAdapter = new CustomerListAdapter(tempCustomers, getActivity(), this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);



        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.loadCustomer();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSelectCustomer(Customer customer) {

    }

    @Override
    public void onLongClickCustomer(Customer customer) {

    }

    @Override
    public void showCustomers(List<Customer> customers) {
        // update the adapter with the returned list of customers
        mAdapter.replaceData(customers);

    }

    @Override
    public void showAddCustomerForm() {

    }

    @Override
    public void showDeleteCustomerPrompt(Customer customer) {

    }

    @Override
    public void showEditCustomerForm(Customer customer) {

    }

    @Override
    public void showEmptyText() {
        mRecyclerView.setVisibility(View.GONE);
        mEmptyTextView.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideEmptyText() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mEmptyTextView.setVisibility(View.GONE);

    }

    @Override
    public void showMessage(String message) {

    }
}
