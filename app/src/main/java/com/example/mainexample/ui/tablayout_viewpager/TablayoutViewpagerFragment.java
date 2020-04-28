package com.example.mainexample.ui.tablayout_viewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mainexample.R;
import com.example.mainexample.ui.view.recyclerview.RecyclerviewFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TablayoutViewpagerFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    List<TabViewData> tabViewDatas;

    private void mapping(View view) {
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.view_pager);
        tabViewDatas = new ArrayList<>();
    }

    private void getListTabView() {
        tabViewDatas.add(new TabViewData("Sản phẩm mới", new RecyclerviewFragment()));
        tabViewDatas.add(new TabViewData("Trang điểm", new RecyclerviewFragment()));
        tabViewDatas.add(new TabViewData("Chăm sóc da", new RecyclerviewFragment()));
    }

    private void addTabView() {
        getListTabView();
        FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
        TabViewAdapter tabViewAdapter = new TabViewAdapter(fragmentManager, tabViewDatas);
        viewPager.setAdapter(tabViewAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tablayout_viewpager_fragment, container, false);
        mapping(view);
        addTabView();
        return view;
    }

    public String getTitle() {
        return "TabLayout VIewPager";
    }
}
