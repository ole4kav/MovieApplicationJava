package com.example.movieapplicationjava.presenters;

import com.example.movieapplicationjava.interfaces.MoviesFragmentInterface;
import com.example.movieapplicationjava.models.Movie;

import java.util.ArrayList;
import java.util.Collections;

public class MoviesFragmentPresenter implements MoviesFragmentInterface.Presenter {

    private MoviesFragmentInterface.View view;
    private ArrayList<Movie> movieArrayList;


    public MoviesFragmentPresenter(MoviesFragmentInterface.View view) {
        this.view = view;
    }

    @Override
    public void setMovieList(ArrayList<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
    }

    @Override
    public ArrayList<Movie> getSortedMovieList() {
        Collections.sort(movieArrayList, (movie1, movie2) ->
                movie1.getReleaseYear().compareTo(movie2.getReleaseYear()));
        return movieArrayList;
    }


    @Override
    public void openNextFragment(Movie movie) {
        view.openNextFragment(movie);
    }

}