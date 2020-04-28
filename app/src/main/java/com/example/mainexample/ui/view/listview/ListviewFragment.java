package com.example.mainexample.ui.view.listview;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mainexample.R;

import java.util.ArrayList;
import java.util.Objects;

public class ListviewFragment extends Fragment {
    ListView listView;
    ArrayList<String> listItem;

    private void mapping(View view) {
        listView = view.findViewById(R.id.listview);
        listItem = new ArrayList<String>();
    }

    //----------------------------------------------------------------------------------------------
    private void addItemListView() {
        listItem.add("Nokia");
        listItem.add("Samsung");
        listItem.add("Iphone");
        listItem.add("LG");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_1, listItem);
        listView.setAdapter(arrayAdapter);
    }

    private void onClickItemListView() {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Click " + listItem.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void longClickItemListView() {

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Long Click " + listItem.get(position), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listview_fragment, container, false);
        mapping(view);
        addItemListView();
        onClickItemListView();
        longClickItemListView();
        return view;
    }

    public String getTitle() {
        return "List View";
    }
}
