package com.example.careconnect.api;

import com.example.careconnect.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    // ✅ OPTION 1: Top headlines (simple)
    @GET("v2/top-headlines")
    Call<NewsResponse> getTopHeadlines(
            @Query("country") String country,
            @Query("category") String category,
            @Query("apiKey") String apiKey
    );

    // ✅ OPTION 2: Search everything (BEST)
    @GET("v2/everything")
    Call<NewsResponse> getEverything(
            @Query("q") String query,
            @Query("apiKey") String apiKey
    );
}