package com.example.mainexample.ui.view.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mainexample.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<RecyclerDataItem> listItemRecycler;
    ArrayList<RecyclerDataItem> arrayListItemRecycler;
    private Context context;

    public RecyclerAdapter(List<RecyclerDataItem> listItemRecycler, Context context) {
        this.listItemRecycler = listItemRecycler;
        this.arrayListItemRecycler = new ArrayList<>(listItemRecycler);
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.imAvatar.setImageResource(listItemRecycler.get(i).getImg());
        viewHolder.txtName.setText(listItemRecycler.get(i).getName());
        viewHolder.txtPrice.setText(listItemRecycler.get(i).getPrice());
        viewHolder.btnMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Mua " + viewHolder.txtName.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItemRecycler.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imAvatar;
        TextView txtName, txtPrice;
        Button btnMua;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imAvatar = itemView.findViewById(R.id.iv_avatar);
            txtName = itemView.findViewById(R.id.tv_name);
            txtPrice = itemView.findViewById(R.id.tv_price);
            btnMua = itemView.findViewById(R.id.bt_mua);
        }
    }

    public  void filter(String string) {
        string = string.toLowerCase(Locale.getDefault());
        listItemRecycler.clear();
        if (string.length() == 0) {
            listItemRecycler.addAll(arrayListItemRecycler);
        } else {
            for (RecyclerDataItem item : arrayListItemRecycler) {
                if (item.getName().toLowerCase(Locale.getDefault()).contains(string)) {
                    listItemRecycler.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}
