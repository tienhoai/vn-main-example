package com.example.mainexample.ui.tablayout_viewpager;

import android.support.v4.app.Fragment;

public class TabViewData {
    private String title;
    private Fragment pager;

    public TabViewData(String title, Fragment pager) {
        this.title = title;
        this.pager = pager;
    }

    public String getTitle() {
        return title;
    }

    public Fragment getPager() {
        return pager;
    }
}
