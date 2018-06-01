package mobile.viali.prontoshop.ui.productList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.viali.prontoshop.R;
import mobile.viali.prontoshop.core.listeners.OnProductSelectedListener;
import mobile.viali.prontoshop.model.Product;
import mobile.viali.prontoshop.util.Formatter;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private List<Product> mProducts;
    private final Context mContext;
    private final OnProductSelectedListener mListener;

    public ProductListAdapter(List<Product> mProducts, Context mContext, OnProductSelectedListener mListener) {
        this.mProducts = mProducts;
        this.mContext = mContext;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_product_list, parent, false);
        ViewHolder viewholder = new ViewHolder(rootView);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mProducts != null) {
            Product product = mProducts.get(position);
            Picasso.get()
                    .load(product.getImagePath())
                    .fit()
                    .placeholder(R.drawable.ic_photo)
                    .into(holder.productImage);

            holder.productName.setText(product.getPromoMessage());
            holder.category.setText(product.getCategoryName());
            holder.productPrice.setText(Formatter.formatCurrency(product.getSalePrice()));
            String producDescription = product.getDescription();
            String shortDescription = producDescription.substring(0, Math.min(producDescription.length(), 70));
            holder.description.setText(shortDescription);
        }
    }

    @Override
    public int getItemCount() {
        if (mProducts != null) {
            return mProducts.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        @BindView(R.id.text_view_product_name)
        TextView productName;
        @BindView(R.id.textview_product_category)
        TextView category;
        @BindView(R.id.textview_product_price)
        TextView productPrice;
        @BindView(R.id.textview_product_description)
        TextView description;
        @BindView(R.id.image_view_add_to_cart_button)
        ImageView addToCartButton;
        @BindView(R.id.product_image)
        ImageView productImage;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            addToCartButton.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            Product selectedProduct = mProducts.get(getLayoutPosition());
            mListener.onSelectedProduct(selectedProduct);
        }

        @Override
        public boolean onLongClick(View v) {
            Product clickedProduct = mProducts.get(getLayoutPosition());
            mListener.onLongClickProduct(clickedProduct);
            return false;
        }
    }
}
