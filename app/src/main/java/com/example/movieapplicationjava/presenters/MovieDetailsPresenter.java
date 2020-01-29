package com.example.movieapplicationjava.presenters;

import android.os.Bundle;

import com.example.movieapplicationjava.interfaces.MovieDetailsInterface;
import com.example.movieapplicationjava.models.Movie;

public class MovieDetailsPresenter implements MovieDetailsInterface.Presenter {

    public static final String KEY_MOVIE = "movie";

    private MovieDetailsInterface.View view;
    private Movie movie;


    public MovieDetailsPresenter(MovieDetailsInterface.View view) {
        this.view = view;
    }


    @Override
    public void getMovie(Bundle args) {
        movie = args.getParcelable(KEY_MOVIE);
    }

    @Override
    public void setData() {
        view.setData(movie);
    }


}
