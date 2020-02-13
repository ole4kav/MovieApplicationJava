package com.example.movieapplicationjava.presenters;

import com.example.movieapplicationjava.interfaces.MoviesFragmentInterface;
import com.example.movieapplicationjava.models.Movie;

import java.util.ArrayList;
import java.util.Collections;

public class MoviesFragmentPresenter implements MoviesFragmentInterface.Presenter {


    private MoviesFragmentInterface.View view;
//    private ArrayList<Movie> movieArrayList; // TODO: 2020-02-14 add the data to the presenter


    public MoviesFragmentPresenter(MoviesFragmentInterface.View view) {
        this.view = view;
    }


    @Override
    public ArrayList<Movie> sortMovieList(ArrayList<Movie> movieArrayList) {
        Collections.sort(movieArrayList, (movie1, movie2) ->
                movie1.getReleaseYear().compareTo(movie2.getReleaseYear()));
        return movieArrayList;
    }


    // TODO: 2020-02-13  ->  you need to split the method above to two different methods

    // first for saving the data list ->  void setMovieList(ArrayList<Movie> movieArrayList)
    /*
    public void setMovieList(ArrayList<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
    }
    */

    //  Second for retrieving the data list ->  ArrayList<Movie> getSortedMovieList()
    /*
    public ArrayList<Movie> getSortedMovieList() {
        Collections.sort(movieArrayList, (movie1, movie2) ->
                movie1.getReleaseYear().compareTo(movie2.getReleaseYear()));
        return movieArrayList;
    }
     */


    @Override
    public void openNextFragment(Movie movie) {
        view.openNextFragment(movie);
    }

}