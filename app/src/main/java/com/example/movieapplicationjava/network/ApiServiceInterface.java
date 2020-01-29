package com.example.movieapplicationjava.network;

import com.example.movieapplicationjava.models.Movie;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServiceInterface {

    @GET("json/movies.json")
    Call<ArrayList<Movie>> getMoviesJSON();

}
