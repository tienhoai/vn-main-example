package com.example.mainexample.ui.AsyncTask;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mainexample.R;

public class AsyncTaskFragment extends Fragment {
    Button btnLoad;
    ImageView imgLoad;

    private void mapping(View view) {
        btnLoad = view.findViewById(R.id.bt_load_img);
        imgLoad = view.findViewById(R.id.iv_load);
    }

    private void loadImg() {

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoadImgInternet(imgLoad, getActivity()).execute("https://i2.wp.com/nokiapoweruser.com/wp-content/uploads/2019/10/nokia_9_1_pureview-camera.png?fit=1509%2C932&ssl=1");
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.asynctask_fragment, container, false);
        mapping(view);
        loadImg();
        return view;
    }
}
