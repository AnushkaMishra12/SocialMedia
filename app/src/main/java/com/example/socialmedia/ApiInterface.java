package com.example.socialmedia;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("photos/")
    Call<List<Photos>> getPhotos(
            @Query("client_id") String clientId,
            @Query("page") int page
    );
}
