package mobile.viali.prontoshop.ui.customerslist;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
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
import mobile.viali.prontoshop.core.listeners.OnCustomerSelectedListener;
import mobile.viali.prontoshop.model.Customer;

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.ViewHolder> {

    private List<Customer> mCustomers;
    private final Context mContext;
    private OnCustomerSelectedListener mListener;
    private boolean shouldHighlightSelectedCustomer = false;
    private int selectedPosition = 0;

    public CustomerListAdapter(List<Customer> mCustomers, Context mContext, OnCustomerSelectedListener mListener) {
        this.mCustomers = mCustomers;
        this.mContext = mContext;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_customer_list, parent, false);
        CustomerListAdapter.ViewHolder viewholder = new CustomerListAdapter.ViewHolder(rootView);
        return viewholder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Customer selectedCustomer = mCustomers.get(position);

        holder.customerName.setText(selectedCustomer.getCustomerName());
        holder.customerEmail.setText(selectedCustomer.getEmailAddress());
        Picasso.with(mContext)
                .load(selectedCustomer.getProfileImagePath())
                .fit()
                .placeholder(R.drawable.profile_icon)
                .into(holder.customerHeadShot);

        if (shouldHighlightSelectedCustomer) {
            if (selectedPosition == position) {
                holder.itemView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.primary_light));
            } else {
                holder.itemView.setBackgroundColor(Color.TRANSPARENT);
            }
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
    }


    @Override
    public int getItemCount() {
        if (mCustomers != null) {
            return mCustomers.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.image_view_customer_head_shot)
        ImageView customerHeadShot;
        @BindView(R.id.text_view_customer_email)
        TextView customerEmail;
        @BindView(R.id.text_view_customer_name)
        TextView customerName;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            shouldHighlightSelectedCustomer =  true;
            selectedPosition = getLayoutPosition();
            Customer selectedCustomer = mCustomers.get(selectedPosition);
            mListener.onSelectCustomer(selectedCustomer);
            notifyDataSetChanged();

        }

        @Override
        public boolean onLongClick(View v) {
            Customer selectedCustomer = mCustomers.get(selectedPosition);
            mListener.onLongClickCustomer(selectedCustomer);
            return true;
        }
    }
}
