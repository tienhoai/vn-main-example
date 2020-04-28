package com.example.mainexample.ui.tablayout_viewpager;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TabViewAdapter extends FragmentPagerAdapter {
    private List<TabViewData> listTabView;

    public TabViewAdapter(FragmentManager fm, List<TabViewData> listTabView) {
        super(fm);
        this.listTabView = listTabView;
    }

    @Override
    public int getCount() {
        return listTabView.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTabView.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int i) {
        return listTabView.get(i).getPager();
    }
}
