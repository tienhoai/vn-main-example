package com.example.mainexample.ui.json;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mainexample.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class JsonProductAdapter extends RecyclerView.Adapter<JsonProductAdapter.ViewHolder> {
    private List<JsonDataItem> listProduct;
    private Context context;

    public JsonProductAdapter(List<JsonDataItem> listProduct, Context context) {
        this.listProduct = listProduct;
        this.context = context;
    }

    @NonNull
    @Override
    public JsonProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull JsonProductAdapter.ViewHolder viewHolder, int i) {
        Picasso.with(context).load(listProduct.get(i).getHinh()).into(viewHolder.imgAvatar);
        viewHolder.txtName.setText(listProduct.get(i).getTen());
        viewHolder.txtPrice.setText(listProduct.get(i).getGia());
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView txtName, txtPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.iv_avatar);
            txtName = itemView.findViewById(R.id.tv_name);
            txtPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}
