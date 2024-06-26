package com.example.socialmedia;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private static final String CLIENT_ID = "WXnJxqPRDJBvjGQIJj0fcqXwvYiDGmUgT3zP5FmpHz4";
    private RecyclerView recyclerView;
    private PhotoAdapter photoAdapter;
    private BannerAdapter bannerAdapter;
    private RecyclerView banner_recycler;
    LinearLayoutManager linearLayoutManager;

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        banner_recycler = view.findViewById(R.id.banner_recycler);
        linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, true);
        banner_recycler.setLayoutManager(linearLayoutManager);

        fetchBanner();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fetchPhotos();
        return view;

    }

    private void fetchBanner() {
        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<Photos>> call = apiInterface.getPhotos(CLIENT_ID, 8);
        call.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(@NonNull Call<List<Photos>> call, @NonNull Response<List<Photos>> response) {
                if (response.isSuccessful()) {
                    List<Photos> photos = response.body();
                    bannerAdapter = new BannerAdapter(getContext(), photos);
                    banner_recycler.setAdapter(bannerAdapter);
                    Timer t = new Timer();
                    t.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if (linearLayoutManager.findLastCompletelyVisibleItemPosition() < (bannerAdapter.getItemCount() - 1)) {
                                linearLayoutManager.smoothScrollToPosition(banner_recycler, new RecyclerView.State(),
                                        linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1);
                            } else {
                                linearLayoutManager.smoothScrollToPosition(banner_recycler,new RecyclerView.State(), 0);
                            }
                        }

                    }, 0, 3000);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Photos>> call, @NonNull Throwable t) {
                Log.e("PhotoListFragment", "Error fetching photos", t);
            }
        });
    }

    private void fetchPhotos() {
        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<Photos>> call = apiInterface.getPhotos(CLIENT_ID, 3);

        call.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(@NonNull Call<List<Photos>> call, @NonNull Response<List<Photos>> response) {
                if (response.isSuccessful()) {
                    List<Photos> photos = response.body();
                    photoAdapter = new PhotoAdapter(getContext(), photos);
                    recyclerView.setAdapter(photoAdapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Photos>> call, @NonNull Throwable t) {
                Log.e("PhotoListFragment", "Error fetching photos", t);
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}