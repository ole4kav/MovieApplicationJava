package com.example.movieapplicationjava.presenters;

import com.example.movieapplicationjava.interfaces.MovieDetailsInterface;
import com.example.movieapplicationjava.models.Movie;

public class MovieDetailsPresenter implements MovieDetailsInterface.Presenter {


    private MovieDetailsInterface.View view;


    public MovieDetailsPresenter(MovieDetailsInterface.View view) {
        this.view = view;
    }


    @Override
    public void setData(Movie movie) {
        view.setData(movie);
    }

}
