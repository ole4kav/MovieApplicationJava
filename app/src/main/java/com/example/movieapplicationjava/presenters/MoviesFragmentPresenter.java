package com.example.movieapplicationjava.presenters;

import com.example.movieapplicationjava.interfaces.MoviesFragmentInterface;
import com.example.movieapplicationjava.models.Movie;

import java.util.ArrayList;
import java.util.Collections;

public class MoviesFragmentPresenter implements MoviesFragmentInterface.Presenter {


    private MoviesFragmentInterface.View view;


    public MoviesFragmentPresenter(MoviesFragmentInterface.View view) {
        this.view = view;
    }


    @Override
    public ArrayList<Movie> sortMovieList(ArrayList<Movie> movieArrayList) {
        Collections.sort(movieArrayList, (movie1, movie2) ->
                movie1.getReleaseYear().compareTo(movie2.getReleaseYear()));
        return movieArrayList;
    }


    @Override
    public void openNextFragment(Movie movie) {
        view.openNextFragment(movie);
    }

}