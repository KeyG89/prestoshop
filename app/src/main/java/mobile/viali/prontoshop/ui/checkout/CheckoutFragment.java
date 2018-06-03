package mobile.viali.prontoshop.ui.checkout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mobile.viali.prontoshop.R;
import mobile.viali.prontoshop.core.listeners.CartActionsListener;
import mobile.viali.prontoshop.model.Customer;
import mobile.viali.prontoshop.model.LineItem;
import mobile.viali.prontoshop.ui.customerslist.CustomerListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckoutFragment extends Fragment implements CartActionsListener {
    private  CheckoutAdapter mAdapter;
    private Unbinder unbinder;
    private View mRootView;


    @BindView(R.id.checkout_list_recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.empty_text)
    TextView mEmptyTextView;
    @BindView(R.id.text_view_sub_total)
    TextView mTextViewSubTotal;
    @BindView(R.id.text_view_tax)
    TextView mTextViewTax;
    @BindView(R.id.text_view_total)
    TextView mTextViewTotal;
    @BindView(R.id.button_cash)
    RadioButton mButtonCash;
    @BindView(R.id.button_card)
    RadioButton mButtonCard;
    @BindView(R.id.button_paypal)
    RadioButton mButtonPaypal;
    @BindView(R.id.radio_group_payment_type)
    RadioGroup mRadioGroupPaymentType;
    @BindView(R.id.clear_cart_button)
    Button mClearCartButton;
    @BindView(R.id.checkout_cart_button)
    Button mCheckoutCartButton;


    public CheckoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_checkout, container, false);
        unbinder = ButterKnife.bind(this, mRootView);
        // Setup the Adapter
        List<LineItem> tempItems = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mAdapter = new CheckoutAdapter(tempItems, getActivity(), this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        if (tempItems.size() < 1) {
            showEmptyTextMessage();
        } else {
            hideEmptyTextMessage();
        }


        return mRootView;
    }

    private void hideEmptyTextMessage() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mEmptyTextView.setVisibility(View.GONE);
    }

    private void showEmptyTextMessage() {
        mRecyclerView.setVisibility(View.GONE);
        mEmptyTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemDeleted(LineItem item) {

    }

    @Override
    public void onItemQtyChange(LineItem item, int qty) {

    }
}
