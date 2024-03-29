package com.rabbitt.momobill.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rabbitt.momobill.R;
import com.rabbitt.momobill.fragment.InvoiceFrag;
import com.rabbitt.momobill.model.ProductInvoice;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.holder> {

    private static final String TAG = "maluClientAdapter";
    private List<ProductInvoice> dataModelArrayList;
    private InvoiceFrag context;
    private OnRecyleItemListener mOnRecycleItemListener;

    public OrderAdapter(List<ProductInvoice> ClientAdap, InvoiceFrag context, OnRecyleItemListener onRecyleItemListener) {
        this.dataModelArrayList = ClientAdap;
        this.context = context;
        this.mOnRecycleItemListener = onRecyleItemListener;
    }

    @NonNull
    @Override
    public OrderAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_cart_list, null);
        return new holder(view, mOnRecycleItemListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.holder holder, int position) {

        ProductInvoice dataModel = dataModelArrayList.get(position);

        holder.product_name.setText(dataModel.getProduct_name());
        holder.units.setText(dataModel.getUnit());
        holder.price.setText(dataModel.getSale_rate());
        holder.cess.setText(dataModel.getCess());
        holder.cgst.setText(dataModel.getCgst());

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    public class holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView product_name, units, price, cess, cgst;
        OnRecyleItemListener onRecyleItemListener;

        public holder(@NonNull View itemView, OnRecyleItemListener onRecyleItemListener) {
            super(itemView);
            this.onRecyleItemListener = onRecyleItemListener;

            product_name = itemView.findViewById(R.id.txt_product);
            units = itemView.findViewById(R.id.txt_units);
            price = itemView.findViewById(R.id.txt_price);
            cess = itemView.findViewById(R.id.tax_cess);
            cgst = itemView.findViewById(R.id.txt_tax);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRecyleItemListener.OrderAdd(getAdapterPosition());
        }
    }

    public interface OnRecyleItemListener {
        void OrderAdd(int position);
    }
}