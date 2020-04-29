package com.example.mainexample.ui.view.recyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mainexample.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    String keySearch = "";

    private void mapping(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerAdapter = new RecyclerAdapter(listData(), getContext());
    }

    private List<RecyclerDataItem> listData() {
        List<RecyclerDataItem> list = new ArrayList<>();
        for (int stt= 0; stt < 5; stt++) {
            list.add(new RecyclerDataItem(R.drawable.product_01, "Sản Phẩm  01", "Giá: 500.000 vnd"));
            list.add(new RecyclerDataItem(R.drawable.product_02, "Sản Phẩm  02", "Giá: 500.000 vnd"));
            list.add(new RecyclerDataItem(R.drawable.product_03, "Sản Phẩm  03", "Giá: 500.000 vnd"));
            list.add(new RecyclerDataItem(R.drawable.product_04, "Sản Phẩm  04", "Giá: 500.000 vnd"));
            list.add(new RecyclerDataItem(R.drawable.product_05, "Sản Phẩm  05", "Giá: 500.000 vnd"));
        }
        return list;
    }

    private void addItemRecyclerView() {
        recyclerAdapter.filter(keySearch);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
//        recyclerView.setAdapter(new RecyclerAdapter(listData(), getContext()));
        recyclerView.setAdapter(recyclerAdapter);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview_fragment, container, false);
        mapping(view);
        addItemRecyclerView();
        return view;
    }

    public String getTitle() {
        return "Recycler View";
    }

    public void setKeySearch(String keySearch) {
        this.keySearch = keySearch;
    }
}
