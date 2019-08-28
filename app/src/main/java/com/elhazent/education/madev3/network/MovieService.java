package com.elhazent.education.madev3.network;

import com.elhazent.education.madev3.model.ResponseMovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {
    @GET("movie/now_playing")
    Call<ResponseMovies> getMovies(
            @Query("api_key") String api_key,
            @Query("language") String language
    );

    @GET("tv/popular")
    Call<ResponseMovies> getTvshow(
            @Query("api_key") String api_key,
            @Query("language") String language
    );
}
