package mobile.viali.prontoshop.ui.checkout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.viali.prontoshop.R;
import mobile.viali.prontoshop.core.listeners.CartActionsListener;
import mobile.viali.prontoshop.model.LineItem;
import mobile.viali.prontoshop.util.Formatter;


public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.ViewHolder> {

    private List<LineItem> mLineItems;
    private Activity mContext;
    private final CartActionsListener mListener;

    public CheckoutAdapter(List<LineItem> mLineItems, Context mContext, CartActionsListener mListener) {
        this.mLineItems = mLineItems;
        this.mContext = (Activity) mContext;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_shopping_cart_items, parent, false);
        ViewHolder viewholder = new ViewHolder(rootView);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LineItem item = mLineItems.get(position);
        Picasso.get().load(item.getImagePath())
                .fit()
                .placeholder(R.drawable.ic_photo)
                .into(holder.productImage);

        holder.productName.setText(item.getProductName());
        holder.price.setText(Formatter.formatCurrency(item.getSalePrice()));
        holder.qtyEditText.setText(String.valueOf(item.getQauntity()));

    }

    @Override
    public int getItemCount() {
        if (mLineItems != null) {
            return mLineItems.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.product_image)
        ImageView productImage;
        @BindView(R.id.text_view_product_name)
        TextView productName;
        @BindView(R.id.text_view_price)
        TextView price;
        @BindView(R.id.edit_text_qty)
        EditText qtyEditText;
        @BindView(R.id.button_delete)
        Button deleteButton;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            deleteButton.setOnClickListener(this);
            qtyEditText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LineItem item = mLineItems.get(getLayoutPosition());
                    updateQtyDialog(item);
;                }
            });

        }

        @Override
        public void onClick(View v) {
            LineItem item = mLineItems.get(getLayoutPosition());
            mListener.onItemDeleted(item);

        }

        private void updateQtyDialog(final LineItem item) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
            LayoutInflater inflater = mContext.getLayoutInflater();

            View rootView = inflater.inflate(R.layout.dialog_enter_item_qty, null);
            dialog.setView(rootView);

            View titleView = inflater.inflate(R.layout.dialog_title, null);
            TextView titleText = (TextView) titleView.findViewById(R.id.text_view_dialog_title);

            titleText.setText(item.getProductName());
            dialog.setCustomTitle(titleView);

            final EditText qtyEditText = (EditText) rootView.findViewById(R.id.edit_text_item_qty);
            dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(!qtyEditText.getText().toString().isEmpty()){
                        int qtyEntered = Integer.parseInt(qtyEditText.getText().toString());
                        mListener.onItemQtyChange(item, qtyEntered);
                    } else {
                        Toast.makeText(mContext, "Invalid Qty", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();


        }


    }
}
