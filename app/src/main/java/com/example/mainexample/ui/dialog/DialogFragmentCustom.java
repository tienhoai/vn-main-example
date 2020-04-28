package com.example.mainexample.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mainexample.R;

import java.util.Objects;

public class DialogFragmentCustom extends Fragment {
    TextView tvDangNhap;
    String teDangNhap = "";

    private void mapping(View view) {
        tvDangNhap = view.findViewById(R.id.tv_dang_nhap);
    }

    private void onCLick() {

        tvDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCustom();
            }
        });
    }

    private void dialogCustom() {
        final Dialog dialog = new Dialog(Objects.requireNonNull(getContext()));
        dialog.setContentView(R.layout.dialog_popup);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        final EditText etTen = dialog.findViewById(R.id.et_ten),
                etMatKhau = dialog.findViewById(R.id.et_mat_khau);
        Button btHuy = dialog.findViewById(R.id.bt_huy),
                btDangNhap = dialog.findViewById(R.id.bt_dang_nhap);

        btHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teDangNhap = etTen.getText().toString();
                dialog.dismiss();
                Toast.makeText(getContext(), teDangNhap + " bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment, container, false);
        mapping(view);
        onCLick();
        return view;
    }

    public String getTitle() {
        return "Dialog Custom";
    }
}
