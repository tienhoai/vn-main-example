package com.example.mainexample;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.example.mainexample.ui.async_task.AsyncTaskFragment;
import com.example.mainexample.ui.dialog.DialogFragmentCustom;
import com.example.mainexample.ui.json.JsonFragment;
import com.example.mainexample.ui.tablayout_viewpager.TablayoutViewpagerFragment;
import com.example.mainexample.ui.view.listview.ListviewFragment;
import com.example.mainexample.ui.view.recyclerview.RecyclerviewFragment;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    final String devDebug = "Dev-check----------";
    DrawerLayout drawerLayoutAppBarContent;
    Toolbar toolbarAppBarContent;
    NavigationView navAppBarContent;

    void mapping() {
        drawerLayoutAppBarContent = findViewById(R.id.dl_app_bar_content);
        toolbarAppBarContent = findViewById(R.id.tb_app_bar_content);
        navAppBarContent = findViewById(R.id.nav_app_bar_content);
    }


    //---header---
    void setStatusBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    void setToolBar() {
        setSupportActionBar(toolbarAppBarContent);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Main");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
    }


    //---set-menu-tool-bar---
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case android.R.id.home: {
                Log.e(devDebug, "Click home icon");
                drawerLayoutAppBarContent.openDrawer(navAppBarContent);
                break;
            }

            default: {
                break;
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }


    //---set-navigation---
    void navView() {

        drawerLayoutAppBarContent.addDrawerListener(new DrawerLayout.DrawerListener() {

            @Override
            public void onDrawerSlide(@NonNull View view, float v) {

            }

            @Override
            public void onDrawerOpened(@NonNull View view) {
                Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
                Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });

        navAppBarContent.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem navItem) {

                switch (navItem.getItemId()) {

                    case R.id.listview_item: {
                        Log.e(devDebug, "Click listview_item");
                        replaceFragment(new ListviewFragment(), new ListviewFragment().getTitle());
                        drawerLayoutAppBarContent.closeDrawer(navAppBarContent);
                        break;
                    }

                    case R.id.recyclerview_item: {
                        Log.e(devDebug, "Click recyclerview_item");
                        replaceFragment(new RecyclerviewFragment(), new RecyclerviewFragment().getTitle());
                        drawerLayoutAppBarContent.closeDrawer(navAppBarContent);
                        break;
                    }

                    case R.id.asynctask_item: {
                        Log.e(devDebug, "Click asynctask_item");
                        replaceFragment(new AsyncTaskFragment(), new AsyncTaskFragment().getTitle());
                        drawerLayoutAppBarContent.closeDrawer(navAppBarContent);
                        break;
                    }

                    case R.id.json_item: {
                        replaceFragment(new JsonFragment(), new JsonFragment().getTitle());
                        drawerLayoutAppBarContent.closeDrawer(navAppBarContent);
                        break;
                    }

                    case R.id.tab_view_item: {
                        replaceFragment(new TablayoutViewpagerFragment(), new TablayoutViewpagerFragment().getTitle());
                        drawerLayoutAppBarContent.closeDrawer(navAppBarContent);
                        break;
                    }

                    case R.id.dialog_item: {
                        replaceFragment(new DialogFragmentCustom(), new DialogFragmentCustom().getTitle());
                        drawerLayoutAppBarContent.closeDrawer(navAppBarContent);
                        break;
                    }

                    default: {
                        break;
                    }
                }
                return true;
            }
        });
    }


    //--replace-fragment---
    private void replaceFragment(Fragment fragment, String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_app_bar_content, fragment, title);
        fragmentTransaction.addToBackStack(title);
        fragmentTransaction.commit();
    }



    @Override   //===--On-Create--==================================================================
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        setContentView(R.layout.activity_main);
        mapping();
        setToolBar();
        navView();
        replaceFragment(new RecyclerviewFragment(), new RecyclerviewFragment().getTitle());
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        int count = fm.getBackStackEntryCount();
        if (count >= 2) {
            fm.popBackStack();
            Objects.requireNonNull(getSupportActionBar()).setTitle(fm.getBackStackEntryAt(count-2).getName());
        } else {
            super.onBackPressed();
            Objects.requireNonNull(getSupportActionBar()).setTitle("Main");
        }
    }
}
