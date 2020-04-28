package com.example.mainexample.ui.json;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mainexample.R;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JsonFragment extends Fragment {
    RecyclerView recyclerView;

    private void mapping(View view) {
        recyclerView = view.findViewById(R.id.recycler_view_json);
    }

    private void loadProduct(String url) {
        OkHttpClient client = new OkHttpClient();
        Moshi moshi = new Moshi.Builder().build();
        Type productType = Types.newParameterizedType(List.class, JsonDataItem.class);
        final JsonAdapter<List<JsonDataItem>> jsonAdapter = moshi.adapter(productType);
        final Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                final List<JsonDataItem> products = jsonAdapter.fromJson(json); //do du lieu json vao list

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                        recyclerView.setAdapter(new JsonProductAdapter(products, getContext()));
                    }
                });
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.json_fragment, container, false);
        mapping(view);
        loadProduct("https://android-data.000webhostapp.com/data/vns-demo/get-data-product.php");
        return view;
    }

    public String getTitle() {
        return "Json";
    }
}
