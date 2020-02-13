package com.example.movieapplicationjava.presenters;

import androidx.annotation.NonNull;

import com.example.movieapplicationjava.network.RetrofitClient;
import com.example.movieapplicationjava.network.ApiServiceInterface;
import com.example.movieapplicationjava.interfaces.SplashInterface;
import com.example.movieapplicationjava.models.Movie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashPresenter implements SplashInterface.Presenter {

    private SplashInterface.View view;
    private List<Movie> movieArrayList = new ArrayList<>();

    public SplashPresenter(SplashInterface.View view) {
        this.view = view;
    }

    @Override
    public void downloadJson() {
        // TODO: 2020-02-14 server request is a logic operation so you should do it in the presenter and return the response with callback
        //  (Recommended to do as we saw in the Architecture lecture)
        ApiServiceInterface api = RetrofitClient.getApiService(); //Creating an object of our api interface
        Call<ArrayList<Movie>> call = api.getMoviesJSON(); //Calling JSON

        call.enqueue(new Callback<ArrayList<Movie>>() { //Enqueue Callback will be call when get response...
            @Override
            public void onResponse(@NonNull Call<ArrayList<Movie>> call, @NonNull Response<ArrayList<Movie>> response) {

                if (response.isSuccessful()) {
                    movieArrayList = response.body();
                    view.openNextActivity(movieArrayList);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Movie>> call, @NonNull Throwable t) {
                t.getMessage();
            }
        });

    }


}
