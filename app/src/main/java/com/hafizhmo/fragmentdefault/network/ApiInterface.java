package com.hafizhmo.fragmentdefault.network;

import com.hafizhmo.fragmentdefault.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("movie/now_playing")
    public Call<Movies> getMoviesNowPlaying();

    @GET("movie/popular")
    public Call<Movies> getMoviesPopular();
}
