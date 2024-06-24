package com.example.socialmedia;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private static final String CLIENT_ID = "WXnJxqPRDJBvjGQIJj0fcqXwvYiDGmUgT3zP5FmpHz4";
    private RecyclerView recyclerView;
    private PhotoAdapter photoAdapter;
    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fetchPhotos();
        return view;
    }

    private void fetchPhotos() {
        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<Photos>> call = apiInterface.getPhotos(CLIENT_ID, 1);

        call.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                if (response.isSuccessful()) {
                    List<Photos> photos = response.body();
                    photoAdapter = new PhotoAdapter(getContext(), photos);
                    recyclerView.setAdapter(photoAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {
                Log.e("PhotoListFragment", "Error fetching photos", t);
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView open_image = view.findViewById(R.id.open_image);
        open_image.setOnClickListener(v -> {
            Intent i = new Intent(requireContext(), ImageActivity.class);
            startActivity(i);
        });
    }
}