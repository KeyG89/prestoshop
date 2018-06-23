package mobile.viali.prontoshop.ui.productList;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import mobile.viali.prontoshop.R;
import mobile.viali.prontoshop.core.listeners.OnProductSelectedListener;
import mobile.viali.prontoshop.model.LineItem;
import mobile.viali.prontoshop.model.Product;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment implements OnProductSelectedListener,  ProductListContract.View {
    private View mRootView;
    private ProductListAdapter mAdapter;
    private ProductListContract.Action mPresenter;

    @BindView(R.id.fab)
    FloatingActionButton fab;
    Unbinder unbinder;
    @BindView(R.id.product_list_recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.empty_text)
    TextView mEmptyText;


    public ProductListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_product, container, false);
        unbinder = ButterKnife.bind(this, mRootView);
        mPresenter = new ProductPresenter(this);

        //setup Adapter
        List<Product> tempProducts = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mAdapter = new ProductListAdapter(tempProducts, getActivity(), this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);



        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.loadProducts();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fab)
    public void onViewClicked() {
    }

    @Override
    public void onSelectedProduct(Product selectedProduct) {

    }

    @Override
    public void onLongClickProduct(Product clickedProduct) {

    }

    @Override
    public void showProducts(List<Product> products) {
        // this is where we show the products
        mAdapter.replaceData(products);

    }

    @Override
    public void showAddProductsForm() {
        // show a dialog to add Product

    }

    @Override
    public void showEditProductForm(Product product) {
        // show a dialog to edit Product

    }

    @Override
    public void showDeleteProducPrompt(Product product) {
        // show alert dialog
    }

    @Override
    public void showGoogleSearch(Product product) {
        // show google search

    }

    @Override
    public void showEmptyText() {
        mRecyclerView.setVisibility(View.GONE);
        mEmptyText.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyText() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mEmptyText.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT);
    }

    @Override
    public void addItemToCart(LineItem item) {

    }
}
