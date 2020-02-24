package com.example.movieapplicationjava.models;

import androidx.annotation.NonNull;

import com.example.movieapplicationjava.interfaces.SplashInterface;
import com.example.movieapplicationjava.network.ApiServiceInterface;
import com.example.movieapplicationjava.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashModel implements SplashInterface.Model {

    @Override
    public void getMovieList(OnFinishedListener onFinishedListener) {

        ApiServiceInterface api = RetrofitClient.getApiService(); //Creating an object of our api interface
        Call<ArrayList<Movie>> call = api.getMoviesJSON(); //Calling JSON

        call.enqueue(new Callback<ArrayList<Movie>>() { //Enqueue Callback will be call when get response...
            @Override
            public void onResponse(@NonNull Call<ArrayList<Movie>> call, @NonNull Response<ArrayList<Movie>> response) {
                if (response.isSuccessful()) {
                    List<Movie> movieArrayList = response.body();
                    onFinishedListener.onFinished(movieArrayList);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Movie>> call, @NonNull Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }
}
